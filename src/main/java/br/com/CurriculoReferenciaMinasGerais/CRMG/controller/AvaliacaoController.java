package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Avaliacao;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll(){
        var avaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok().body(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable  Integer id){
        var avaliacao = avaliacaoService.findById(id);
        return ResponseEntity.ok().body(avaliacao);
    }

    @PostMapping
    public ResponseEntity<Avaliacao> insert(@RequestBody Avaliacao avaliacao){
        var newAvaliacao = avaliacaoService.insert(avaliacao);
        return ResponseEntity.ok().body(newAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @RequestBody Avaliacao avaliacao){
        var updateAvaliacao = avaliacaoService.update(id, avaliacao);
        return ResponseEntity.ok().body(updateAvaliacao);
    }
}
