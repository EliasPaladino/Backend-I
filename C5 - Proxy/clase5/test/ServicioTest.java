
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {
    @Test
    public void descarga(){
        //dado
        Usuario usuario = new Usuario(12, "Premium");
        Servicio servicio = new ServicioDescargaProxy();

        //cuando
        String respuesta = servicio.descargar(usuario);

        //entonces
        Assertions.assertEquals(respuesta, "El usuario " +usuario.getId()+ " puede descargar la canción");
        System.out.println(respuesta);
    }
}