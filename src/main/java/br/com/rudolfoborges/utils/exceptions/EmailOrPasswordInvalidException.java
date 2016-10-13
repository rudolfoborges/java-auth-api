package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;

import br.com.rudolfoborges.utils.MessagesProperties;

public class EmailOrPasswordInvalidException extends ApplicationException {

    public EmailOrPasswordInvalidException(MessagesProperties messagesProperties){
        super(messagesProperties.getUnauthorize(), HttpStatus.UNAUTHORIZED);
    }
}
