package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Turma;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.TurmaDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> findAll() {
        var turma = turmaService.findAll();
        return ResponseEntity.ok().body(turma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> findById(@PathVariable Integer id) {
        var turma = turmaService.findById(id);
        return ResponseEntity.ok().body(turma);
    }

    @PostMapping
    public ResponseEntity<Turma> insert(@Valid @RequestBody TurmaDTO turma) {
        var newTurma = turmaService.insert(turma);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newTurma.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> update(@Valid @RequestBody TurmaDTO turma, @PathVariable Integer id) {
        var updateTurma = turmaService.update(id, turma);
        return ResponseEntity.ok().body(updateTurma);
    }
}
