package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.ProfessorRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor findById(Integer id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado id: " + id));
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor insert(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Integer id, Professor professor) {
        findById(id);
        return professorRepository.save(new Professor(id, professor));
    }
}
