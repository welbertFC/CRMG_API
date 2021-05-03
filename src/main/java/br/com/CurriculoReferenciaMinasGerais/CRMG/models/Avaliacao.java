package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.enums.AvaliacaoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer avaliacao;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    public Avaliacao(Integer id, AvaliacaoEnum avaliacao, String observacao, Professor professor, Aluno aluno, Objetivo objetivo) {
        this.id = id;
        this.avaliacao = (avaliacao == null) ? null : avaliacao.getCodigo();
        this.observacao = observacao;
        this.professor = professor;
        this.aluno = aluno;
        this.objetivo = objetivo;
    }

    public Avaliacao(Integer id, Avaliacao avaliacao){
        this.id = id;
        this.avaliacao = avaliacao.getAvaliacao().getCodigo();
        this.observacao = avaliacao.getObservacao();
        this.professor = avaliacao.getProfessor();
        this.aluno = avaliacao.getAluno();
        this.objetivo = avaliacao.getObjetivo();

    }

    public AvaliacaoEnum getAvaliacao() {
        return AvaliacaoEnum.toEnum(avaliacao);
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }


}
