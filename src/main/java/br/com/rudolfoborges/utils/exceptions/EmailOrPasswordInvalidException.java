package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rudolfoborges.utils.MessagesProperties;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class EmailOrPasswordInvalidException extends RuntimeException {

    public EmailOrPasswordInvalidException(MessagesProperties messagesProperties){
        super(messagesProperties.getUnauthorize());
    }
}
