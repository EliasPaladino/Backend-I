package com.dh.clase22.entrenador.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DaoH2 implements IDao{
    private static final String CLASS = "org.h2.Driver";
    private static final String URL = "jdbc:h2:~/clase22";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    /*@Override
    public List listar() {
        Connection connection = null;

        try {
            connection = getConnection();



        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static Connection getConnection() throws Exception {
        Class.forName(CLASS).newInstance();
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
*/
}
