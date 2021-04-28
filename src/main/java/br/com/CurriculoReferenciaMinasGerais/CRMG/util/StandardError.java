package br.com.CurriculoReferenciaMinasGerais.CRMG.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class StandardError implements Serializable {

    private Integer status;
    private String message;
    private String erro;
    private long timestamp;
    private String path;

    public StandardError(Integer status, String message, String erro, long timestamp, String path) {
        this.status = status;
        this.message = message;
        this.erro = erro;
        this.timestamp = timestamp;
        this.path = path;
    }
}
