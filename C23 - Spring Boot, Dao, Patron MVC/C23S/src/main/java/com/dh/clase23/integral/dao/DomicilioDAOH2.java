package com.dh.clase23.integral.dao;

import com.dh.clase23.integral.dominio.Domicilio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio>{

    @Override
    public void guardar(Domicilio domicilio) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement insertSql = connection.prepareStatement("INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES( ?, ?, ?, ?);");

            insertSql.setString(1, domicilio.getCalle());
            insertSql.setString(2, domicilio.getNumero());
            insertSql.setString(3, domicilio.getLocalidad());
            insertSql.setString(4, domicilio.getProvincia());

            insertSql.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public Domicilio buscar(Long id) {

        Domicilio domicilio = null;
        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM domicilios WHERE ID = ?");
            pStmt.setLong(1, id);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {
                domicilio = new Domicilio(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return domicilio;

    }

    @Override
    public List<Domicilio> listarElementos() {

        List<Domicilio> domicilios = new ArrayList<>();
        Connection connection = null;

        try {

            connection = getConnection();

            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM domicilios";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {

                domicilios.add(new Domicilio(rs.getLong("id"), rs.getString("calle"), rs.getString("numero"), rs.getString("localidad"), rs.getNString("provincia")));

            }

        } catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch ( SQLException ex ) {
                ex.printStackTrace();
            }
        }

        return domicilios;

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase23", "sa", "");
    }
}
