/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import components.Component;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MadsNorby
 */
public interface DBManageable {
    
    
    public Connection getConnection() throws Exception;
    public void addProduct();
    public void deleteProduct(String product);
    public ArrayList<Component> getAllProducts() throws SQLException;
}
