package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NovoProfessorDTO {


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

}
