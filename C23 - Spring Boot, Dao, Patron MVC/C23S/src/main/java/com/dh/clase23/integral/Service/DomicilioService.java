package com.dh.clase23.integral.Service;

import com.dh.clase23.integral.dao.DomicilioDAOH2;
import com.dh.clase23.integral.dao.IDao;
import com.dh.clase23.integral.dominio.Domicilio;

import java.util.List;

public class DomicilioService {

    private IDao<Domicilio> domicilioIDao = new DomicilioDAOH2();

    public void guardar(Domicilio domicilio) {
        domicilioIDao.guardar(domicilio);
    }

    public Domicilio buscar(Long id) {
        return domicilioIDao.buscar(id);
    }

    public List<Domicilio> listar() {
        return domicilioIDao.listarElementos();
    }

}
