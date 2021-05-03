package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.TurmaDTO;
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

    public TurmaDTO findById(Integer id) {
        var turma = turmaRepository.findById(id);
        turma.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrada id: " + id));
        var turmaDTO = new TurmaDTO(turma);
        return turmaDTO;
    }

    public List<TurmaDTO> findAll() {
       var turmas = turmaRepository.findAll();
       var turmasDto = turmas.stream().map(obj ->
               new TurmaDTO(obj)).collect(Collectors.toList());
       return turmasDto;
    }

    public Turma insert(TurmaDTO turma) {
        var professorOptional = professorRepository.findById(turma.getProfessor());
        var professor = professorOptional.orElseThrow(
                () -> new ObjectNotFoundException("Professor não existe id: " + turma.getProfessor()));
        return turmaRepository.save(new Turma(turma, professor));
    }

    public TurmaDTO update(Integer id, TurmaDTO turmaDTO) {
        findById(id);
        var professorOptional = professorRepository.findById(turmaDTO.getProfessor());
        var professor = professorOptional.orElseThrow(()
                -> new ObjectNotFoundException("Professor não encontrado id: " + turmaDTO.getProfessor()));
        var turmaAtualizado = turmaRepository.save(new Turma(id, turmaDTO, professor));
        return new TurmaDTO(turmaAtualizado);
    }
}
