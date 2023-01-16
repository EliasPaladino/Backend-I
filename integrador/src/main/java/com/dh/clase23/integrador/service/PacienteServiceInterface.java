package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dominio.Paciente;

import java.util.List;

public interface PacienteServiceInterface {
    List<Paciente> listarPacientes();
    Paciente buscarPorEmail(String email);
}
