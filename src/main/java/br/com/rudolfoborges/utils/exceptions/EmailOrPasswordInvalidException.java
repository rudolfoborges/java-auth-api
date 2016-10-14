package br.com.rudolfoborges.utils.exceptions;

import br.com.rudolfoborges.utils.MessagesProperties;
import org.springframework.http.HttpStatus;

public class EmailOrPasswordInvalidException extends ApplicationException {

    public EmailOrPasswordInvalidException(MessagesProperties messagesProperties){
        super(messagesProperties.getUnauthorize(), HttpStatus.UNAUTHORIZED);
    }
}
