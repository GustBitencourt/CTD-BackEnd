package com.dh.medicamentos.Service;

import com.dh.medicamentos.Dao.IDao;
import com.dh.medicamentos.Model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }

    public Medicamento buscar(Integer id) {
        return medicamentoDao.buscar(id);
    }
}
