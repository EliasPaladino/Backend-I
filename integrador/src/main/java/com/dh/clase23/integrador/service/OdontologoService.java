package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dao.IDao;
import com.dh.clase23.integrador.dominio.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdontologoService implements OdontologoServiceInterface {
   private IDao<Odontologo> odontologoIDao;

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarElementos();
    }

    @Override
    public Odontologo buscarPorId(int id) {
        return odontologoIDao.buscarPorId(id);
    }

    @Override
    public Odontologo registar(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return odontologoIDao.actualizar(odontologo);
    }

    @Override
    public void eliminar(int id) {
        odontologoIDao.eliminar(id);
    }
}
