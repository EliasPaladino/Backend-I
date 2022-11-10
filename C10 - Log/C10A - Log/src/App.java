import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.log4j.Logger;

public class App {
    private static final Logger logger = Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros = new ArrayList<>();
    }

    public void agregarEntero(Integer n){
        listaEnteros.add(n);
        if(listaEnteros.size() > 10){
            logger.info("La longitud de la lista es mayor a 10. Tiene "+listaEnteros.size()+ " numeros");
        } else if(listaEnteros.size() > 5){
            logger.info("La longitud de la lista es mayor a 5. Tiene "+listaEnteros.size()+ " numeros");
        }
    }

    public void estaVacio(){
        if(listaEnteros.isEmpty()){
            logger.error("La lista es igual a cero ");
        }
    }

    public void promedio(){
        double acumulador = 0.0;

        for (Integer entero : listaEnteros) {
            acumulador += entero;
        }


        logger.info("El promedio es "+ acumulador/listaEnteros.size());
    }
}
