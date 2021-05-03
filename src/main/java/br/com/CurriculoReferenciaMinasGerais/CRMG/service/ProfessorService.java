package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.ProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.ProfessorRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private EscolaService escolaService;

    public ProfessorDTO findById(Integer id) {
        var professor = professorRepository.findById(id);
        professor.orElseThrow(() -> new ObjectNotFoundException("Professor não encontrado id: " + id));
        var professorDTO = new ProfessorDTO(professor);
        return professorDTO;
    }

    public List<ProfessorDTO> findAll() {
        var professores = professorRepository.findAll();
        var listProfessorDTO = professores.stream().map(s ->
                new ProfessorDTO(s)).collect(Collectors.toList());
        return listProfessorDTO;

    }

    public Professor insert(ProfessorDTO professor) {
        var escola = escolaService.findById(professor.getIdEscola());
        return professorRepository.save(new Professor(professor, escola));
    }

    public ProfessorDTO update(Integer id, ProfessorDTO professorDTO) {
        findById(id);
        var escola = escolaService.findById(professorDTO.getIdEscola());
        var professorAtualizado =  professorRepository.save(new Professor(id, professorDTO, escola));
        return new ProfessorDTO(professorAtualizado);
    }
}
