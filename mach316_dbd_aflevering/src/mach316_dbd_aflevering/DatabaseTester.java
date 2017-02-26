/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import java.util.ArrayList;

/**
 *
 * @author MadsNorby
 */
public class DatabaseTester {

    public static void main(String[] args) throws Exception {

        ComputerStore cpStore = new ComputerStore();

        ArrayList<GPU> gpus = cpStore.getGPUS();
        ArrayList<CPU> cpus = cpStore.getCPUS();
        ArrayList<MainBoard> mbs = cpStore.getMainBoards();
        ArrayList<RAM> rams = cpStore.getRAMs();
        ArrayList<ComputerCase> cases = cpStore.getCases();

        for (CPU cpu : cpus) {
            System.out.println(cpu.getName() + "\n");
        }

        for (GPU gpu : gpus) {
            System.out.println(gpu.getName() + "\n");
        }

        for (ComputerCase computerCase : cases) {
            System.out.println(computerCase.getName() + "\n");
        }
        for (RAM ram : rams) {
            System.out.println(ram.getName() + "\n");
        }
        for (MainBoard mb : mbs) {
            System.out.println(mb.getName() + "\n");
        }

    }

}
