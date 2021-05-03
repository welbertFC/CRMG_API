package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.ListTurmaDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.NovaTurmaDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.ProfessorRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.TurmaRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public ListTurmaDTO findById(Integer id) {
        var turma = turmaRepository.findById(id);
        turma.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrada id: " + id));
        var turmaDTO = new ListTurmaDTO(turma);
        return turmaDTO;
    }

    public List<ListTurmaDTO> findAll() {
       var turmas = turmaRepository.findAll();
       var turmasDto = turmas.stream().map(obj ->
               new ListTurmaDTO(obj)).collect(Collectors.toList());
       return turmasDto;
    }

    public Turma insert(NovaTurmaDTO turma) {
        var professorOptional = professorRepository.findById(turma.getProfessor());
        var professor = professorOptional.orElseThrow(
                () -> new ObjectNotFoundException("Professor não existe id: " + turma.getProfessor()));
        return turmaRepository.save(new Turma(turma, professor));
    }

    public Turma update(Integer id, Turma turma) {
        return turmaRepository.save(new Turma(id, turma));
    }
}
