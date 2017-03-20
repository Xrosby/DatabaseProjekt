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
public class GPU extends Component {

    private double speed;
    private int vram;

    public GPU(String name, String kind, double speed, int vram, int price, int stock, int minStock, int prefStock, int toBeOrdered) {
        super(name, kind, price, stock, minStock, prefStock, toBeOrdered);

        this.speed = speed;
        this.vram = vram;
    }

    public double getSpeed() {
        return speed;
    }

    public int getVram() {
        return vram;
    }

}
