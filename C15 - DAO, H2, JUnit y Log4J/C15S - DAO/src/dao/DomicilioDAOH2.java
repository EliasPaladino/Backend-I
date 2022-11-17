package dao;

import model.Domicilio;

import java.sql.*;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    @Override
    public void agregar(Domicilio domicilio) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement insertSql = connection.prepareStatement("INSERT INTO DOMICILIO( CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES( ?, ?, ?, ?);");

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

            PreparedStatement pStmt = connection.prepareStatement("SELECT * FROM DOMICILIO WHERE ID = ?");
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
    public void eliminar(Long id) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("DELETE * FROM DOMICILIO WHERE ID = ?");
            pStmt.setLong(1, id);

            pStmt.executeQuery();

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
    public void modificar(Domicilio domicilio) {

        Connection connection = null;

        try {

            connection = getConnection();

            PreparedStatement pStmt = connection.prepareStatement("UPDATE domicilio SET calle = ?, numero = ?, localidad = ?, provincia = ? WHERE id = ?");
            pStmt.setString(1, domicilio.getCalle());
            pStmt.setString(2, domicilio.getNumero());
            pStmt.setString(3, domicilio.getLocalidad());
            pStmt.setString(4, domicilio.getProvincia());
            pStmt.setLong(5, domicilio.getId());

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
