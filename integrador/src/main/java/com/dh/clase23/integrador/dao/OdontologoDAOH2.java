package com.dh.clase23.integrador.dao;

import com.dh.clase23.integrador.dominio.Odontologo;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoDAOH2 implements IDao<Odontologo> {
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/integrador", "sa", "sa");
    }

    @Override
    public List<Odontologo> listarElementos() {
        Connection connection = null;
        Odontologo odontologo = null;
        List<Odontologo> listaOdontologos = new ArrayList<>();

        try {

            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4));
                listaOdontologos.add(odontologo);
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch ( SQLException ex ) {
                ex.printStackTrace();
            }
        }

        return listaOdontologos;
    }

    @Override
    public Odontologo buscarPorId(int id) {
        Connection connection = null;
        Odontologo odontologo = null;

        try {

            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM odontologos WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getNString(4));
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch ( SQLException ex ) {
                ex.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public Odontologo buscarPorEmail(String email) {
        return null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO odontologos (apellido, nombre, matricula) VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();

            ResultSet claves = preparedStatement.getGeneratedKeys();
            while (claves.next()) {
                odontologo.setId(claves.getInt(1));
            }

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch ( SQLException ex ) {
                ex.printStackTrace();
            }
        }

        return odontologo;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE odontologos SET apellido = ?, nombre = ?, matricula = ? WHERE id = ?;");
            preparedStatement.setString(1, odontologo.getApellido());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getMatricula());
            preparedStatement.setInt(4, odontologo.getId());

            preparedStatement.executeUpdate();

        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch ( SQLException ex ) {
                ex.printStackTrace();
            }
        }

        return odontologo;
    }
}
