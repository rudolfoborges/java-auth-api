package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends ApplicationException {

    public BusinessException(String message){
        super(message, HttpStatus.BAD_REQUEST);
    }
}
