package presencial.dao;

import presencial.modelo.Domicilio;

import java.sql.*;

public class DomicilioDAOH2 implements IDao<Domicilio>{
    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection=null;
        try{
            connection=getConnection();

            PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO domicilios (calle, numero, localidad, provincia) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2,domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.executeUpdate();
            ResultSet clavesGeneradas=preparedStatement.getGeneratedKeys();
            while (clavesGeneradas.next()){
                domicilio.setId(clavesGeneradas.getInt(1));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio buscar(int id) {
        Connection connection=null;
        Domicilio domicilio=null;
        try{
            //conectamos a base
            connection=getConnection();
            //preparar la consulta
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM domicilios WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                //utilizar la información que buscamos
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return domicilio;

    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase15","sa","sa");
    }
}
