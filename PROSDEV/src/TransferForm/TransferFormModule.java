/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

import Database.DB;
import static Database.DB.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hannah
 */
public class TransferFormModule {
    
    public void start() {
        TransferFormController ctrl = new TransferFormController();
        ctrl.updateModel(getWarehouseList());
        ctrl.updateView();
    }
    
    ArrayList<Location> getWarehouseList() {
        ArrayList<Location> locationList = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            String sql = ("SELECT name, location_id as 'id' FROM location WHERE type = 'warehouse' ORDER BY location_id;");
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()) {
                locationList.add(new Location(rs.getString("name"), rs.getInt("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locationList;
    }
    
    /* the code on 7/16/16
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
    }*/
}
