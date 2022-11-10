package clase1_mesa;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CuadradoTest {
    @Test
    public void areaCuadrado(){
        //Dado
        Cuadrado cuadrado = new Cuadrado("Cuadrado", 0.0);

        //Cuando
        cuadrado.setArea(cuadrado.calcularArea(2));

        //Entonces
        cuadrado.mostrarArea();
        Assert.assertTrue(cuadrado.getArea() == 4);
    }
}