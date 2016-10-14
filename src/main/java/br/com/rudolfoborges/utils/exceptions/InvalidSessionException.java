package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

public class SessionInvalidException  extends ApplicationException {

    public SessionInvalidException(HttpStatus httpStatus) {
        super(HttpStatus.valueOf(419));
    }
}
