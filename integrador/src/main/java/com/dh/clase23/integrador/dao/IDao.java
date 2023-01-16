package com.dh.clase23.integrador.dao;

import java.util.List;

public interface IDao <T> {
    List<T> listarElementos();
    T buscarPorId(int id);
    T buscarPorEmail(String email);
}
