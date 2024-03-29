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
        Connection connection = null;
        Turno turno = null;

        try {
            connection = getConnection();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM turnos WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                turno = new Turno(rs.getInt(1), odontologoDAOH2.buscarPorId(rs.getInt(2)), pacienteDAOH2.buscarPorId(rs.getInt(3)), rs.getDate(4));
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
        return turno;
    }

    @Override
    public Turno buscarPorEmail(String email) {
        return null;
    }

    @Override
    public Turno guardar(Turno turno) {
        Connection connection = null;

        try {
            connection = getConnection();

            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();

            pacienteDAOH2.guardar(turno.getPaciente());
            odontologoDAOH2.guardar(turno.getOdontologo());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO turnos (odontologo_id, paciente_id, fecha) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, turno.getOdontologo().getId());
            preparedStatement.setInt(2, turno.getPaciente().getId());
            preparedStatement.setDate(3, turno.getFecha());
            preparedStatement.executeUpdate();

            ResultSet claves = preparedStatement.getGeneratedKeys();
            while ( claves.next() ) {
                turno.setId(claves.getInt(1));
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

        return turno;
    }

    @Override
    public Turno actualizar(Turno turno) {
        Connection connection = null;
        Odontologo odontologo = null;
        Paciente paciente = null;

        try {
            connection = getConnection();
            OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
            PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();

            odontologo = odontologoDAOH2.buscarPorId(turno.getOdontologo().getId());
            if(odontologo == null) {
                odontologo = odontologoDAOH2.guardar(turno.getOdontologo());
            }

            paciente = pacienteDAOH2.buscarPorId(turno.getPaciente().getId());
            if(paciente == null){
                paciente = pacienteDAOH2.guardar(turno.getPaciente());
            }

            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE turnos SET ODONTOLOGO_ID = ?, PACIENTE_ID = ?, FECHA = ? WHERE id = ?");
            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, paciente.getId());
            preparedStatement.setDate(3, turno.getFecha());
            preparedStatement.setInt(4, turno.getId());
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

        return turno;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;

        try {
            connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM turnos WHERE id = ?");
            preparedStatement.setInt(1, id);
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
    }
}
