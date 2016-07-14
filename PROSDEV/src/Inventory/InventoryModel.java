/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import java.util.ArrayList;

/**
 *
 * @author Hannah
 */
public class InventoryModel {
    private ArrayList<String> warehouseList;
    private ArrayList<String> supplyList;
    
    void setWarehouseList(ArrayList<String> warehouseList) {
        this.warehouseList = warehouseList;
    }
    void setSupplyList(ArrayList<String> supplyList) {
        this.supplyList = supplyList;
    }
    ArrayList<String> getWarehouseList() {
        return warehouseList;
    }
    ArrayList<String> getSupplyList() {
        return supplyList;
    }
    
}
