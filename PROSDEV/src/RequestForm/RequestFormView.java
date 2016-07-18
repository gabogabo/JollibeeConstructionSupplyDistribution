/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestForm;

import TransferForm.*;
import Database.DB;
import static Database.DB.con;
import Main.MainView;
import java.awt.Dimension;
import java.awt.GridLayout;
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
public class RequestFormView extends javax.swing.JPanel {

    private ArrayList<ChooseSupplyView> itemViewList;
    
    public RequestFormView() {
        initComponents();
        
        itemViewList = new ArrayList<>();
        choosePanel.setLayout(new GridLayout(0, 1, 0, 10));
        setSize(new Dimension(1100, 700));
    }
    
    void updateChooseSuplies() {
//        String location = fromComboBox.getSelectedItem().toString();
        ArrayList<ChooseSupplyView> list = getItemViewList();
        int size = list.size();
        ChooseSupplyView v;
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
    
    ArrayList<ChooseSupplyView> getItemViewList() {
        ArrayList<ChooseSupplyView> itemViewList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT concat(supply, ' - ',type) as supply, sum(count) as count, unit \n" + 
                            "FROM inventory GROUP BY concat(supply, ' - ',type);");
            ResultSet rs = s.executeQuery(sql);
            
            ChooseSupplyView v;
            while(rs.next()) {
                v = new ChooseSupplyView(1, rs.getString("supply"), rs.getString("unit"), rs.getString("count") + " " + rs.getString("unit"));
                itemViewList.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemViewList;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
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

        jLabel8.setFont(new java.awt.Font("Quicksand Bold", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Choose Supplies");

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
        choosePanel.setMaximumSize(new java.awt.Dimension(960, 32767));
        choosePanel.setMinimumSize(new java.awt.Dimension(960, 0));

        javax.swing.GroupLayout choosePanelLayout = new javax.swing.GroupLayout(choosePanel);
        choosePanel.setLayout(choosePanelLayout);
        choosePanelLayout.setHorizontalGroup(
            choosePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(choosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(choosePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(622, Short.MAX_VALUE))
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

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        RequestSubmitView s = new RequestSubmitView(this, itemViewList);
        MainView.frame.setMainPanel(s);
    }//GEN-LAST:event_submitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel choosePanel;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    protected javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
