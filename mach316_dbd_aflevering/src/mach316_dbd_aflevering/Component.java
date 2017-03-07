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
public class Component {
    
    private String name;
    private String kind;
    private int price;
    
    
    public Component(String name, String kind, int price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public int getPrice() {
        return price;
    }
}
