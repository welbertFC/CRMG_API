package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AlunoDTO {

    private Integer id;

    @NotBlank(message = "Campo nome é obrigatorio")
    private String nome;

    @NotBlank(message = "Campo matricula é obrigatorio")
    private String matricula;

    private String sexo;
    private String nomeResponsavel;
    private String telefoneResponsavel;


    private LocalDate dataNascimento;

    @NotNull(message = "Campo obrigatorio")
    private Integer turma;
}
