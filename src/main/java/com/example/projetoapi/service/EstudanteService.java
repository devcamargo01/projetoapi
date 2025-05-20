package com.example.projetoapi.service;

import com.example.projetoapi.dto.EstudanteDTO;
import com.example.projetoapi.model.Estudante;
import com.example.projetoapi.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository repository;

    public Estudante create(EstudanteDTO dto) {
        Estudante student = calcularDados(dto);
        return repository.save(student);
    }

    public List<Estudante> getAll() {
        return repository.findAll();
    }

    public Estudante getById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Estudante update(Integer id, EstudanteDTO dto) {
        Estudante existing = repository.findById(id).orElse(null);
        if (existing != null) {
            Estudante atualizado = calcularDados(dto);
            atualizado.setId(id);
            return repository.save(atualizado);
        }
        return null;
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private Estudante calcularDados(EstudanteDTO dto) {
        double media = (dto.getNotaExatas() + dto.getNotaLinguagens() + dto.getNotaCiencias()) / 3.0;

        String desempenho;
        if (media >= 80) desempenho = "Excelente";
        else if (media >= 60) desempenho = "Bom";
        else if (media >= 40) desempenho = "Médio";
        else desempenho = "Ruim";

        String statusExatas = dto.getNotaExatas() > 60 ? "Aprovado" : "Reprovado";
        String statusLinguagens = dto.getNotaLinguagens() > 60 ? "Aprovado" : "Reprovado";
        String statusCiencias = dto.getNotaCiencias() > 60 ? "Aprovado" : "Reprovado";

        int aprovados = 0;
        if (statusExatas.equals("Aprovado")) aprovados++;
        if (statusLinguagens.equals("Aprovado")) aprovados++;
        if (statusCiencias.equals("Aprovado")) aprovados++;

        String statusFinal = aprovados >= 2 ? "Aprovado" : "Reprovado";

        return Estudante.builder()
                .nome(dto.getNome())
                .sobrenome(dto.getSobrenome())
                .genero(dto.getGenero())
                .dataNascimento(dto.getDataNascimento())
                .superioridadePais(dto.getEscolaridadePais())
                .tipoAlimentacao(dto.getTipoAlimentacao())
                .notaExatas(dto.getNotaExatas())
                .notaLinguagens(dto.getNotaLinguagens())
                .notaCiencias(dto.getNotaCiencias())
                .mediaGeral(media)
                .desempenho(desempenho)
                .statusExatas(statusExatas)
                .statusLinguagens(statusLinguagens)
                .statusCiencias(statusCiencias)
                .statusFinal(statusFinal)
                .build();
    }
}
