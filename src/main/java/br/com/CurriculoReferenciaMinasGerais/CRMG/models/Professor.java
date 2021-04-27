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
public class Professor extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String CpfCnpj;
    private String telefone;
    private LocalDate dataNascimento;


    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;

    @OneToMany(mappedBy = "turmas")
    private List<Turma> turmas = new ArrayList<>();

    @OneToMany(mappedBy = "avaliacoes")
    private List<Avaliacao> avaliacoes = new ArrayList<>();



}
