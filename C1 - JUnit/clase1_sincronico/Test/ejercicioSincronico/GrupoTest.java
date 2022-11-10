package ejercicioSincronico;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrupoTest {
    @Test
    public void altaGrupo(){
        //Dado
        Persona juan = new Persona("Juan", 18);
        Persona pedro = new Persona("Pedro", 23);
        Persona ana = new Persona("Ana", 19);
        Persona luz = new Persona("Luz", 21);
        Persona julian = new Persona("Julian", 22);

        Grupo grupo = new Grupo();

        //Cuando

        grupo.agregarPersona(juan);
        grupo.agregarPersona(pedro);
        grupo.agregarPersona(ana);
        grupo.agregarPersona(luz);
        grupo.agregarPersona(julian);

        //Entonces
        Assertions.assertTrue(grupo.obtenerCantPersonasEnElGrupo() == 2);
    }
}