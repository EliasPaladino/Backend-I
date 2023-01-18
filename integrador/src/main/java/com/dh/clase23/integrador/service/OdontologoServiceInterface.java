package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dominio.Odontologo;

import java.util.List;

public interface OdontologoServiceInterface {
    List<Odontologo> listarOdontologos();
    Odontologo buscarPorId(int id);
    Odontologo registar(Odontologo odontologo);
    Odontologo modificar(Odontologo odontologo);
    void eliminar(int id);
}
