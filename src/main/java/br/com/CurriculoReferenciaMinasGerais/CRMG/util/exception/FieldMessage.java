package br.com.CurriculoReferenciaMinasGerais.CRMG.util.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class FieldMessage implements Serializable {

    private String fieldMessage;
    private String message;

    public FieldMessage(String fieldMessage, String message) {
        this.fieldMessage = fieldMessage;
        this.message = message;
    }
}
