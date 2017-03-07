/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author MadsNorby
 */
public class FXMLDocumentController implements Initializable {

    SQLManager sqlManager;

    private ObservableList<Component> components;
    @FXML
    private Label label;
    @FXML
    private ListView<Component> listView;
    @FXML
    private TableView<Component> tableView;
    @FXML
    private TableColumn<Component, String> name;
    @FXML
    private TableColumn<Component, String> kind;
    @FXML
    private TableColumn<Component, Integer> price;

    private ObservableList<Component> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initializeDatabaseManager();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listOfComponents();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            initializeTableOverview();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initializeDatabaseManager() throws Exception {
        sqlManager = new SQLManager();
    }

    public ObservableList<Component> observableComponentList() throws SQLException {

        ArrayList<Component> componentMap = sqlManager.getAllProducts();

        this.components = FXCollections.observableArrayList();

        for (Component component : componentMap) {

            components.add(component);

        }
        return components;

    }

    public void listOfComponents() throws SQLException {
        listView.itemsProperty().set(observableComponentList());
        listView.setCellFactory(param -> new ListCell<Component>() {
            @Override
            protected void updateItem(Component component, boolean empty) {
                super.updateItem(component, empty);

                if (empty || component.getName() == null || component.getName() == null) {
                    setText(null);
                } else {
                    setText(component.getName());
                }
            }

        });

    }

    public void initializeTableOverview() throws SQLException {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        kind.setCellValueFactory(new PropertyValueFactory<>("kind"));
        price.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView.setItems(masterData);

        for (Component component : sqlManager.getAllProducts()) {
            masterData.add(new Component(component.getName(), component.getKind(), component.getPrice()));
        }

    }
}
