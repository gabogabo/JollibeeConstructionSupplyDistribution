/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

import java.util.ArrayList;

/**
 *
 * @author Hannah
 */
public class TransferFormModel {
    ArrayList<String> locationList;
    
    void setLocationList(ArrayList<String> locationList) {
        this.locationList = locationList;
    }
    ArrayList<String> getLocationList() {
        return locationList;
    }
}
