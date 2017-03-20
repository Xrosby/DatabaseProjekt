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
public class CPU extends Component {
    
    private String socket;
    private double busSpeed;
    
    public CPU(String name, String kind, String socket, double busSpeed, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        super(name, kind, price, stock, minStock, prefStock, toBeOrdered);
        
        this.socket = socket;
        this.busSpeed = busSpeed;
        
    }

    public String getSocket() {
        return socket;
    }

    public double getBusSpeed() {
        return busSpeed;
    }
    
}
