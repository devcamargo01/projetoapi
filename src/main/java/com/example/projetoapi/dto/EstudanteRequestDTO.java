package com.example.projetoapi.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstudanteRequestDTO {
    private String email;
    private String nomeCompleto;
    private String genero;
    private Date dataNascimento;
    private String tipoAlimentacao;
    private String superioridadePais;
}
