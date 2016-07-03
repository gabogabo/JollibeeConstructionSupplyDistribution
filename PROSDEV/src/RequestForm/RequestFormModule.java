/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestForm;

import TransferForm.*;
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
public class RequestFormModule {
    
    public void start() {
        RequestFormController ctrl = new RequestFormController();
        ctrl.updateModel(getLocationList());
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
}
