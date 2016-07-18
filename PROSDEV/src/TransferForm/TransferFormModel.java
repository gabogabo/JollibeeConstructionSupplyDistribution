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
    ArrayList<String> warehouseList;
    
    void setWarehouseList(ArrayList<String> warehouseList) {
        this.warehouseList = warehouseList;
    }
    ArrayList<String> getWarehouseList() {
        return warehouseList;
    }
}
