package com.dh.clase23.integrador.dominio;

import java.sql.Date;

public class Turno {
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private Date fecha;

    public Turno() {
    }

    public Turno(Odontologo odontologo, Paciente paciente, Date fecha) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public Turno(int id, Odontologo odontologo, Paciente paciente, Date fecha) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
