package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizeException extends ApplicationException {

    public UnauthorizeException(){
        super(HttpStatus.FORBIDDEN);
    }
}
