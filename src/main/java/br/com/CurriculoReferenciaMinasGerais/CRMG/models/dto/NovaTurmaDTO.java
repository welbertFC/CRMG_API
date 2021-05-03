package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovaTurmaDTO {

    private Integer id;
    private String nome;
    private String periodo;
    private String descricao;
    private Integer professor;
}
