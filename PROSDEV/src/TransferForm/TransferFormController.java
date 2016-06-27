/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Hannah
 */
public class TransferFormController {
    private TransferFormModel model;
    private TransferFormView view;
    
    public TransferFormController() {
        model = new TransferFormModel();
        
        JFrame f = new JFrame();
        f.setMinimumSize(new Dimension(1100, 700));
        view = new TransferFormView(f);
        view.setVisible(true);
        f.add(view);
        f.setVisible(true);
    }
    
    void updateModel(ArrayList<String> locationList) {
        model.setLocationList(locationList);
    }
    
    void updateView() {
        view.updateComboBox(model.getLocationList());
        view.addMore();
    }
    
}
