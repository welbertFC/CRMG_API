package br.com.CurriculoReferenciaMinasGerais.CRMG.service;

import br.com.CurriculoReferenciaMinasGerais.CRMG.models.CampoExperiencia;
import br.com.CurriculoReferenciaMinasGerais.CRMG.repository.CampoExperienciaRepository;
import br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoExperienciaService {

    @Autowired
    private CampoExperienciaRepository campoExperienciaRepository;

    public CampoExperiencia findById(Integer id){
        var campoExperiencia = campoExperienciaRepository.findById(id);
        return campoExperiencia.orElseThrow(() -> new ObjectNotFoundException("Campo de Experiencia não encontrado id: " + id));
    }

    public List<CampoExperiencia> findAll(){
        return campoExperienciaRepository.findAll();
    }

}
