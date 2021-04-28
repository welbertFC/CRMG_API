package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        var turma = turmaService.findAll();
        return ResponseEntity.ok().body(turma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        var turma = turmaService.findById(id);
        return ResponseEntity.ok().body(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> insert(@RequestBody Turma turma) {
        var newTurma = turmaService.insert(turma);
        return ResponseEntity.ok().body(newTurma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> update(@PathVariable Integer id, @RequestBody Turma turma) {
        var updateTurma = turmaService.update(id, turma);
        return ResponseEntity.ok().body(updateTurma);
    }
}
