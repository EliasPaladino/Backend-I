package com.dh.clase23.integrador.dao;

import com.dh.clase23.integrador.dominio.Odontologo;
import com.dh.clase23.integrador.dominio.Paciente;
import com.dh.clase23.integrador.dominio.Turno;
import com.dh.clase23.integrador.service.OdontologoService;
import com.dh.clase23.integrador.service.PacienteService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TurnoDAOH2 implements IDao<Turno> {
    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/integrador", "sa", "sa");
    }
    @Override
    public List<Turno> listarElementos() {
        Connection connection = null;
        List<Turno> listaTurnos = new ArrayList<>();
        Turno turno = null;
        Odontologo odontologo = null;
        Paciente paciente = null;

        try {
            connection = getConnection();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM turnos");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                odontologo = odontologoDAOH2.buscarPorId(rs.getInt(2));
                paciente = pacienteDAOH2.buscarPorId(rs.getInt(3));

                turno = new Turno(rs.getInt(1), odontologo, paciente, rs.getDate(4));
                listaTurnos.add(turno);
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

        return listaTurnos;
    }

    @Override
    public Turno buscarPorId(int id) {
        return null;
    }

    @Override
    public Turno buscarPorEmail(String email) {
        return null;
    }

    @Override
    public Turno guardar(Turno turno) {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }
}
