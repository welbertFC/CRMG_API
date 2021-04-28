package br.com.CurriculoReferenciaMinasGerais.CRMG.repository;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
