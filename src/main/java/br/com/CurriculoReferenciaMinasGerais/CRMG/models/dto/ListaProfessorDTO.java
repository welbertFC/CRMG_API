package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ListaProfessorDTO {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String telefone;
    private LocalDate dataNascimento;
    private String escola;

    public ListaProfessorDTO(Optional<Professor> professor) {
        this.id = professor.get().getId();
        this.nome = professor.get().getNome();
        this.email = professor.get().getEmail();
        this.senha = professor.get().getSenha();
        this.cpfCnpj = professor.get().getCpfCnpj();
        this.telefone = professor.get().getTelefone();
        this.dataNascimento = professor.get().getDataNascimento();
        this.escola = professor.get().getEscola().getNomeEscola();
    }


}
