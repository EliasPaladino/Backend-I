package com.dh.clase23.integral.dao;

import com.dh.clase23.integral.dominio.Paciente;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {


    @Override
    public void guardar( Paciente paciente ) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO PACIENTE(nombre, apellido, email, dni, fecha_ingreso) VALUES(?, ?, ?, ?, ?)");
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getDni());
            ps.setDate(5, Date.valueOf(paciente.getFechaIngreso()));

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
    }

    @Override
    public Paciente buscar(Long id) {
        return null;
    }

    @Override
    public List<Paciente> listarElementos() {
        return null;
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase23","sa","");
    }
}
