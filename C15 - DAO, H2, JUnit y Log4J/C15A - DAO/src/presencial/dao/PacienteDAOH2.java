package presencial.dao;

import presencial.modelo.Domicilio;
import presencial.modelo.Paciente;

import java.sql.*;

public class PacienteDAOH2 implements IDao<Paciente>{
    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection=null;
        try{
            //arreglar tema domicilio
            DomicilioDAOH2 domicilioDAOH2=new DomicilioDAOH2();
            domicilioDAOH2.guardar(paciente.getDomicilio());
            //conexión
            connection=getConnection();
            //preparar el guardado
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO pacientes (nombre, dni, fecha_ingreso, domicilio_id) VALUES (?,?,?,?)");
            preparedStatement.setString(1,paciente.getNombre());
            preparedStatement.setInt(2,paciente.getDni());
            preparedStatement.setDate(3, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(4,paciente.getDomicilio().getId());
            // ejecutar
            preparedStatement.executeUpdate();

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
        return paciente;
    }

    @Override
    public Paciente buscar(int id) {
        Connection connection=null;
        Paciente paciente=null;
        Domicilio domicilio=null;

        try{
            DomicilioDAOH2 domicilioDAOH2= new DomicilioDAOH2();
            //conexión a base
            connection=getConnection();
            PreparedStatement preparedStatement= connection.prepareStatement("SELECT * FROM pacientes WHERE ID=?");
            preparedStatement.setInt(1,id);

            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int id_dom= rs.getInt(5);
                domicilio=domicilioDAOH2.buscar(id_dom);
                //cargar los datos de paciente en el objeto final
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4).toLocalDate(),domicilio);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            {
                try{
                    connection.close();
                }
                catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        }

        return paciente;
    }

    private static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase15","sa","sa");
    }
}
