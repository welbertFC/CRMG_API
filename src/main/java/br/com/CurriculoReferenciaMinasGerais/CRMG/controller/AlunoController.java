package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Aluno;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        var alunos = alunoService.findAll();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        var aluno = alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno) {
        var newAluno = alunoService.insert(aluno);
        return ResponseEntity.ok().body(newAluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Integer id, @RequestBody Aluno aluno) {
        var updateAluno = alunoService.update(id, aluno);
        return ResponseEntity.ok().body(updateAluno);
    }

}