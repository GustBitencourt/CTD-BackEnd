package com.ProjetoFinal.service;

import com.ProjetoFinal.entities.Usuario;
import com.ProjetoFinal.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return UsuarioRepository.save(usuario);
    }

    public void excluir(Integer id){
        UsuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscar(Integer id){
        return UsuarioRepository.findById(id);
    }

    public List<Usuario> buscarTodos(){
        return UsuarioRepository.findAll();
    }

    public Usuario atualizar(Usuario usuario){
        return UsuarioRepository.save(usuario);
    }
}
