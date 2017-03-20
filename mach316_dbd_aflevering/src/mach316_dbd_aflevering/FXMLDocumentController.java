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
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author MadsNorby
 */
public class FXMLDocumentController implements Initializable {

    SQLManager sqlManager;
    private ComputerStore cpStore;

    @FXML
    private TableColumn<Component, String> name;
    @FXML
    private TableColumn<Component, String> kind;
    @FXML
    private TableColumn<Component, Integer> price;

    private ObservableList<Component> masterData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Component, Integer> stock;
    @FXML
    private TableColumn<Component, Integer> toBeOrdered;
    @FXML
    private ListView<?> listviewComputerSystems;
    @FXML
    private ListView<?> listviewComponents;
    @FXML
    private Label lblPrice;
    @FXML
    private TableView<Component> tableViewComponents;
    @FXML
    private TableColumn<GPU, String> columnGPUname;
    @FXML
    private TableColumn<GPU, Double> columnGPUspeed;
    @FXML
    private TableColumn<GPU, Integer> columnGPUvram;
    @FXML
    private TableColumn<GPU, Integer> columnGPUprice;
    @FXML
    private TableView<GPU> tableViewGPUs;
    @FXML
    private TableColumn<CPU, String> columnCPUname;
    @FXML
    private TableColumn<CPU, Double> columnCPUspeed;
    @FXML
    private TableColumn<CPU, String> columnCPUsocket;
    @FXML
    private TableColumn<CPU, Integer> columnCPUprice;
    @FXML
    private TableColumn<Mainboard, String> columnMainboardname;
    @FXML
    private TableColumn<Mainboard, String> columnMainboardhasGraphics;
    @FXML
    private TableColumn<Mainboard, String> columnMainboardFormFactor;
    @FXML
    private TableColumn<Mainboard, String> columnMainboardRAMtype;
    @FXML
    private TableColumn<Mainboard, String> columnMainboardCPUSocket;
    @FXML
    private TableColumn<Mainboard, Integer> columnMainboardprice;
    @FXML
    private TableColumn<RAM, String> columnRAMname;
    @FXML
    private TableColumn<RAM, String> columnRAMtype;
    @FXML
    private TableColumn<RAM, Integer> columnRAMspeed;
    @FXML
    private TableColumn<RAM, Integer> columnRAMsize;
    @FXML
    private TableColumn<RAM, Integer> columnRAMprice;
    @FXML
    private TableColumn<Computercase, String> columnCaseName;
    @FXML
    private TableColumn<Computercase, String> columnCaseFormFactor;
    @FXML
    private TableColumn<Computercase, Integer> columnCasePrice;
    @FXML
    private TableView<CPU> tableViewCPUs;
    @FXML
    private TableView<Mainboard> tableViewMainboards;
    @FXML
    private TableView<Computercase> tableViewCases;
    @FXML
    private TableView<RAM> tableViewRAM;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initializeDatabaseManager();
            initializeComputerStore();
            initializeTableOverviews();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void initializeDatabaseManager() throws Exception {
        sqlManager = new SQLManager();
    }

    public void initializeComputerStore() throws Exception {
        cpStore = new ComputerStore();
    }

    public void initializeTableOverviews() throws SQLException {

        //Set values for the component table
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        kind.setCellValueFactory(new PropertyValueFactory<>("kind"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        toBeOrdered.setCellValueFactory(new PropertyValueFactory<>("toBeOrdered"));

        tableViewComponents.setItems(cpStore.getObservableComponentList());

        //Set values for the GPU table
        columnGPUname.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnGPUspeed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        columnGPUvram.setCellValueFactory(new PropertyValueFactory<>("vram"));
        columnGPUprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableViewGPUs.setItems(cpStore.getObservableGPUList());

        //Set values for CPU table
        columnCPUname.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnCPUspeed.setCellValueFactory(new PropertyValueFactory<>("busSpeed"));
        columnCPUsocket.setCellValueFactory(new PropertyValueFactory<>("socket"));
        columnCPUprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableViewCPUs.setItems(cpStore.getObservableCPUList());

        //Set values for Mainboard table
        columnMainboardname.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnMainboardhasGraphics.setCellValueFactory(new PropertyValueFactory<>("hasGraphics"));
        columnMainboardFormFactor.setCellValueFactory(new PropertyValueFactory<>("formFactor"));
        columnMainboardRAMtype.setCellValueFactory(new PropertyValueFactory<>("ramType"));
        columnMainboardCPUSocket.setCellValueFactory(new PropertyValueFactory<>("cpuSocket"));
        columnMainboardprice.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableViewMainboards.setItems(cpStore.getObservableMainboardList());

        //Set values for RAM table
        columnRAMname.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnRAMtype.setCellValueFactory(new PropertyValueFactory<>("type"));
        columnRAMspeed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        columnRAMsize.setCellValueFactory(new PropertyValueFactory<>("size"));
        columnRAMprice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tableViewRAM.setItems(cpStore.getObservableRAMList());
        
        //Set values for computer case table
        columnCaseName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnCaseFormFactor.setCellValueFactory(new PropertyValueFactory<>("formFactor"));
        columnCasePrice .setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tableViewCases.setItems(cpStore.getObservableComputercaseList());

    }

}
