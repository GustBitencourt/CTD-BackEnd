package com.ProjetoFinal.service;

import com.ProjetoFinal.entities.Paciente;
import com.ProjetoFinal.repositories.EnderecoRepository;
import com.ProjetoFinal.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository PacienteRepository;

    @Autowired
    private EnderecoRepository EnderecoRepository;


    public Paciente salvar(Paciente paciente) {
        paciente.setDataCadastro(new Date());
        return PacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscar(Integer id) {
        return PacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos() {
        return PacienteRepository.findAll();
    }

    public void excluir(Integer id) {
        PacienteRepository.deleteById(id);
    }

    public Paciente atualizar(Paciente paciente) {
        paciente.setDataCadastro(new Date());
        return PacienteRepository.save(paciente);
    }
}
