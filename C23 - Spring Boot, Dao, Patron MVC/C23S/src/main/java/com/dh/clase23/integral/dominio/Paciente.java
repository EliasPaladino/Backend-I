package com.dh.clase23.integral.dominio;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private LocalDate fechaIngreso;
    private Long domicilio_id;

    public Paciente() {
    }

    public Paciente(Long id, String nombre, String apellido, String email, String dni, LocalDate fechaIngreso, Long domicilio_id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio_id = domicilio_id;
    }

    public Paciente(String nombre, String apellido, String email, String dni, LocalDate fechaIngreso, Long domicilio_id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio_id = domicilio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public Long getDomicilio_id() {
        return domicilio_id;
    }
}
