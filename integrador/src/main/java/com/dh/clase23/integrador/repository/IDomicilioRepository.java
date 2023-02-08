package com.dh.clase23.integrador.repository;

import com.dh.clase23.integrador.dominio.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDomicilioRepository extends JpaRepository<Domicilio, Integer> {
}
