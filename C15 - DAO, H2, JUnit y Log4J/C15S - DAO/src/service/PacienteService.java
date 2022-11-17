package service;

import dao.IDao;
import model.Paciente;

public class PacienteService {

    private IDao<Paciente> pacienteDao;

    public PacienteService(IDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void agregar(Paciente paciente) { pacienteDao.agregar(paciente);}

    public Paciente buscar(Long id) { return pacienteDao.buscar(id);}

    public void modificar(Paciente paciente) { pacienteDao.modificar(paciente);}

    public void eliminar(Long id) { pacienteDao.eliminar(id);}

}
