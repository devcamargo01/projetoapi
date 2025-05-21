package com.example.projetoapi.dto;

import lombok.Data;

@Data
// eu indicaria o uso de um record ao invés de um class pois facilitaria no retorno na intanciação e nos getters e setters
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
