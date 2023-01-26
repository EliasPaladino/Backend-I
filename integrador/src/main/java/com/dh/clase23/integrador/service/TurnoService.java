package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dao.IDao;
import com.dh.clase23.integrador.dominio.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;
    public List<Turno> listarTurnos() {
        return turnoIDao.listarElementos();
    }
}
