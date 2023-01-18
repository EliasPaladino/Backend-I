package com.dh.clase23.integrador.dominio;

public class Odontologo {
    private int id;
    private String apellido;
    private String nombre;
    private String matricula;

    public Odontologo() {
    }

    public Odontologo(int id, String apellido, String nombre, String matricula) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public Odontologo(String apellido, String nombre, String matricula) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }
}
