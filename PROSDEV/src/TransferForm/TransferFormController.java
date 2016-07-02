/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

import java.awt.Dimension;
import java.awt.Toolkit;
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
        f.setMinimumSize(getDimension());
        f.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        view = new TransferFormView(f);
        view.setVisible(true);
        f.add(view);
        f.setVisible(true);
    }
    
    Dimension getDimension() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return screenSize;
    }
    
    void updateModel(ArrayList<String> locationList) {
        model.setLocationList(locationList);
    }
    
    void updateView() {
        view.updateComboBox(model.getLocationList());
        view.updateChooseSuplies();
    }
    
}
