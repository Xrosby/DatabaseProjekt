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
public abstract class Product {
    
    private int price;
    private String name;
    private Kind kind;
    
    public Product(String name, Kind kind, int price) {
        this.name = name;
        this.kind = kind;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Kind getKind() {
        return kind;
    }
    
    
}
