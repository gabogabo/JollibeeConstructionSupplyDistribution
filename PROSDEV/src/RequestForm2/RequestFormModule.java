/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestForm2;

/**
 *
 * @author Hannah
 */
public class RequestFormModule {
    
    public void start() {
        RequestFormController ctrl = new RequestFormController();
        ctrl.updateView();
    }
    
}
