package br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException (String msg){
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
    }
