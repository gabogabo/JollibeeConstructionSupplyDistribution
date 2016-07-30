/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferForm;

/**
 *
 * @author Hannah
 */
public class Location {
    public String name;
    private Integer id;
    
    public Location(String name, Integer id) {
        this.name = name;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public Integer getID() {
        return id;
    }
    
    @Override
    public String toString(){
        return name;
    }
}
