/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 *
 * @author Hannah
 */
public class User {
    public static User user = new User();
    private int type, location_id;
    
    public void setType(int type) {
        this.type = type;
    }
    
    public void setLocationId(int location_id) {
        this.location_id = location_id;
    }
    
    public int getType() {
        return type;
    }
    
    public int getLocationId() {
        return location_id;
    }
}
