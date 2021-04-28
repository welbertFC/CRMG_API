package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Escola;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.EscolaRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola insert(Escola escola) {
        return escolaRepository.save(escola);
    }

    public Escola findById(Integer id) {
        var escola = escolaRepository.findById(id);
        return escola.orElseThrow(() -> new ObjectNotFoundException("Escola não encontrada id: " + id));
    }

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public Escola update(Integer id, Escola escola) {
        findById(id);
        return escolaRepository.save(new Escola(id, escola));
    }
}
