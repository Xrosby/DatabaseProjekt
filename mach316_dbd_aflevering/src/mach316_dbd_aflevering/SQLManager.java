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
        Statement statement = null;
        String query = "SELECT * FROM Component;";

        statement = con.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<Component> components = new ArrayList<>();

        while (resultSet.next()) {
            String componentName = resultSet.getString("name");
            String kind = resultSet.getString("kind");
            int price = resultSet.getInt("price");
            
            Component component = new Component(componentName, kind, price);
            components.add(component);

            
        }

        return components;

    }
}