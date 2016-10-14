package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.exceptions.*;
import br.com.rudolfoborges.utils.serializers.MessagesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Arrays;

@RestControllerAdvice
public class ExceptionsControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsControllerAdvice.class);
	
	@Autowired
	private MessagesProperties messagesProperties;
	
    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseBody
    public ResponseEntity<MessagesResponse> onApplicationException(ApplicationException e) {
        logError(e);
        MessagesResponse body = null;

        if(e instanceof BusinessException) {
            body = new MessagesResponse(Arrays.asList(e.getMessage()));
        } else if(e instanceof EmailOrPasswordInvalidException) {
            body = new MessagesResponse(Arrays.asList(messagesProperties.getUnauthorize()));
        } else if(e instanceof UnauthorizeException) {
            body = new MessagesResponse(Arrays.asList(messagesProperties.getForbidden()));
        } else if(e instanceof InvalidSessionException) {
            body = new MessagesResponse(Arrays.asList(messagesProperties.getInvalidSession()));
        }

        return new ResponseEntity<MessagesResponse>(body, e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public MessagesResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e){
        logError(e);
        MessagesResponse messagesResponse = new MessagesResponse(new ArrayList<String>());

        e.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((DefaultMessageSourceResolvable) error.getArguments()[0]).getCode();
            String message = error.getDefaultMessage();
            messagesResponse.add(String.format("%s - %s", field, message));
        });

        return messagesResponse;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public MessagesResponse onException(Exception e){
        logError(e);
        return new MessagesResponse(Arrays.asList(messagesProperties.getInternalError()));
    }

    private void logError(Exception e){
        LOGGER.error(e.getMessage(), e);
    }

}
