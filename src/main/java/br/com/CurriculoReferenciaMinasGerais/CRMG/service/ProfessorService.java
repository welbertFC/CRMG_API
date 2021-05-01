package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.ListaProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.NovoProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.ProfessorRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private EscolaService escolaService;

    public ListaProfessorDTO findById(Integer id) {
        var professor = professorRepository.findById(id);
        professor.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado id: " + id));
        var professorDTO = new ListaProfessorDTO(professor);
        return professorDTO;
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor insert(NovoProfessorDTO professor) {
        var escola = escolaService.findById(professor.getIdEscola());
        return professorRepository.save(new Professor(professor, escola));
    }

    public Professor update(Integer id, Professor professor) {
        findById(id);
        return professorRepository.save(new Professor(id, professor));
    }
}
