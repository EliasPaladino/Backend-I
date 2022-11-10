package com.company;

public class Persona {
    private String nombre;
    private String apellido;
    private String email;
    private int edad;

    public Persona(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
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

    public int getEdad() {
        return edad;
    }

    public String mostrarNombre(){
        System.out.println(apellido + ", " + nombre);
        return (apellido + ", " + nombre);
    }

    public void calcucarMayorDeEdad(){
        if(edad >= 18){
            System.out.println(apellido + ", " + nombre + " es mayor de edad. Tiene " + edad + " años");
        } else {
            System.out.println(apellido + ", " + nombre + " no es mayor de edad. Tiene " + edad + " años");
        }
    }


}
