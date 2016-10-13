package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.rudolfoborges.utils.MessagesProperties;

public class UnauthorizeException extends ApplicationException {

    public UnauthorizeException(MessagesProperties messagesProperties){
        super(messagesProperties.getForbidden(), HttpStatus.FORBIDDEN);
    }
}
