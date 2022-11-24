package com.dh.clase22.entrenador.service;

import com.dh.clase22.entrenador.domain.Entrenador;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Override
    public List<Entrenador> listaEntrenadores() {
        List<Entrenador> lista = new ArrayList<>();

        lista.add(new Entrenador("Elias"));
        lista.add(new Entrenador("Juan"));

        return lista;
    }
}
