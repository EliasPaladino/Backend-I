package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dominio.Paciente;

import java.util.List;

public interface PacienteServiceInterface {
    List<Paciente> listarPacientes();
    Paciente buscarPorEmail(String email);
    Paciente buscarPorId(int id);

    Paciente guardar(Paciente paciente);
    Paciente actualizar(Paciente paciente);
    void eliminar(int id);
}
