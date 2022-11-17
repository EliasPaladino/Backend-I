import dao.PacienteDAOH2;
import model.Domicilio;
import model.Paciente;
import service.PacienteService;

import java.sql.Connection;
import java.sql.DriverManager;

public class Prueba {
    public static void main(String[] args) throws Exception{
        Connection connection = null;

        try {

            Class.forName("org.h2.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:h2:~/clase15s;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

        PacienteService pacienteService = new PacienteService(new PacienteDAOH2());

        Domicilio domicilio = new Domicilio(1L,"Calle 1", "123", "Virrey del pino", "Buenos Aires");
        Paciente paciente = new Paciente(1L,"Paladino", "Elias", "12345", domicilio);

        pacienteService.agregar(paciente);
    }
}
