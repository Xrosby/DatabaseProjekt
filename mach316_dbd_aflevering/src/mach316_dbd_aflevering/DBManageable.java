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
    public ArrayList<CPU> getCPUs() throws SQLException;
    public ArrayList<GPU> getGPUs() throws SQLException;
    public ArrayList<RAM> getRAM() throws SQLException;
    public ArrayList<ComputerCase> getCases() throws SQLException;
    public ArrayList<MainBoard> getMainBoards() throws SQLException;
    
}
