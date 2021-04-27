package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.enums.AvaliacaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Avaliacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer avaliacao;
    private String observacao;


    public Avaliacao(Integer id, AvaliacaoEnum avaliacao, String observacao) {
        this.id = id;
        this.avaliacao = (avaliacao == null) ? null : avaliacao.getCodigo();
        this.observacao = observacao;
    }

    public AvaliacaoEnum getAvaliacao() {
        return AvaliacaoEnum.toEnum(avaliacao);
    }

    public void setAvaliacao(AvaliacaoEnum avaliacao) {
        this.avaliacao = avaliacao.getCodigo();
    }


}
