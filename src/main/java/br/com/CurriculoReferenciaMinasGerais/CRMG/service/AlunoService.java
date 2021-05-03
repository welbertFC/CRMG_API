package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Aluno;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.AlunoDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.AlunoRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.TurmaRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public Aluno findById(Integer id) {
        var aluno = alunoRepository.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado id: " + id));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno insert(AlunoDTO alunoDTO) {
        var turmaOptional = turmaRepository.findById(alunoDTO.getTurma());
       var turma = turmaOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto turma não encontrado id :" + alunoDTO.getTurma()));
        return alunoRepository.save(new Aluno(alunoDTO, turma));
    }

    public Aluno update(Integer id, Aluno aluno) {
        findById(id);
        return alunoRepository.save(new Aluno(id, aluno));
    }
}
