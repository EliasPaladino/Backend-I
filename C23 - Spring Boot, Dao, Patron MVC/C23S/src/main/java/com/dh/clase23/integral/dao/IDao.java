package com.dh.clase23.integral.dao;

import java.util.List;

public interface IDao <T> {

    void guardar(T t);

    T buscar(Long id);

    List<T> listarElementos();

}
