package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String matricula;
    private String sexo;
    private String nomeResponsavel;
    private String telefoneResponsavel;
    private LocalDate dataNascimento;
}
