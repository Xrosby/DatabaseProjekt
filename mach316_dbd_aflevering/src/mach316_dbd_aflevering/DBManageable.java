/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MadsNorby
 */
public interface DBManageable {
    
    
    public Connection getConnection() throws Exception;
    public void addProduct();
    public void deleteProduct(String product);
    public String getAllProducts() throws SQLException;
}
