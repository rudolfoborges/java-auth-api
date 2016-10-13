package br.com.rudolfoborges.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.exceptions.ApplicationException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
	
	@Autowired
	private MessagesProperties messagesProperties;
	
    @ExceptionHandler(value = {ApplicationException.class})
    @ResponseBody
    public ResponseEntity<Map<String, Object>> handleInternalExceptions(ApplicationException e) {
    	LOGGER.error(e.getMessage(), e);
    	Map<String, Object> body = buildResponseMap(Arrays.asList(e.getMessage()));
        return new ResponseEntity<Map<String, Object>>(body, e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleConstraintViolations(MethodArgumentNotValidException e){
        final List<String> messages = new ArrayList<String>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((DefaultMessageSourceResolvable) error.getArguments()[0]).getCode();
            String message = error.getDefaultMessage();
            messages.add(String.format("%s - %s", field, message));
        });
        LOGGER.error(e.getMessage(), e);
        return buildResponseMap(messages);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleAllExceptions(Exception e){
    	LOGGER.error(e.getMessage(), e);
        return buildResponseMap(Arrays.asList(messagesProperties.getInternalError()));
    }

    private Map<String, Object> buildResponseMap(List<String> messages){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("messages", messages);
        return response;
    }

}
