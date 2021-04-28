package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Escola;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping
    public ResponseEntity<Escola> insert(@RequestBody Escola escola) {
        var newEscola = escolaService.insert(escola);
        return ResponseEntity.ok().body(newEscola);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> findById(@PathVariable Integer id) {
        var escola = escolaService.findById(id);
        return ResponseEntity.ok().body(escola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> update(@PathVariable Integer id, @RequestBody Escola escola) {
        var updateEscola = escolaService.update(id, escola);
        return ResponseEntity.ok().body(updateEscola);
    }

    @GetMapping
    public ResponseEntity<List<Escola>> findAll() {
        var escolas = escolaService.findAll();
        return ResponseEntity.ok().body(escolas);
    }
}
