package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidSessionException extends ApplicationException {

    public InvalidSessionException() {
        super(HttpStatus.valueOf(419));
    }
}
