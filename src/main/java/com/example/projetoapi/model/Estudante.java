package com.example.projetoapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private int ano;
    private String serie;
    private String genero;
    private Date dataNascimento;
    private String superioridadePais;
    private String tipoAlimentacao;
    private double notaExatas;
    private double notaLinguagens;
    private double notaCiencias;
    private double mediaGeral;
    private int rankGeral;
    private String desempenho;
    private String statusExatas;
    private String statusLinguagens;
    private String statusCiencias;
    private String statusFinal;

}
