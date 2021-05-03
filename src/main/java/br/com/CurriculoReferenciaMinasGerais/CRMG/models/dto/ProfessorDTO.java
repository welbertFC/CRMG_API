package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@Data
@NoArgsConstructor
public class ProfessorDTO {


    private Integer id;

    @NotBlank(message = "campo Nome é obrigatorio")
    private String nome;

    @Email(message = "Email Invalido")
    @NotBlank(message = "Campo Email é obrigatorio")
    private String email;

    @NotBlank(message = "Campo senha é obrigatorio")
    @NotNull(message = "Campo senha não pode ser nulo")
    @Length(min = 6, max = 16, message = "Tamanho invalido")
    private String senha;

    private String cpfCnpj;

    private String telefone;


    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatorio")
    private Integer idEscola;

    public ProfessorDTO(Optional<Professor> professor) {
        this.id = professor.get().getId();
        this.nome = professor.get().getNome();
        this.email = professor.get().getEmail();
        this.senha = professor.get().getSenha();
        this.cpfCnpj = professor.get().getCpfCnpj();
        this.telefone = professor.get().getTelefone();
        this.dataNascimento = professor.get().getDataNascimento();
        this.idEscola = professor.get().getEscola().getId();
    }

    public ProfessorDTO(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.senha = professor.getSenha();
        this.cpfCnpj = professor.getCpfCnpj();
        this.telefone = professor.getTelefone();
        this.dataNascimento = professor.getDataNascimento();
        this.idEscola = professor.getEscola().getId();
    }

}
