/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Main.MainView;
import java.util.ArrayList;
import javax.swing.JFrame;

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
    
    void updateModel(ArrayList<String> locationList, ArrayList<String> supplyList) {
        model.setLocationList(locationList);
        model.setSupplyList(supplyList);
    }
    
    void updateView() {
        view.updateComboBox(model.getLocationList(), model.getSupplyList());
        view.updateTable("Show All", "Show All");
        MainView.frame.setMainPanel(view.inventoryPanel);
    }
}