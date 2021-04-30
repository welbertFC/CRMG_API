package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.NovoProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        List<Professor> professors = professorService.findAll();
        return ResponseEntity.ok().body(professors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        Professor professor = professorService.findById(id);
        return ResponseEntity.ok().body(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> insert(@RequestBody NovoProfessorDTO professor) {
        Professor newProfessor = professorService.insert(professor);
        return ResponseEntity.ok().body(newProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Integer id, @RequestBody Professor professor) {
        Professor updateProfessor = professorService.update(id, professor);
        return ResponseEntity.ok().body(updateProfessor);
    }

}
