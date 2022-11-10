package presencial;

public class ManejadorTecnico extends Manejador{
    @Override
    public String comprobar(Mail elMail) {
        if(elMail.getDestino().equals("tecnico@colmena.com")||elMail.getTema().equals("tecnico")){
            return "Enviando a tecnico";
        }
        else{
            return getSiguienteManejador().comprobar(elMail);
        }
    }
}
