package ejercicioSincronico;

import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private List<Persona> listaPersonas;

    public Grupo() {
        listaPersonas = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {
        if(p.getEdad() >= 18 && p.getNombre().length() >= 5){
            listaPersonas.add(p);
        } else {
            System.err.println("No se pudo agregar a "+p);
        }
    }

    public int obtenerCantPersonasEnElGrupo(){
        return listaPersonas.size();
    }
}
