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
    
    void updateModel(ArrayList<String> locationList) {
        model.setLocationList(locationList);
    }
    
    void updateView() {
        view.updateComboBox(model.getLocationList());
        view.updateChooseSuplies();
        MainView.frame.setMainPanel(view);
        
//        JFrame f = new JFrame();
//        f.add(view);
//        f.setVisible(true);
//        System.out.println(MainView.frame.mainPanel);
    }
    
}
