package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Professor extends Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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


    public Professor(Integer id, Professor professor) {
        this.id = id;
        this.cpfCnpj = professor.getCpfCnpj();
        this.telefone = professor.getTelefone();
        this.dataNascimento = professor.getDataNascimento();
        this.escola = professor.getEscola();
        super.setNome(professor.getNome());
        super.setEmail(professor.getEmail());
        super.setSenha(professor.getSenha());
        super.setTipo(professor.getTipo());
    }
}
