/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tracking;

import Tracking.*;
import Main.MainView;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Kristian
 */
public class TrackingController {
    private TrackingView view;
    private TrackingModel model;
    
    public TrackingController(){
        view = new TrackingView();
        model = new TrackingModel();
    }
     void updateView() {
       // view.updateChooseSuplies();
        view.updateTable("Show All");
        MainView.frame.setMainPanel(view);
    }
}
