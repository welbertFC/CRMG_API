package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.TurmaRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma findById(Integer id) {
        var turma = turmaRepository.findById(id);
        return turma.orElseThrow(() -> new ObjectNotFoundException("Turma não encontrada id: " + id));
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma insert(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Integer id, Turma turma) {
        return turmaRepository.save(new Turma(id, turma));
    }
}
