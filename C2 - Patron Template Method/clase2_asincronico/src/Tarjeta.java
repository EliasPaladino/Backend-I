import java.util.Calendar;
import java.util.Date;

public abstract class Tarjeta {
    private int numeroDelFrente;
    private int codigoDeSeguridad;
    private Date fechaExpiracion;

    public Tarjeta(int numeroDelFrente, int codigoDeSeguridad, Date fechaExpiracion) {
        this.numeroDelFrente = numeroDelFrente;
        this.codigoDeSeguridad = codigoDeSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }

    Date fecha = new Date(Calendar.getInstance().getTimeInMillis());

    public Boolean validarFecha(){
        return false;
    }
}
