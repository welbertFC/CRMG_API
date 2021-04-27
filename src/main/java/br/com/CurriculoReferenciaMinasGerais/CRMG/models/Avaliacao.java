package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.enums.AvaliacaoEnum;
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
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivo;

    public Avaliacao(Integer id, Integer avaliacao, String observacao, Professor professor, Aluno aluno, Objetivo objetivo) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.observacao = observacao;
        this.professor = professor;
        this.aluno = aluno;
        this.objetivo = objetivo;
    }

    public AvaliacaoEnum getAvaliacao() {
        return AvaliacaoEnum.toEnum(avaliacao);
    }

    public void setAvaliacao(AvaliacaoEnum avaliacao) {
        this.avaliacao = avaliacao.getCodigo();
    }


}
