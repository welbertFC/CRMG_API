package br.com.CurriculoReferenciaMinasGerais.CRMG.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Escola  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeEscola;
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private String diretor;
    private String cnpj;

    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Professor> professores = new ArrayList<>();

    public Escola(Integer id, Escola escola) {
        this.id = id;
        this.nomeEscola = escola.getNomeEscola();
        this.nome = escola.getNome();
        this.email = escola.getEmail();
        this.senha = escola.getSenha();
        this.endereco = escola.getEndereco();
        this.diretor = escola.getDiretor();
        this.cnpj = escola.getCnpj();
        this.telefones = escola.getTelefones();
    }
}
