package com.dh.clase23.integrador.dao;

import com.dh.clase23.integrador.dominio.Domicilio;
import com.dh.clase23.integrador.dominio.Odontologo;
import com.dh.clase23.integrador.dominio.Paciente;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDAOH2 implements IDao<Paciente> {
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/integrador", "sa", "sa");
    }

    @Override
    public List<Paciente> listarElementos() {
        Connection connection = null;
        List<Paciente> listaPacientes = new ArrayList<>();
        Paciente paciente = null;
        Domicilio domicilio = null;
        Odontologo odontologo = null;

        try {
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id_dom = rs.getInt(7);
                domicilio = domicilioDAOH2.buscarPorId(id_dom);

                int id_odontologo = rs.getInt(8);
                odontologo = odontologoDAOH2.buscarPorId(id_odontologo);

                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3),
                                        rs.getString(4), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilio, odontologo);
                listaPacientes.add(paciente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return listaPacientes;
    }

    @Override
    public Paciente buscarPorId(int id) {
        return null;
    }

    @Override
    public Paciente buscarPorEmail(String email) {
        Connection connection = null;
        Paciente paciente = null;
        Domicilio domicilio = null;
        Odontologo odontologo = null;

        try {
            connection = getConnection();
            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pacientes WHERE email = ?");
            preparedStatement.setString(1, email);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id_dom = rs.getInt(7);
                domicilio = domicilioDAOH2.buscarPorId(id_dom);

                int id_odontologo = rs.getInt(8);
                odontologo = odontologoDAOH2.buscarPorId(id_odontologo);

                paciente = new Paciente(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getDate(6).toLocalDate(), domicilio, odontologo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return paciente;
    }
}
