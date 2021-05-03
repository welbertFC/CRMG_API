package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Avaliacao;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.AvaliacaoRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Avaliacao findById(Integer id){
        var avaliacao = avaliacaoRepository.findById(id);
        return avaliacao.orElseThrow(() -> new ObjectNotFoundException("Avaliação não encontrada id: " + id));
    }

    public List<Avaliacao> findAll(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao insert(Avaliacao avaliacao){
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao update(Integer id, Avaliacao avaliacao){
        return avaliacaoRepository.save(new Avaliacao(id, avaliacao));
    }
}
