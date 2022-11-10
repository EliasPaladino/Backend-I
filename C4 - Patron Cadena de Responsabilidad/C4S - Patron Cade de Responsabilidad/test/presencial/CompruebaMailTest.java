package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompruebaMailTest {
    @Test
    public void debeResponderComercial(){
        //dado
        CompruebaMail proceso= new CompruebaMail();
        String respuestaEsperada="Enviando a comercial";
        Mail correo = new Mail("rodolfo@gmail.com","comercial@colmena.com","Ayuda");
        //cuando
        String resultado= proceso.comprobar(correo);
        //entonces
        Assertions.assertEquals(respuestaEsperada,resultado);
    }

    @Test
    public void debeResponderSpam(){
        //dado
        CompruebaMail proceso= new CompruebaMail();
        String respuestaEsperada="Marcado como spam";
        Mail correo = new Mail("rodolfo@gmail.com","test@colmena.com","Ayuda");
        //cuando
        String resultado= proceso.comprobar(correo);
        //entonces
        Assertions.assertEquals(respuestaEsperada,resultado);
    }
}