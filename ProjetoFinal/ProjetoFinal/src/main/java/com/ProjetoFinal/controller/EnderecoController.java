package com.ProjetoFinal.controller;

import com.ProjetoFinal.entities.Endereco;
import com.ProjetoFinal.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    //CREATE - Criando
    @PostMapping()
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {

        return ResponseEntity.ok(enderecoService.salvar(endereco));

    }

    //READ - Lendo
    @GetMapping("/{id}")
    public ResponseEntity<Endereco> buscar(@PathVariable Integer id) {
        Endereco endereco = enderecoService.buscar(id).orElse(null);

        return ResponseEntity.ok(endereco);
    }

    //UPDATE - Atualizando
    @PutMapping()
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {
        ResponseEntity<Endereco> response = null;

        if (endereco.getId() != null && enderecoService.buscar(endereco.getId()).isPresent())
            response = ResponseEntity.ok(enderecoService.atualizar(endereco));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    //DELETE - Apagando
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (enderecoService.buscar(id).isPresent()) {
            enderecoService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Endereço Excluido");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> buscarTodos(){
        return ResponseEntity.ok(enderecoService.buscarTodos());
    }
}
