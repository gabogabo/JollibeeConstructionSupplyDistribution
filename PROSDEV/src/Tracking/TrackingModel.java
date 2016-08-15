/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracking;

import java.util.ArrayList;
/**
 *
 * @author Kristian
 */
public class TrackingModel {
    ArrayList<String> LocationList;
    
    void setLocationList(ArrayList<String> LocationList){
        this.LocationList = LocationList;
    }
    ArrayList<String> getLocationList(){
        return this.LocationList;
    }
    
}
