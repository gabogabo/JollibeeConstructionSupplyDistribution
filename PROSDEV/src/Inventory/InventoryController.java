/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Main.MainView;
import java.util.ArrayList;

/**
 *
 * @author Hannah
 */
public class InventoryController {
    private InventoryModel model;
    private InventoryView view;
    
    public InventoryController() {
        model = new InventoryModel();
        view = new InventoryView();
    }
    
    void updateModel(ArrayList<String> warehouseList, ArrayList<String> supplyList) {
        model.setWarehouseList(warehouseList);
        model.setSupplyList(supplyList);
    }
    
    void updateView() {
        view.updateComboBox(model.getWarehouseList(), model.getSupplyList());
        view.updateTable(-1, "Show All");
        MainView.frame.setMainPanel(view.inventoryPanel);
    }
}