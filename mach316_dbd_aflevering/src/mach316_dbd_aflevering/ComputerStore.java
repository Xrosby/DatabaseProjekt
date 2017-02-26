/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach316_dbd_aflevering;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MadsNorby
 */
public class ComputerStore {

    SQLManager sqlManager;

    public ComputerStore() throws Exception {
        sqlManager = new SQLManager();
    }

    public ArrayList<CPU> getCPUS() throws SQLException {
        return sqlManager.getCPUs();
    }

    public ArrayList<GPU> getGPUS() throws SQLException {
        return sqlManager.getGPUs();
    }

    public ArrayList<MainBoard> getMainBoards() throws SQLException {
        return sqlManager.getMainBoards();
    }

    public ArrayList<RAM> getRAMs() throws SQLException {
        return sqlManager.getRAM();
    }

    public ArrayList<ComputerCase> getCases() throws SQLException {
        return sqlManager.getCases();
    }

}
