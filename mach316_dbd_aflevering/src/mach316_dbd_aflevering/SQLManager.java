/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    public String getAllProducts() throws SQLException {
        Statement statement = null;
        String query = "SELECT * FROM Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        String result = "";

        while (resultSet.next()) {
            String componentName = resultSet.getString("name");
            String kind = resultSet.getString("kind");
            int price = resultSet.getInt("price");

            result += componentName + " : " + kind + " :  " + price + "\n";

        }

        return result;

    }

    @Override
    public ArrayList<CPU> getCPUs() throws SQLException {

        ArrayList<CPU> cpuList = new ArrayList<CPU>();

        Statement statement = null;
        String query = "SELECT * FROM CPU NATURAL JOIN Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String CPUname = resultSet.getString("name");
            String CPUSocket = resultSet.getString("socket");
            double busSpeed = resultSet.getDouble("busspeed");
            int price = resultSet.getInt("price");

            CPU newCPU = new CPU(CPUname, CPUSocket, busSpeed, Kind.CPU, price);

            cpuList.add(newCPU);

        }

        return cpuList;

    }

    @Override
    public ArrayList<GPU> getGPUs() throws SQLException {

        ArrayList<GPU> gpuList = new ArrayList<GPU>();

        Statement statement = null;
        String query = "SELECT * FROM GPU NATURAL JOIN Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String GPUname = resultSet.getString("name");
            double speed = resultSet.getDouble("speed");
            int vram = resultSet.getInt("vram");
            int price = resultSet.getInt("price");

            GPU newGPU = new GPU(GPUname, speed, vram, Kind.GPU, price);

            gpuList.add(newGPU);

        }

        return gpuList;
    }

    @Override
    public ArrayList<RAM> getRAM() throws SQLException {
        ArrayList<RAM> ramList = new ArrayList<RAM>();

        Statement statement = null;
        String query = "SELECT * FROM RAM NATURAL JOIN Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String RAMname = resultSet.getString("name");
            String CPUSocket = resultSet.getString("CPUSocket");
            int speed = resultSet.getInt("speed");
            int size = resultSet.getInt("size");
            int price = resultSet.getInt("price");

            RAM newRAM = new RAM(RAMname, CPUSocket, speed, size, Kind.RAM, price);

            ramList.add(newRAM);

        }

        return ramList;
    }

    @Override
    public ArrayList<ComputerCase> getCases() throws SQLException {
        ArrayList<ComputerCase> ccList = new ArrayList<ComputerCase>();

        Statement statement = null;
        String query = "SELECT * FROM ComputerCase NATURAL JOIN Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String caseName = resultSet.getString("name");
            String formFactor = resultSet.getString("formFactor");
            int price = resultSet.getInt("price");

            ComputerCase newCase = new ComputerCase(caseName, formFactor, Kind.CASE, price);

            ccList.add(newCase);

        }

        return ccList;
    }

    @Override
    public ArrayList<MainBoard> getMainBoards() throws SQLException {
        ArrayList<MainBoard> mbList = new ArrayList<MainBoard>();

        Statement statement = null;
        String query = "SELECT * FROM MainBoard NATURAL JOIN Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {

            String boardName = resultSet.getString("name");
            boolean hasGraphics = resultSet.getBoolean("hasGraphics");
            String formFactor = resultSet.getString("formFactor");
            String ramType = resultSet.getString("RAMType");
            String cpuSocket = resultSet.getString("CPUSocket");
            int price = resultSet.getInt("price");

            MainBoard newMB = new MainBoard(boardName, formFactor, hasGraphics, ramType, cpuSocket, Kind.MAINBOARD, price);

            mbList.add(newMB);

        }

        return mbList;
    }

}
