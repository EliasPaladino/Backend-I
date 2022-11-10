package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RegistroTest {
    @Test
    public void vacunarPersonaCorrecta(){
        //dado
        Persona persona= new Persona("Juan", "Perez","36854758","Pfizer",new Date(2022-1900,3-1,4));
        Registro registro= new RegistroVacunaProxy();
        String respEsperada="Se ha registrado el DNI 36854758 como persona vacunada con Pfizer";
        //cuando
        String respuesta=registro.vacunar(persona);
        //encontes
        Assertions.assertEquals(respEsperada,respuesta);
    }

}