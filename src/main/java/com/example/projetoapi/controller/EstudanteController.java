package com.example.projetoapi.controller;


import com.example.projetoapi.dto.EstudanteRequestDTO;
import com.example.projetoapi.model.Estudante;
import com.example.projetoapi.service.EstudanteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.noContent().build();
    }
    @PutMapping("atualizar/{id}")
    public ResponseEntity<Estudante> atualizarUsuario(@PathVariable Integer id, @RequestBody Estudante estudante) {
        Estudante atualizado = estudanteService.atualizarEstudante(id, estudante);
        return ResponseEntity.ok(atualizado);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email,
                                   @RequestParam String senha,
                                   HttpSession session) {
        boolean success = estudanteService.authenticate(email, senha);
        if (success) {
            session.setAttribute("email", email);
            return ResponseEntity.ok("Login realizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha inválidos.");
        }
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession sessao) {
        sessao.invalidate();
        return ResponseEntity.ok("Logout realizado.");
    }
}
