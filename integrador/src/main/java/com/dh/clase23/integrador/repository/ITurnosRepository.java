package com.dh.clase23.integrador.repository;

import com.dh.clase23.integrador.dominio.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnosRepository extends JpaRepository<Turno, Integer> {
}
