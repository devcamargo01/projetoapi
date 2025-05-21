package com.example.projetoapi.model;

// especifique os imports exemplo: import jakarta.persistence.GeneratedValue; evite usar .*
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

//utilize o @Data
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private String dataNascimento;
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

    //Verificar se os nomes dos atributos são iguais as colunas da tabela no banco, se necessário use o @Column
}
