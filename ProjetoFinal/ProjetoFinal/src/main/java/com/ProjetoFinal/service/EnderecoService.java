package com.ProjetoFinal.service;

import com.ProjetoFinal.entities.Endereco;
import com.ProjetoFinal.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository EnderecoRepository;

    public Endereco salvar(Endereco endereco){
        EnderecoRepository.save(endereco);
        return endereco;
    }

    public Optional<Endereco> buscar(Integer id){
        return EnderecoRepository.findById(id);
    }

    public List<Endereco> buscarTodos(){
        return EnderecoRepository.findAll();
    }

    public void excluir(Integer id){
        EnderecoRepository.deleteById(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return EnderecoRepository.save(endereco);
    }

}
