package br.com.rudolfoborges.utils.exceptions;

import br.com.rudolfoborges.utils.MessagesProperties;
import org.springframework.http.HttpStatus;

public class UnauthorizeException extends ApplicationException {

    public UnauthorizeException(MessagesProperties messagesProperties){
        super(messagesProperties.getForbidden(), HttpStatus.FORBIDDEN);
    }
}
