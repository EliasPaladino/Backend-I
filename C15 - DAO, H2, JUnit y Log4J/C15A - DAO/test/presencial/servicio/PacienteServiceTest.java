package presencial.servicio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import presencial.dao.PacienteDAOH2;
import presencial.modelo.Domicilio;
import presencial.modelo.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PacienteServiceTest {
    @BeforeAll
    public static void cargarBD(){
        Connection connection=null;
        try{
            Class.forName("org.h2.Driver").newInstance();
            connection= DriverManager.getConnection("jdbc:h2:~/clase15;INIT=RUNSCRIPT FROM 'create.sql'","sa","sa");
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
    }
    @Test
    public void guardarPaciente(){
        //dado
        PacienteService pacienteService= new PacienteService(new PacienteDAOH2());
        Domicilio domicilio= new Domicilio("Calle D",847,"Salta Capital","Salta");
        Paciente paciente= new Paciente("Kevin",54874185, LocalDate.of(2022,3,2),domicilio);
        Paciente pacienteResultado;
        int resultadoEsperado=3;
        //cuando
        pacienteService.guardar(paciente);
        pacienteResultado=pacienteService.buscar(3);
        //entonces
        Assertions.assertEquals(pacienteResultado.getId(),resultadoEsperado);
    }
}