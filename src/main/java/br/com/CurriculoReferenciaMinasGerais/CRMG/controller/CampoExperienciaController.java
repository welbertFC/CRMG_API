package br.com.CurriculoReferenciaMinasGerais.CRMG.controller;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.CampoExperiencia;
import br.com.CurriculoReferenciaMinasGerais.CRMG.service.CampoExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/campoExperiencia")
public class CampoExperienciaController {

    @Autowired
    private CampoExperienciaService campoExperienciaService;


    @GetMapping
    public ResponseEntity<List<CampoExperiencia>> findAll(){
        var campoExperiencias = campoExperienciaService.findAll();
        return ResponseEntity.ok().body(campoExperiencias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampoExperiencia> findById(@PathVariable Integer id){
        var campoExperiencia = campoExperienciaService.findById(id);
        return ResponseEntity.ok().body(campoExperiencia);
    }
}
