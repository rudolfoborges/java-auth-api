package br.com.rudolfoborges.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.rudolfoborges.utils.MessagesProperties;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UnauthorizeException extends RuntimeException {

    public UnauthorizeException(MessagesProperties messagesProperties){
        super(messagesProperties.getForbidden());
    }
}
