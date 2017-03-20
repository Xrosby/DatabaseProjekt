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
public class Component {

    private String name, kind;
    private int price, stock, minStock, prefStock, toBeOrdered;

    public Component(String name, String kind, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        this.name = name;
        this.kind = kind;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.prefStock = prefStock;
        this.toBeOrdered = toBeOrdered;

    }

    public int getToBeOrdered() {
        return toBeOrdered;
    }

    public int getStock() {
        return stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public int getPrefStock() {
        return prefStock;
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
