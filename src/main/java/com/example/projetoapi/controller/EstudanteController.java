package com.example.projetoapi.controller;

import com.example.projetoapi.dto.EstudanteDTO;
import com.example.projetoapi.model.Estudante;
import com.example.projetoapi.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
//especifique os imports exemplo: import org.springframework.web.bind.annotation.RestController; evite usar .*

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    //Utilizar a injeção de dependências com construtor
    @Autowired
    private EstudanteService service;

    //Para todas as rotas fazer validações para retornar um ResponseEntity indicando o status adequado e o body resultante
    @PostMapping("/inserir")
    public Estudante create(@RequestBody EstudanteDTO dto) {
        return service.create(dto);
    }

    @GetMapping("/gerenciar")
    public List<Estudante> getAll() {
        return service.getAll();
    }

    @GetMapping("gerenciar/{id}")
    public Estudante getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("atualizar/{id}")
    public Estudante update(@PathVariable Integer id, @RequestBody EstudanteDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("excluir/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
