package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/signin")
public class SignInController {

    private final UserRepository userRepository;

    @Autowired
    public SignInController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> signIn(@RequestBody @Valid User user){
        if(userRepository.findCountByEmail(user.getEmail()) > 0){
            throw new BusinessException("E-mail já existente");
        }
        userRepository.save(user);
        return new ResponseEntity<Map<String, Object>>(new HashMap<String, Object>(), HttpStatus.OK);
    }

}
