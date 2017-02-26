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
public class GPU extends Product {

    private double speed;
    private int vram;

    public GPU(String name, double speed, int vram, Kind kind, int price) {
        super(name, kind, price);

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
