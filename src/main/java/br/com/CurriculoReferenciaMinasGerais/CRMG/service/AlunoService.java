package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Aluno;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.AlunoRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno findById(Integer id) {
        var aluno = alunoRepository.findById(id);
        return aluno.orElseThrow(() -> new ObjectNotFoundException("Aluno não encontrado id: " + id));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno insert(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno update(Integer id, Aluno aluno) {
        findById(id);
        return alunoRepository.save(new Aluno(id, aluno));
    }
}
