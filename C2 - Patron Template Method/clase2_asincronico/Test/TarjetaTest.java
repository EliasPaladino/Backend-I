import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Calendar;
import java.util.Date;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

class TarjetaTest {
    @Test
    public void fecha(){
        Date fecha = new Date(Calendar.getInstance().getTimeInMillis());
        System.out.println(fecha);

        Assertions.assertTrue((BooleanSupplier) fecha);
    }
}