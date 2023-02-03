package com.dh.clase23.integrador.service;

import com.dh.clase23.integrador.dao.IDao;
import com.dh.clase23.integrador.dominio.Turno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private IDao<Turno> turnoIDao;

    public TurnoService(IDao<Turno> turnoIDao) {
        this.turnoIDao = turnoIDao;
    }

    public Turno buscarPorId(int id) { return turnoIDao.buscarPorId(id); }
    public List<Turno> listarTurnos() {
        return turnoIDao.listarElementos();
    }
    public Turno guardarTurno(Turno turno) { return turnoIDao.guardar(turno); }
    public Turno actualizarTurno(Turno turno) { return turnoIDao.actualizar(turno);}
    public void eliminarTurno(int id) { turnoIDao.eliminar(id); }
}
