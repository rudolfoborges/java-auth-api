package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public class EmailOrPasswordInvalidException extends ApplicationException {

    public EmailOrPasswordInvalidException(){
        super(HttpStatus.UNAUTHORIZED);
    }
}
