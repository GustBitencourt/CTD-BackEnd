package com.medicamentos.service;

import com.medicamentos.dao.ipml.IDao;
import com.medicamentos.model.Medicamento;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoDao;

    public MedicamentoService(IDao<Medicamento> medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public Medicamento salvar(Medicamento medicamento) {
        return medicamentoDao.salvar(medicamento);
    }

    public Medicamento buscarId(Integer id) {
        return medicamentoDao.buscar(id);
    }
}
