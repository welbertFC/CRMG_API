package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.TurmaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String periodo;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos = new ArrayList<>();

    public Turma(Integer id, TurmaDTO turma, Professor professor) {
        this.id = id;
        this.nome = turma.getNome();
        this.periodo = turma.getPeriodo();
        this.descricao = turma.getDescricao();
        this.professor = professor;
    }

    public Turma(TurmaDTO turmaDTO, Professor professor) {
        this.id = turmaDTO.getId();
        this.nome = turmaDTO.getNome();
        this.periodo = turmaDTO.getPeriodo();
        this.descricao = turmaDTO.getDescricao();
        this.professor = professor;
    }
}
