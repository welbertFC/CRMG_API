package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.AlunoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @JsonIgnore
    @OneToMany(mappedBy = "avaliacao")
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(Integer id, Aluno aluno) {
        this.id = id;
        this.nome = aluno.getNome();
        this.matricula = aluno.getMatricula();
        this.sexo = aluno.getSexo();
        this.nomeResponsavel = aluno.getNomeResponsavel();
        this.telefoneResponsavel = aluno.getTelefoneResponsavel();
        this.dataNascimento = aluno.getDataNascimento();
        this.turma = aluno.getTurma();
    }

    public Aluno(AlunoDTO alunoDTO, Turma turma) {
        this.id = alunoDTO.getId();
        this.nome = alunoDTO.getNome();
        this.matricula = alunoDTO.getMatricula();
        this.sexo = alunoDTO.getSexo();
        this.nomeResponsavel = alunoDTO.getNomeResponsavel();
        this.telefoneResponsavel = alunoDTO.getTelefoneResponsavel();
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.turma = turma;
    }
}
