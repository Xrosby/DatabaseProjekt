/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

/**
 *
 * @author MadsNorby
 */
public class RAM extends Component{
    
    private String type;
    private int speed, size;
    
    public RAM(String name, String kind, String type, int speed, int size, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        super(name, kind, price, stock, minStock, prefStock, toBeOrdered);
        
        this.type = type;
        this.speed = speed;
        this.size = size;
        
    }

    public String getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }
    
}
