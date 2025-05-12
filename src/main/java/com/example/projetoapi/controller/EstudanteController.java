package com.example.projetoapi.controller;


import com.example.projetoapi.dto.EstudanteRequestDTO;
import com.example.projetoapi.model.Estudante;
import com.example.projetoapi.service.EstudanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EstudanteController {

    private final EstudanteService estudanteService;

    public EstudanteController(EstudanteService estudanteService) {
        this.estudanteService = estudanteService;
    }

    @GetMapping("/gerenciar")
    public List<Estudante> listarEstudantes() {
        return estudanteService.listarEstudantes();
    }
    @PostMapping("/inserir")
    public Estudante inserirEstudantes(EstudanteRequestDTO estudante) {
        return estudanteService.inserirEstudante(estudante);
    }
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        estudanteService.excluirEstudante(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Estudante> atualizarUsuario(@PathVariable Integer id, @RequestBody Estudante estudante) {
        Estudante atualizado = estudanteService.atualizarEstudante(id, estudante);
        return ResponseEntity.ok(atualizado);
    }
}
