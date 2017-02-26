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
public class ComputerCase extends Product {

    private String formFactor;

    public ComputerCase(String name, String formFactor, Kind kind, int price) {
        super(name, kind, price);

        this.formFactor = formFactor;
    }

    public String getFormFactor() {
        return formFactor;
    }

}
