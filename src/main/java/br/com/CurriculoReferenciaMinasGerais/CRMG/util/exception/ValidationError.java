package br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Integer status, String msg, String erro, Long timeStamp, String path){ super(status, msg, erro, timeStamp,path );}

    public List<FieldMessage> getErros(){return  erros;}

    public void addError(String fieldName, String messagem){erros.add(new FieldMessage(fieldName, messagem));}
}
