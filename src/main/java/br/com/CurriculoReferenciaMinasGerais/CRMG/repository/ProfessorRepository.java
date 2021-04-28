package br.com.CurriculoReferenciaMinasGerais.CRMG.repository;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
