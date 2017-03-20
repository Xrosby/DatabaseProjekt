/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import components.CPU;
import components.Component;
import components.Computercase;
import components.GPU;
import components.Mainboard;
import components.RAM;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MadsNorby
 */
public class ComputerStore {

    private SQLManager sqlManager;
    private ObservableList<Component> componentsObservable;
    private ObservableList<GPU> gpusObservable;
    private ObservableList<CPU> cpusObservable;
    private ObservableList<Mainboard> mainboardsObservable;
    private ObservableList<RAM> ramsObservable;
    private ObservableList<Computercase> casesObservable;

    public ComputerStore() throws Exception {
        sqlManager = new SQLManager();

    }

    public ObservableList<Component> getObservableComponentList() throws SQLException {

        ArrayList<Component> components = sqlManager.getAllProducts();

        this.componentsObservable = FXCollections.observableArrayList();

        for (Component component : components) {

            componentsObservable.add(component);

        }
        return componentsObservable;

    }

    public ObservableList<GPU> getObservableGPUList() throws SQLException {

        ArrayList<GPU> gpus = sqlManager.getAllGPUs();

        this.gpusObservable = FXCollections.observableArrayList();

        for (GPU gpu : gpus) {
            gpusObservable.add(gpu);
        }

        return gpusObservable;

    }

    public ObservableList<CPU> getObservableCPUList() throws SQLException {

        ArrayList<CPU> cpus = sqlManager.getAllCPUs();

        this.cpusObservable = FXCollections.observableArrayList();

        for (CPU cpu : cpus) {
            cpusObservable.add(cpu);
        }

        return cpusObservable;

    }

    public ObservableList<Mainboard> getObservableMainboardList() throws SQLException {

        ArrayList<Mainboard> mainboards = sqlManager.getAllMainboards();

        this.mainboardsObservable = FXCollections.observableArrayList();

        for (Mainboard mb : mainboards) {
            mainboardsObservable.add(mb);
        }

        return mainboardsObservable;

    }

    public ObservableList<RAM> getObservableRAMList() throws SQLException {

        ArrayList<RAM> rams = sqlManager.getAllRAMs();

        this.ramsObservable = FXCollections.observableArrayList();

        for (RAM ram : rams) {
            ramsObservable.add(ram);
        }

        return ramsObservable;

    }

    public ObservableList<Computercase> getObservableComputercaseList() throws SQLException {

        ArrayList<Computercase> cases = sqlManager.getAllCases();

        this.casesObservable = FXCollections.observableArrayList();

        for (Computercase cCase : cases) {
            casesObservable.add(cCase);
        }

        return casesObservable;

    }

}
