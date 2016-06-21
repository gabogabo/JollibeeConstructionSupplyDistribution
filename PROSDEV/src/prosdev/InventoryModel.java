/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prosdev;

import java.util.ArrayList;

/**
 *
 * @author Hannah
 */
public class InventoryModel {
    private ArrayList<String> locationList;
    private ArrayList<String> supplyList;
    
    void setLocationList(ArrayList<String> locationList) {
        this.locationList = locationList;
    }
    void setSupplyList(ArrayList<String> supplyList) {
        this.supplyList = supplyList;
    }
    ArrayList<String> getLocationList() {
        return locationList;
    }
    ArrayList<String> getSupplyList() {
        return supplyList;
    }
    
}
