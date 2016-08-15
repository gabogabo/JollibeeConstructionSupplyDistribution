/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracking;

import Tracking.*;
import Database.DB;
import static Database.DB.con;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Kristian
 */
public class TrackingModule {
    
    public void start(){
        TrackingController ctrl = new TrackingController();
        ctrl.updateView();
    }
}
