package dao;

import model.Domicilio;
import model.Paciente;

import java.sql.*;

public class PacienteDAOH2 implements IDao<Paciente> {
    @Override
    public void agregar(Paciente paciente) {

        Connection connection = null;

        try {

            DomicilioDAOH2 domicilio = new DomicilioDAOH2();
            domicilio.agregar(paciente.getDomicilio());

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("INSERT INTO PACIENTE(ID, APELLIDO, NOMBRE, DNI, DOMICILIO) VALUES(?, ?, ?, ?, ?)");

            pStmt.setLong(1, paciente.getId());
            pStmt.setString(2, paciente.getApellido());
            pStmt.setString(3, paciente.getNombre());
            pStmt.setString(4, paciente.getDni());
            pStmt.setLong(5, paciente.getDomicilio().getId());

            pStmt.executeUpdate();

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
    }

    @Override
    public Paciente buscar(Long id) {

        Paciente paciente = null;
        Connection connection = null;
        Domicilio domicilio = null;

        try {

            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM PACIENTE WHERE ID = ?");
            pStmt.setLong(1, id);

            ResultSet rs = pStmt.executeQuery();

            while (rs.next()) {

                Long id_domicilio = rs.getLong(5);
                domicilio = domicilioDAOH2.buscar(id_domicilio);

                paciente = new Paciente(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), domicilio);

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

    @Override
    public void eliminar(Long id) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("DELETE * FROM PACIENTE WHERE ID = ?");
            pStmt.setLong(1, id);
            pStmt.executeUpdate();

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
    }

    @Override
    public void modificar(Paciente paciente) {

        Domicilio domicilio = null;
        Connection connection = null;

        try {

            DomicilioDAOH2 domicilioDAOH2 = new DomicilioDAOH2();
            domicilio = domicilioDAOH2.buscar(paciente.getDomicilio().getId());

            PreparedStatement pStmt = connection.prepareStatement("UPDATE PACIENTE SET apellido = ?, nombre = ?, dni = ?, domicilio = ? WHERE id = ?");
            pStmt.setString(1, paciente.getApellido());
            pStmt.setString(2, paciente.getNombre());
            pStmt.setString(3, paciente.getDni());
            pStmt.setObject(4, domicilio);

            pStmt.executeUpdate();

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
    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase15s", "sa", "");
    }
}
