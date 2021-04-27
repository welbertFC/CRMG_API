package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @OneToMany(mappedBy = "avaliacoes")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


}
