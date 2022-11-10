package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App(){
        listaEnteros= new ArrayList<>();
    }

    public void agregarEntero(Integer n){
        listaEnteros.add(n);
        if (listaEnteros.size()>5){
            //aquí tenemos que escribir en el log
            logger.info("La lista tiene más de 5 elementos, elementos totales: "+listaEnteros.size());
        }
        
    }
}
