/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author Hannah
 */
public class User {
    public static User user = new User();
    private String address;
    private int location_id;
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setLocationId(int location_id) {
        this.location_id = location_id;
    }
    
    public int getLocationId() {
        return location_id;
    }
}
