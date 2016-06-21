/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosdev;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static prosdev.DB.con;

/**
 *
 * @author Hannah
 */
public class InventoryModule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InventoryModule m = new InventoryModule();
        InventoryController ctrl = new InventoryController();
        ctrl.updateModel(m.getLocationList(), m.getSupplyList());
        ctrl.updateView();
    }
    
    ArrayList<String> getLocationList() {
        ArrayList<String> locationList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT distinct location FROM inventory;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                locationList.add(rs.getString("location"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList;
    }
    
    ArrayList<String> getSupplyList() {
        ArrayList<String> supplyList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT distinct supply FROM inventory;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                supplyList.add(rs.getString("supply"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplyList;
    }
    
}
