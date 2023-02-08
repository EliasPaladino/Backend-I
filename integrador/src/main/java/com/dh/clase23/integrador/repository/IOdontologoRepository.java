package com.dh.clase23.integrador.repository;

import com.dh.clase23.integrador.dominio.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Integer> {
}
