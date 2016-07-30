/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;
import Database.DB;
import static Database.DB.con;
import Main.MainView;
import java.awt.Dimension;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Hannah
 */
public class TransferSubmitView extends javax.swing.JPanel {
    private JPanel form;
    int size;
    ArrayList<ChooseSupplyView> itemViewList;
    String whouseA, whouseB;
    int whouseA_id, whouseB_id;
    
    public TransferSubmitView(TransferFormView form, String whousA, String whouseB, 
                                int whouseA_id, int whouseB_id, 
                                ArrayList<ChooseSupplyView> itemViewList) {
        initComponents();
        setSize(new Dimension(1100, 700));

        this.form = form;
        this.whouseA = whousA;
        this.whouseB = whouseB;
        this.whouseA_id = whouseA_id;
        this.whouseB_id = whouseB_id;
        formDesc.setText("Transfer From " + whousA + " to " + whouseB);
        
        size = itemViewList.size();
        String text = "";
        this.itemViewList = itemViewList;
        ChooseSupplyView v;
        for(int i = 0; i < size; i++) {
            v = itemViewList.get(i);
            text += v.getItemName() + ": " + v.getUserCountInput() + " " + v.getUnit() + "\n";
        }
        
        itemList.setText(text);
    }
    
    private String getDate() {
        Date date = new Date( );
        SimpleDateFormat f = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String dateStr = f.format(date);
        return dateStr;
    }
    
    private String getDistID() {
        String dist_id = "";
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT MAX(dist_id)+1 as 'id' FROM distributions;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                dist_id = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dist_id;
    }
    
    private void updateDatabase() {
        String dist_id = getDistID();
        
        // update table supply transfer
        String sql = 
            "INSERT INTO distributions\n" +
            "(to_location_id, from_location_id, date_filed, type)\n" +
            "VALUES\n" +
            "(?, ?, ?, ?);";
        
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, whouseA_id);
            s.setInt(2, whouseB_id);
            s.setString(3, getDate());
            s.setString(4, "transfer");
            s.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // update table orders
        
        ChooseSupplyView temp;
        String sqlX = 
            "INSERT INTO orders\n" +
            "(order_id, supply_id, count)\n" +
            "VALUES\n" +
            "(?, ?, ?);";
        try {
            PreparedStatement s = con.prepareStatement(sqlX);
            for(int i = 0; i < itemViewList.size(); i++) {
                temp = itemViewList.get(i);
                s.setString(1, dist_id);
                s.setInt(2, temp.getSupplyID());
                s.setFloat(3, temp.getUserCountInput());
                s.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        confirmButton = new javax.swing.JButton();
        formDesc = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemList = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);

        confirmButton.setBackground(new java.awt.Color(255, 255, 255));
        confirmButton.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        confirmButton.setText("CONFIRM");
        confirmButton.setBorder(null);
        confirmButton.setBorderPainted(false);
        confirmButton.setContentAreaFilled(false);
        confirmButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmButton.setFocusPainted(false);
        confirmButton.setHideActionText(true);
        confirmButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        formDesc.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        formDesc.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        formDesc.setText("Transfer From Warehouse A to Warehouse B");

        jLabel8.setFont(new java.awt.Font("Quicksand Book Oblique", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Supplies to transfer:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        itemList.setEditable(false);
        itemList.setColumns(20);
        itemList.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        itemList.setRows(5);
        itemList.setEnabled(false);
        itemList.setFocusable(false);
        itemList.setRequestFocusEnabled(false);
        itemList.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(itemList);

        backButton.setBackground(new java.awt.Color(255, 255, 255));
        backButton.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        backButton.setText("BACK");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(826, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 799, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(formDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(137, 137, 137))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        updateDatabase();
        
        FinishedView v = new FinishedView();
        /* DISREGARD
        ChooseSupplyView view;
        for(int i = 0; i < size; i++){
            view = iVL.get(i);
            //get locA and locB
            //place in supply table and supply_transfer table?
            //execute sql statement
            try{
                
                Statement s = con.createStatement();
                String sql = "INSERT into some"
                s.executeQuery(sql);
                      
            }
            catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        MainView.frame.setMainPanel(v);
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainView.frame.setMainPanel(form);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel formDesc;
    private javax.swing.JTextArea itemList;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
