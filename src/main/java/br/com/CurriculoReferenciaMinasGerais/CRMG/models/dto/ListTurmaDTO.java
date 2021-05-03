package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class ListTurmaDTO {

    private Integer id;
    private String nome;
    private String periodo;
    private String descricao;
    private String professor;

    public ListTurmaDTO(Optional<Turma> turma) {
        this.id = turma.get().getId();
        this.nome = turma.get().getNome();
        this.periodo = turma.get().getPeriodo();
        this.descricao = turma.get().getDescricao();
        this.professor = turma.get().getProfessor().getNome();
    }

    public ListTurmaDTO(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.periodo = turma.getPeriodo();
        this.descricao = turma.getDescricao();
        this.professor = turma.getProfessor().getNome();
    }
}
