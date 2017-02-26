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
public class RAM extends Product {

    private String CPUSocket;
    private int size;
    private int speed;

    public RAM(String name, String CPUSocket, int size, int speed, Kind kind, int price) {
        super(name, kind, price);

        this.CPUSocket = CPUSocket;
        this.size = size;
        this.speed = speed;

    }

    public String getCPUSocket() {
        return CPUSocket;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

}
