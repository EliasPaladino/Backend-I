package com.dh.clase23.integrador.repository;

import com.dh.clase23.integrador.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
}
