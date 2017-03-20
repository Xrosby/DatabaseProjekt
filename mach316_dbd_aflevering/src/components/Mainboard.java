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
public class Mainboard extends Component{
    
    private boolean hasGraphics;
    private String formFactor, ramType, cpuSocket;
    
    
    
    
    public Mainboard(String name, String kind, boolean hasGraphics, String formFactor, String ramType, String cpuSocket, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        super(name, kind, price, stock, minStock, prefStock, toBeOrdered);
        
        this.hasGraphics = hasGraphics;
        this.formFactor = formFactor;
        this.ramType = ramType;
        this.cpuSocket = cpuSocket;
        
    }

    public boolean isHasGraphics() {
        return hasGraphics;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public String getRamType() {
        return ramType;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }
    
}
