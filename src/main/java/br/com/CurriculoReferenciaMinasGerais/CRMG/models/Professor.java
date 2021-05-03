package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.ProfessorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cpfCnpj;
    private String telefone;
    private LocalDate dataNascimento;


    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<Avaliacao> avaliacoes = new ArrayList<>();


    public Professor(Integer id, ProfessorDTO professorDTO, Escola escola) {
        this.id = id;
        this.nome = professorDTO.getNome();
        this.email = professorDTO.getEmail();
        this.senha = professorDTO.getSenha();
        this.cpfCnpj = professorDTO.getCpfCnpj();
        this.telefone = professorDTO.getTelefone();
        this.dataNascimento = professorDTO.getDataNascimento();
        this.escola = escola;
    }

    public Professor(ProfessorDTO professorDTO, Escola escola) {
        this.id = professorDTO.getId();
        this.nome = professorDTO.getNome();
        this.email = professorDTO.getEmail();
        this.senha = professorDTO.getSenha();
        this.cpfCnpj = professorDTO.getCpfCnpj();
        this.telefone = professorDTO.getTelefone();
        this.dataNascimento = professorDTO.getDataNascimento();
        this.escola = escola;
    }
}
