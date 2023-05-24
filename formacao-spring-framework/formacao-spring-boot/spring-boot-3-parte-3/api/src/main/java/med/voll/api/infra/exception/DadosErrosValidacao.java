package med.voll.api.infra.exception;

import org.springframework.validation.FieldError;

public record DadosErrosValidacao(String campo, String mensagem) {

    public DadosErrosValidacao(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }

}
