package com.ProjetoFinal.controller;

import com.ProjetoFinal.dto.ConsultaDTO;
import com.ProjetoFinal.entities.Consulta;
import com.ProjetoFinal.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    //CREATE - Criando
    @PostMapping
    public ResponseEntity<Consulta> salvar(@RequestBody ConsultaDTO consultaDto) {
        Consulta consulta = consultaService.salvar(consultaDto);
        return new ResponseEntity<>(consulta, HttpStatus.CREATED);
    }

    //READ - Lendo
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscar(id).orElse(null);

        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> buscarTodos() {
        return ResponseEntity.ok(consultaService.buscarTodos());
    }

    //DELETE - Excluindo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (consultaService.buscar(id).isPresent()) {
            consultaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    //UPDATE - Atualizando
    @PutMapping
    public ResponseEntity<Consulta> atualizar(@RequestBody ConsultaDTO consultaDto) {
        consultaService.salvar(consultaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
