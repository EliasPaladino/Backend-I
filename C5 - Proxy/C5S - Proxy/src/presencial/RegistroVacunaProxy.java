package presencial;

import java.util.Date;

public class RegistroVacunaProxy implements Registro{
    private RegistroVacuna registro;

    @Override
    public String vacunar(Persona persona) {
        Date hoy= new Date();
        String mensaje="Vuelva cuando sea su turno. :D";
        if (hoy.after(persona.getFechaAsignada())){
            // tiene que pasar al otro sector de vacunación
            registro= new RegistroVacuna();
            mensaje=registro.vacunar(persona);
        }
        return mensaje;
    }
}
