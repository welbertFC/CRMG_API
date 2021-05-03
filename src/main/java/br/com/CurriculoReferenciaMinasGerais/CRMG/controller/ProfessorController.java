package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.Professor;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.ListaProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.models.dto.NovoProfessorDTO;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ListaProfessorDTO>> findAll() {
        List<ListaProfessorDTO> professors = professorService.findAll();
        return ResponseEntity.ok().body(professors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaProfessorDTO> findById(@PathVariable Integer id) {
        var professor = professorService.findById(id);
        return ResponseEntity.ok().body(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> insert(@Valid @RequestBody NovoProfessorDTO professor) {
        Professor newProfessor = professorService.insert(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProfessor.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> update(@PathVariable Integer id, @RequestBody Professor professor) {
        Professor updateProfessor = professorService.update(id, professor);
        return ResponseEntity.ok().body(updateProfessor);
    }

}
