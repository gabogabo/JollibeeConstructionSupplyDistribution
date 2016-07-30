/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

import Main.MainView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Hannah
 */
public class TransferFormController {
    private TransferFormModel model;
    private TransferFormView view;
    
    public TransferFormController() {
        model = new TransferFormModel();
        view = new TransferFormView();
    }
    
    void updateModel(ArrayList<Location> warehouseList) {
        model.setWarehouseList(warehouseList);
    }
    
    void updateView() {
        view.updateComboBox(model.getWarehouseList());
        view.updateChooseSuplies();
        MainView.frame.setMainPanel(view);
    }
    
}
