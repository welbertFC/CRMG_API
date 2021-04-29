package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Objetivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;
    private String codigo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "campoExperiencia_id")
    private CampoExperiencia campoExperiencia;

    @OneToMany(mappedBy = "objetivo")
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
