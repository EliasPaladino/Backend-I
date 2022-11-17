package presencial.modelo;

public class Medicamento {
    private Integer id;
    private String nombre;
    private String laboratorio;
    private Integer cantidad;
    private Double precio;
    private Integer codigoNumerico;

    public Medicamento(String nombre, String laboratorio, Integer cantidad, Double precio, Integer codigoNumerico) {
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoNumerico = codigoNumerico;
    }

    public Medicamento(Integer id, String nombre, String laboratorio, Integer cantidad, Double precio, Integer codigoNumerico) {
        this.id = id;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.cantidad = cantidad;
        this.precio = precio;
        this.codigoNumerico = codigoNumerico;
    }

    @Override
    public String toString(){
        return "Medicamento: "+nombre+" - precio: "+precio;
    }

    public Integer getCodigoNumerico() {
        return codigoNumerico;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }
}
