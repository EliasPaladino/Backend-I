package presencial;

import presencial.bd.BD;
import presencial.dao.MedicamentoDaoH2;
import presencial.modelo.Medicamento;
import presencial.service.MedicamentoService;

public class Main {
    public static void main(String[] args) throws Exception {
        MedicamentoService medicamentoService= new MedicamentoService(new MedicamentoDaoH2());
        BD.crearBD();

        Medicamento medicamento= new Medicamento("Ibuprofeno FORTE","lab123",4,658.5,51);
        medicamentoService.guardar(medicamento);
    }


}
