package com.example.projetoapi.dto;

import lombok.Data;

@Data
public class EstudanteDTO {
    private String nome;
    private String sobrenome;
    private String genero;
    private String dataNascimento;
    private String escolaridadePais;
    private String tipoAlimentacao;
    private double notaExatas;
    private double notaLinguagens;
    private double notaCiencias;
}
