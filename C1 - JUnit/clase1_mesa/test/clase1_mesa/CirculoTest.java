package clase1_mesa;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class CirculoTest {
    private double radio = 1;

    @Test
    public void areaCirculo(){
        //Dado
        Circulo circulo = new Circulo("Circulo", 0.0);

        //Cuando

        circulo.setArea(circulo.calcularArea(radio));

        //Entonces
        circulo.mostrarArea();
        Assert.assertTrue(circulo.getArea() == (Math.PI * radio * radio));
    }

}