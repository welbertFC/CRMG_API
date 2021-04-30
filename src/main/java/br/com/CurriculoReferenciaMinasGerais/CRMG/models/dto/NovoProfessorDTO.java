package br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class NovoProfessorDTO {


    private Integer id;
    private String nome;


    private String email;


    private String senha;

    private String cpfCnpj;

    private String telefone;

    private LocalDate dataNascimento;

    private Integer idEscola;

}
