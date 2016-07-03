/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestForm;

import TransferForm.*;
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
public class RequestFormController {
    private RequestFormModel model;
    private RequestFormView view;
    
    public RequestFormController() {
        model = new RequestFormModel();
        view = new RequestFormView();
    }
    
    void updateModel(ArrayList<String> locationList) {
        model.setLocationList(locationList);
    }
    
    void updateView() {
        view.updateChooseSuplies();
        MainView.frame.setMainPanel(view);
    }
    
}
