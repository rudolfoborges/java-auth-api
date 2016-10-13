package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.utils.exceptions.BusinessException;
import br.com.rudolfoborges.utils.exceptions.UnauthorizeException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(value = {BusinessException.class, UnauthorizeException.class})
    @ResponseBody
    public Map<String, Object> handleInternalExceptions(BusinessException e) {
        return buildResponseMap(Arrays.asList(e.getMessage()));
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
        return buildResponseMap(messages);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Map<String, Object> handleAllExceptions(){
        return buildResponseMap(Arrays.asList("Ocorreu um erro inesperado. Favor tente mais tarde."));
    }

    private Map<String, Object> buildResponseMap(List<String> messages){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("messages", messages);
        return response;
    }

}
