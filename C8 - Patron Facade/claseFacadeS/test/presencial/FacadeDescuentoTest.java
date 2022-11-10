package presencial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeDescuentoTest {
    @Test
    public void descuento30(){
        //dado
        FacadeDescuento fachada= new FacadeDescuento();
        Tarjeta tarj= new Tarjeta("354875485752466", "Star Bank");
        Producto m1= new Producto("Arvejas","Latas");
        int cantidad=5;
        int descuentoEsperado=30;
        //cuando
        int descuentoCalculado=fachada.descuento(tarj,m1,cantidad);
        //entonces
        Assertions.assertEquals(descuentoEsperado,descuentoCalculado);
    }
}