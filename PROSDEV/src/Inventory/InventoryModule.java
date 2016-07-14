/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Database.DB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import static Database.DB.con;
import Main.MainView;

/**
 *
 * @author Hannah
 */
public class InventoryModule {
    
    public void start() {
        InventoryController ctrl = new InventoryController();
        ctrl.updateModel(getWarehouseList(), getSupplyList());
        ctrl.updateView();
    }
    
    ArrayList<String> getWarehouseList() {
        ArrayList<String> locationList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT CONCAT(name, ', ', location) as 'warehouse' FROM warehouse ORDER BY whouse_id;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                locationList.add(rs.getString("warehouse"));
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
            String sql = ("SELECT DISTINCT name as 'supply' FROM supply ORDER BY supply_id;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                supplyList.add(rs.getString("supply"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return supplyList;
    }
    
    /* the code on 7/14/16
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
    */
    
}
