package com.example.projetoapi.service;

import com.example.projetoapi.dto.EstudanteRequestDTO;
import com.example.projetoapi.model.Estudante;
import com.example.projetoapi.repository.EstudanteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EstudanteService {
    private final EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public List<Estudante> listarEstudantes() {
        return estudanteRepository.findAll();
    }
    public void excluirEstudante(Integer id) {
        if (!estudanteRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        estudanteRepository.deleteById(id);
    }
    public Estudante atualizarEstudante(Integer id, Estudante estudanteAtualizado) {
        Estudante estudanteExistente = estudanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        estudanteExistente.setNome(estudanteAtualizado.getNome());
        estudanteExistente.setEmail(estudanteAtualizado.getEmail());
        estudanteExistente.setAno(estudanteAtualizado.getAno());
        estudanteExistente.setSerie(estudanteAtualizado.getSerie());
        estudanteExistente.setNotaExatas(estudanteAtualizado.getNotaExatas());
        estudanteExistente.setNotaLinguagens(estudanteAtualizado.getNotaLinguagens());
        estudanteExistente.setNotaCiencias(estudanteAtualizado.getNotaCiencias());

        return estudanteRepository.save(estudanteExistente);
    }
    public Estudante inserirEstudante(EstudanteRequestDTO dto) {
        String[] partes = dto.getNomeCompleto().trim().split("\\s+");

        String nome = partes[0];
        String sobrenome = partes.length > 1
                ? String.join(" ", Arrays.copyOfRange(partes, 1, partes.length))
                : "";

        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setSobrenome(sobrenome);
        estudante.setEmail(dto.getEmail());
        estudante.setGenero(dto.getGenero());
        estudante.setDataNascimento(dto.getDataNascimento());
        estudante.setTipoAlimentacao(dto.getTipoAlimentacao());
        estudante.setSuperioridadePais(dto.getSuperioridadePais());

        return estudanteRepository.save(estudante);
    }
}
