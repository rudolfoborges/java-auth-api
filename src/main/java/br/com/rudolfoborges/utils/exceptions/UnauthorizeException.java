package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnauthorizeException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Usuário e/ou senha inválidos";

    public UnauthorizeException(){
        super(ERROR_MESSAGE);
    }
}
