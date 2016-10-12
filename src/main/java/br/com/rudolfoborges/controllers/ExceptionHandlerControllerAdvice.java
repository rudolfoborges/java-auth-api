package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.utils.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(value = { BusinessException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, Object> handleConstraintViolations(BusinessException e) {
        String message = e.getMessage();
        return buildResponseMap(message);
    }

    private Map<String, Object> buildResponseMap(String message){
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("message", message);
        return response;
    }

}
