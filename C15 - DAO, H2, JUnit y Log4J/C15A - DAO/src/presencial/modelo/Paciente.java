package presencial.modelo;

import java.time.LocalDate;

public class Paciente {
    private int id;
    private String nombre;
    private int dni;
    private LocalDate fechaIngreso;
    private Domicilio domicilio;

    public Paciente(int id, String nombre, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(String nombre, int dni, LocalDate fechaIngreso, Domicilio domicilio) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
    @Override
    public String toString(){
        return "ID= "+id
                +"\nNombre= "+nombre
                +"\nDNI= "+dni
                +"\nFecha Ingreso= "+fechaIngreso
                +"\nDomicilio:\n"+domicilio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
