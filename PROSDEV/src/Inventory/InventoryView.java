/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import static Database.DB.con;
import java.sql.PreparedStatement;

/**
 *
 * @author Hannah
 */
public class InventoryView extends javax.swing.JFrame {

    
    /**
     * Creates new form InventoryView
     */
    public InventoryView() {
        initComponents();
    }
    
    void updateComboBox(ArrayList<String> warehouseList, ArrayList<String> supplyList) {
        warehouseList.add(0, "Show All");
        supplyList.add(0, "Show All");
        
        warehouseComboBox.setModel(new DefaultComboBoxModel(warehouseList.toArray()));
        supplyComboBox.setModel(new DefaultComboBoxModel(supplyList.toArray()));
        
        warehouseComboBox.setSelectedItem("Show All");
        supplyComboBox.setSelectedItem("Show All");
    }
    
    void updateTable(int whouse_id, String supply_name) {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Supply");
        model.addColumn("Type");
        model.addColumn("Count");
        
        boolean hasWhouse = false, hasSupply = false;
        String where = "";
        if(whouse_id != -1 && !supply_name.equals("Show All")) {
            where = "WHERE l.location_id = ? and s.name = ?";
            hasWhouse = true;
            hasSupply = true;
        }
        else if(whouse_id != -1) {
            where = "WHERE l.location_id = ?";
            hasWhouse = true;
        }
        else if(!supply_name.equals("Show All")) {
            where = "WHERE s.name = ?";
            hasSupply = true;
        }
        
        /*
        String sql = 
            "SELECT s.name AS 'supply', type, SUM(count) as count, unit\n" +
            "FROM supply s INNER JOIN warehouse w ON s.whouse_id = w.whouse_id\n" +
            where + "\n" +
            "GROUP BY CONCAT(supply, type)\n" +
            "ORDER BY supply_id;";
        */
        
        String sql = 
            "SELECT s.name AS 'supply', s.type, SUM(count) as count, unit\n" +
            "FROM supply s INNER JOIN location l ON s.location_id = l.location_id\n" +
            where + "\n" +
            "GROUP BY CONCAT(supply, s.type)\n" +
            "ORDER BY supply_id;";
        
        try {
            PreparedStatement s = con.prepareStatement(sql);
            
            if(hasWhouse && hasSupply) {
                s.setInt(1, whouse_id);
                s.setString(2, supply_name);
            }
            else if(hasWhouse) {
                s.setInt(1, whouse_id); 
            }
            else if(hasSupply) {
                s.setString(1, supply_name);
            }
            
            ResultSet rs = s.executeQuery();
            
            ArrayList row;
            while(rs.next()) {
                row = new ArrayList();
                row.add(rs.getString("supply"));
                row.add(rs.getString("type"));
                row.add(rs.getString("count") + " " + rs.getString("unit"));
                model.addRow(row.toArray());
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inventoryPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        warehouseComboBox = new javax.swing.JComboBox<>();
        supplyComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        inventoryPanel.setBackground(new java.awt.Color(255, 255, 255));
        inventoryPanel.setPreferredSize(new java.awt.Dimension(1100, 700));

        jLabel1.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Warehouse");

        jTable1.setFont(new java.awt.Font("Roboto Lt", 0, 20)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(35);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        warehouseComboBox.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        warehouseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        warehouseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseComboBoxActionPerformed(evt);
            }
        });

        supplyComboBox.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        supplyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        supplyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplyComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Quicksand Book", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Supply");

        javax.swing.GroupLayout inventoryPanelLayout = new javax.swing.GroupLayout(inventoryPanel);
        inventoryPanel.setLayout(inventoryPanelLayout);
        inventoryPanelLayout.setHorizontalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(inventoryPanelLayout.createSequentialGroup()
                        .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(inventoryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(supplyComboBox, 0, 345, Short.MAX_VALUE)
                            .addComponent(warehouseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        inventoryPanelLayout.setVerticalGroup(
            inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(warehouseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(supplyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(inventoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void warehouseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseComboBoxActionPerformed
        updateTable(warehouseComboBox.getSelectedIndex()-1, supplyComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_warehouseComboBoxActionPerformed

    private void supplyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplyComboBoxActionPerformed
        updateTable(warehouseComboBox.getSelectedIndex()-1, supplyComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_supplyComboBoxActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel inventoryPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> supplyComboBox;
    private javax.swing.JComboBox<String> warehouseComboBox;
    // End of variables declaration//GEN-END:variables
}
