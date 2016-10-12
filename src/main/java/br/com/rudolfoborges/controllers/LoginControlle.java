package br.com.rudolfoborges.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/v1/auth")
public class LoginControlle {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Map<String, String> body){
        return null;
    }

}
