/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

/**
 *
 * @author MadsNorby
 */
public class MainBoard extends Product{ 
    
    private String formFactor;
    private boolean hasGraphics;
    private String RAMType;
    private String CPUSocket;
    
    public MainBoard(String name, String formFactor, boolean hasGraphics, String RAMType, String CPUSocket, Kind kind, int price) {
        super(name, kind, price);
        
        this.formFactor = formFactor;
        this.hasGraphics = hasGraphics;
        this.RAMType = RAMType;
        this.CPUSocket = CPUSocket;
        
    }

    public String getFormFactor() {
        return formFactor;
    }

    public boolean isHasGraphics() {
        return hasGraphics;
    }

    public String getRAMType() {
        return RAMType;
    }

    public String getCPUSocket() {
        return CPUSocket;
    }
    
    
}
