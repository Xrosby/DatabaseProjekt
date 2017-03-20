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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLManager implements DBManageable {

    private Connection con;

    public SQLManager() throws Exception {
        con = getConnection();
    }

    @Override
    public Connection getConnection() throws Exception {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String pass = "1234";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, username, pass);
        if (conn != null) {
            System.out.println("Connected");
            return conn;
        }

        return null;
    }

    @Override
    public void addProduct() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteProduct(String product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Component> getAllProducts() throws SQLException {

        ArrayList<Component> components = new ArrayList<>();

        Statement statement = null;
        String query = "SELECT ( \n"
                + "CASE WHEN currentstock < minimumstock\n"
                + "THEN preferedstock - currentstock\n"
                + "ELSE 0\n"
                + "END) AS toBeOrdered, * \n"
                + "FROM Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String componentName = resultSet.getString("name");
            String kind = resultSet.getString("kind");
            int price = resultSet.getInt("price");
            int stock = resultSet.getInt("currentStock");
            int minStock = resultSet.getInt("minimumStock");
            int prefStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");

            Component component = new Component(componentName, kind, price, stock, minStock, prefStock, toBeOrdered);
            components.add(component);

        }

        return components;

    }

    public ArrayList<GPU> getAllGPUs() throws SQLException {

        ArrayList<GPU> gpus = new ArrayList<>();

        Statement statement = null;

        String query = naturalJoinWithComponent("GPU");

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            double speed = resultSet.getDouble("speed");
            int vram = resultSet.getInt("vram");
            int price = resultSet.getInt("price");
            String kind = resultSet.getString("kind");
            int currentStock = resultSet.getInt("currentStock");
            int minimumStock = resultSet.getInt("minimumStock");
            int preferedStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");

            GPU newGPU = new GPU(name, kind, speed, vram, price, currentStock, minimumStock, preferedStock, toBeOrdered);
            gpus.add(newGPU);
        }

        return gpus;
    }

    public ArrayList<CPU> getAllCPUs() throws SQLException {

        ArrayList<CPU> cpus = new ArrayList<>();

        Statement statement = null;

        String query = naturalJoinWithComponent("CPU");

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            String kind = resultSet.getString(("kind"));
            String socket = resultSet.getString("socket");
            double busSpeed = resultSet.getDouble("busSpeed");
            int price = resultSet.getInt("price");
            int currentStock = resultSet.getInt("currentStock");
            int minimumStock = resultSet.getInt("minimumStock");
            int preferedStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");

            CPU newCPU = new CPU(name, kind, socket, busSpeed, price, currentStock, minimumStock, preferedStock, toBeOrdered);
            cpus.add(newCPU);

        }

        return cpus;
    }

    public ArrayList<Mainboard> getAllMainboards() throws SQLException {

        ArrayList<Mainboard> mainboards = new ArrayList<>();

        Statement statement = null;

        String query = naturalJoinWithComponent("Mainboard");

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            boolean hasGraphics = resultSet.getBoolean("hasGraphics");
            String formFactor = resultSet.getString("formFactor");
            String ramType = resultSet.getString("ramType");
            String cpuSocket = resultSet.getString("cpuSocket");
            int price = resultSet.getInt("price");
            String kind = resultSet.getString("kind");
            int currentStock = resultSet.getInt("currentStock");
            int minimumStock = resultSet.getInt("minimumStock");
            int preferedStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");

            Mainboard newMB = new Mainboard(name, kind, hasGraphics, formFactor, ramType, cpuSocket, price, currentStock, minimumStock, preferedStock, toBeOrdered);
            mainboards.add(newMB);
        }

        return mainboards;
    }

    public ArrayList<RAM> getAllRAMs() throws SQLException {
        ArrayList<RAM> rams = new ArrayList<>();

        Statement statement = null;

        String query = naturalJoinWithComponent("RAM");

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            String type = resultSet.getString("type");
            int speed = resultSet.getInt("speed");
            int size = resultSet.getInt("size");
            int price = resultSet.getInt("price");
            String kind = resultSet.getString("kind");
            int currentStock = resultSet.getInt("currentStock");
            int minimumStock = resultSet.getInt("minimumStock");
            int preferedStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");
            
            RAM newRAM = new RAM(name, kind, type, speed, size, price, currentStock, minimumStock, preferedStock, toBeOrdered);
            rams.add(newRAM);
        }

        return rams;
    }

    public ArrayList<Computercase> getAllCases() throws SQLException {

        ArrayList<Computercase> computercases = new ArrayList<>();

        Statement statement = null;

        String query = naturalJoinWithComponent("Computercase");

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String name = resultSet.getString("name");
            String formFactor = resultSet.getString("formFactor");
            int price = resultSet.getInt("price");
            String kind = resultSet.getString("kind");
            int currentStock = resultSet.getInt("currentStock");
            int minimumStock = resultSet.getInt("minimumStock");
            int preferedStock = resultSet.getInt("preferedStock");
            int toBeOrdered = resultSet.getInt("toBeOrdered");
            
            Computercase newCC = new Computercase(name, kind, formFactor, price, currentStock, minimumStock, preferedStock, toBeOrdered);
            computercases.add(newCC);
        }

        return computercases;
    }

    public String naturalJoinWithComponent(String component) {

        return "SELECT ( \n"
                + "   CASE WHEN currentstock < minimumstock\n"
                + "   THEN preferedstock - currentstock\n"
                + "   ELSE 0\n"
                + "   END) AS toBeOrdered, *\n"
                + "   FROM Component NATURAL JOIN " + component + ";";
    }
}
