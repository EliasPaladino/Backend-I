package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    @Test
    public void testearNombre(){
        //Dado
        Persona juan = new Persona("Juan", "Perez", "JuanPerez@gmail.com", 19);

        //Cuando
        String nombreCompleto = juan.mostrarNombre();

        //Entonces
        Assertions.assertEquals("Perez, Juan", nombreCompleto);
    }

}