import presencial.dao.PacienteDAOH2;
import presencial.modelo.Domicilio;
import presencial.modelo.Paciente;
import presencial.servicio.PacienteService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Connection connection=null;
        try{
            Class.forName("org.h2.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:h2:~/clase15;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

        //servicio
        PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
        //creamos domicilio y paciente
        Domicilio domicilio= new Domicilio("Calle A",548,"Salta Capital","Salta");
        Paciente paciente= new Paciente("Rodolfo",548425, LocalDate.of(2022,3,1),domicilio);

        pacienteService.guardar(paciente);
    }
}
