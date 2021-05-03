package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;


import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Data
@NoArgsConstructor
public class TurmaDTO {

    private Integer id;

    @NotBlank(message = "campo Nome é obrigatorio")
    private String nome;

    @NotBlank(message = "campo Periodo é obrigatorio")
    private String periodo;

    private String descricao;

    @NotNull(message = "Campo obrigatorio")
    private Integer professor;

    public TurmaDTO(Optional<Turma> turma) {
        this.id = turma.get().getId();
        this.nome = turma.get().getNome();
        this.periodo = turma.get().getPeriodo();
        this.descricao = turma.get().getDescricao();
        this.professor = turma.get().getProfessor().getId();
    }

    public TurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.periodo = turma.getPeriodo();
        this.descricao = turma.getDescricao();
        this.professor = turma.getProfessor().getId();
    }


}
