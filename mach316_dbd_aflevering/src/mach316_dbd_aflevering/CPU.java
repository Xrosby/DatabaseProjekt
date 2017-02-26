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
public class CPU extends Product {

    String socket;
    double busSpeed;

    public CPU(String name, String socket, double busSpeed, Kind kind, int price) {
        super(name, kind, price);

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
