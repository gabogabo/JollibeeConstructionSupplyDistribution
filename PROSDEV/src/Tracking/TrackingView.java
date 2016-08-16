/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracking;

import Database.DB;
import static Database.DB.con;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Kristian
 */
public class TrackingView extends javax.swing.JPanel {

    /**
     * Creates new form TrackingView
     */
  //  private JPanel trackPanel;
    public TrackingView() {
        initComponents();
        setSize(new Dimension(1100,700));
        trackTable.setSize(new Dimension(544,700));
        //trackPanel = new JPanel();
      //  trackPanel.setLocation(300, 400);
    }
    
    void updateTable(String status){
        JButton button = new JButton();
        DefaultTableModel model = new DefaultTableModel();
      
        model.addColumn("Request Number");
        model.addColumn("Date Filed");
        model.addColumn("Status");
        model.addColumn("Type");
        model.addColumn(" ");
        
       
        //model.addColumn(button);
        String where = "";
        String sql;
        boolean showSelect = false, isCompleted = false;
       
        /*
        switch (statusBox.getSelectedItem().toString()) {
            case "Pending":
                where = "WHERE d.status = ?";
                isPending = true;
                break;
            case "Completed":
                where = "WHERE d.status = ?";
                isCompleted = true;
                break;
        }*/
        if(!status.equals("Show All")){
            where = "WHERE d.status = \"" + statusBox.getSelectedItem().toString()+"\"";
           // prin
           // showSelect = true;
        }
        else{
            where = "";
        }
        
        sql = "SELECT d.dist_id, d.type, d.date_filed, d.status\n" + "FROM distributions d\n"+where;
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
//            ps.setString(1, statusBox.getSelectedItem().toString());

            ResultSet rs = ps.executeQuery();
        
            ArrayList row;
            while(rs.next()){
                row = new ArrayList();
                row.add(rs.getString("dist_id"));
                row.add(rs.getString("date_filed"));
                row.add(rs.getString("status"));
                row.add(rs.getString("type"));
           //     row.add(button);
                model.addRow(row.toArray());
            }
           
        }
        catch(SQLException sq){
             Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, sq);
        }
        
        
        trackTable.setModel(model);
        if(!statusBox.getSelectedItem().toString().equals("Completed"))
        {//set custom renderer to last column
        trackTable.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
        
        //set custom editor to last column
        trackTable.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor(new JTextField()));
       // JScrollPane pane = new JScrollPane(trackTable);
        //getContentPane().add(pane);
        }
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer{
    //cons
    public ButtonRenderer(){
        //button properties
        setOpaque(true);
        
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus, int row, int col) {
        //passed object as button text
            setText("Cancel"); 
            
        return this;
    }
}

    class ButtonEditor extends DefaultCellEditor{
    
    protected JButton btn = new JButton();
    private String label = "Cancel";
    private Boolean isClicked;
    
    
    public ButtonEditor(JTextField text) {
        super(text);
        btn.setText("Cancel");
        btn.setOpaque(true);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
           
        //buttonclicked
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                fireEditingStopped();
            }
        });
        /*
        btn.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                 setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });
         */   
    }
         //override methods
        @Override
        public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col){
        
            //set button text
           // label = "Cancel";
            //btn.setText(label);
            isClicked = true;
           
            return btn;
        }
        
        //cell value change when clicked
        @Override
        public Object getCellEditorValue(){
            int dlg = JOptionPane.YES_NO_OPTION;
            if(isClicked){
                System.out.println("Clicked");
                int dgRes = JOptionPane.showConfirmDialog(btn, "Would you like to cancel this transfer?", "Cancel Transfer", dlg);
                if(dgRes == JOptionPane.YES_OPTION){
                    System.out.println(trackTable.getColumnModel().getColumn(1).toString());
                    
                }
            }
            isClicked = false;
            
            return label;
        }
        
        @Override
        public boolean stopCellEditing(){
            isClicked = false;
            
            return super.stopCellEditing();
        }
    
        @Override
        protected void fireEditingStopped(){
            super.fireEditingStopped();
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        statusBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        trackTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setName("mainTrackPanel"); // NOI18N

        topPanel.setBackground(new java.awt.Color(255, 255, 255));

        statusBox.setFont(new java.awt.Font("Quicksand", 0, 24)); // NOI18N
        statusBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Show All", "Pending", "In Progress", "Completed" }));
        statusBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Quicksand", 1, 24)); // NOI18N
        jLabel1.setText("Select Status:");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        trackTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Request Number", "Date Received", "Status", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        trackTable.setRowHeight(25);
        jScrollPane1.setViewportView(trackTable);
        if (trackTable.getColumnModel().getColumnCount() > 0) {
            trackTable.getColumnModel().getColumn(0).setResizable(false);
            trackTable.getColumnModel().getColumn(1).setResizable(false);
            trackTable.getColumnModel().getColumn(2).setResizable(false);
            trackTable.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void statusBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusBoxActionPerformed
        updateTable(statusBox.getSelectedItem().toString());
    }//GEN-LAST:event_statusBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox statusBox;
    private javax.swing.JPanel topPanel;
    private javax.swing.JTable trackTable;
    // End of variables declaration//GEN-END:variables
}
