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
import java.awt.GridLayout;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Hannah
 */
    
public class TransferFormView extends javax.swing.JPanel {

    private ArrayList<ChooseSupplyView> itemViewList;
    
    public TransferFormView() {
        initComponents();
        
        itemViewList = new ArrayList<>();
        choosePanel.setLayout(new GridLayout(0, 1, 0, 10));
        setSize(new Dimension(1100, 700));
    }
    
    void updateComboBox(ArrayList<Location> warehouseList) {
        fromComboBox.setModel(new DefaultComboBoxModel(warehouseList.toArray()));
        toComboBox.setModel(new DefaultComboBoxModel(warehouseList.toArray()));
        
        fromComboBox.setSelectedIndex(0);
        toComboBox.setSelectedIndex(1);        
    }
    
    void updateChooseSuplies() {
        int whouse_id = fromComboBox.getSelectedIndex();
        ArrayList<ChooseSupplyView> list = getItemViewList(whouse_id);
        itemViewList = new ArrayList<>();
        int size = list.size();
        ChooseSupplyView v;
        choosePanel.removeAll();
        for(int i = 0; i < size; i++) {
            v = list.get(i);
            v.setVisible(true);   
            itemViewList.add(v);
            choosePanel.add(v);
        }
        choosePanel.setPreferredSize(new Dimension(619, size*68));
        jPanel1.setPreferredSize(new Dimension(1100, jPanel1.getPreferredSize().height+(size*68)));
        choosePanel.repaint();
        choosePanel.revalidate();
    }
    
    ArrayList<ChooseSupplyView> getItemViewList(int whouse_id) {
        ArrayList<ChooseSupplyView> itemViewList = new ArrayList<>();
        String sql = 
                "SELECT supply_id as id, CONCAT(s.name, ' (', s.type, ')') as supply, count, unit\n" +
                "FROM supply s INNER JOIN location l ON s.location_id = l.location_id\n" +
                "WHERE l.location_id = ?;";
        try {
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, whouse_id);
            ResultSet rs = s.executeQuery();
            
            ChooseSupplyView v;
            while(rs.next()) {
                v = new ChooseSupplyView(rs.getInt("id"), rs.getString("supply"), rs.getString("unit"), rs.getString("count") + " " + rs.getString("unit"));
                itemViewList.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemViewList;
    }
    
    /*
    ArrayList<ChooseSupplyView> getItemViewList(String location) {
        ArrayList<ChooseSupplyView> itemViewList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT concat(supply, ' - ',type) as supply, sum(count) as count, unit \n" + 
                            "FROM inventory WHERE location = '" + location + "' GROUP BY concat(supply, ' - ',type);");
            ResultSet rs = s.executeQuery(sql);
            
            ChooseSupplyView v;
            while(rs.next()) {
                v = new ChooseSupplyView(rs.getString("supply"), rs.getString("unit"), rs.getString("count") + " " + rs.getString("unit"));
                itemViewList.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemViewList;
    }*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        fromComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        toComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        choosePanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);
        setMinimumSize(new java.awt.Dimension(1100, 700));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1100, 700));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1100, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMinimumSize(new java.awt.Dimension(1100, 690));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 690));

        fromComboBox.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Transfer From");

        jLabel8.setFont(new java.awt.Font("Quicksand Bold", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Choose Supplies");

        jLabel9.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Transfer To");

        toComboBox.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        toComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        toComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Quicksand Bold", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Choose Warehouses");

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        submitButton.setText("SUBMIT FORM");
        submitButton.setBorder(null);
        submitButton.setBorderPainted(false);
        submitButton.setContentAreaFilled(false);
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        choosePanel.setBackground(new java.awt.Color(255, 255, 255));
        choosePanel.setMaximumSize(new java.awt.Dimension(1000, 32767));
        choosePanel.setMinimumSize(new java.awt.Dimension(1000, 0));
        choosePanel.setPreferredSize(new java.awt.Dimension(1000, 0));

        javax.swing.GroupLayout choosePanelLayout = new javax.swing.GroupLayout(choosePanel);
        choosePanel.setLayout(choosePanelLayout);
        choosePanelLayout.setHorizontalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        choosePanelLayout.setVerticalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(toComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(choosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(choosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(403, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        updateChooseSuplies();
    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void toComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toComboBoxActionPerformed
        
    }//GEN-LAST:event_toComboBoxActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        String whouseA = fromComboBox.getSelectedItem().toString();
        String whouseB = toComboBox.getSelectedItem().toString();
        int whouseA_id = ((Location)fromComboBox.getSelectedItem()).getID();
        int whouseB_id = ((Location)toComboBox.getSelectedItem()).getID();
        
        System.out.println("> " + whouseA_id + ", " + whouseB_id);
        
        if(whouseA_id != whouseB_id) {
            TransferSubmitView s = new TransferSubmitView(this, whouseA, whouseB, whouseA_id, whouseB_id, itemViewList);
            MainView.frame.setMainPanel(s);
        }
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel choosePanel;
    private javax.swing.JComboBox<String> fromComboBox;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    private javax.swing.JComboBox<String> toComboBox;
    // End of variables declaration//GEN-END:variables
}
