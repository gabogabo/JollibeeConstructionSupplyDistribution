/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Inventory.InventoryModule;
import LogIn.LogInView;

/**
 *
 * @author Hannah
 */
public class Main {
    
    public static void main(String args[]) {
        // MainView.frame.setVisible(true); 
        LogInView login = new LogInView();
        login.setVisible(true);
    }
    
}
