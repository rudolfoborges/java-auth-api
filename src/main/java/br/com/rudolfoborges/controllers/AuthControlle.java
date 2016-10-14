package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.Login;
import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.encrypt.BCryptStrategy;
import br.com.rudolfoborges.utils.exceptions.EmailOrPasswordInvalidException;
import br.com.rudolfoborges.utils.exceptions.InvalidSessionException;
import br.com.rudolfoborges.utils.exceptions.UnauthorizeException;
import br.com.rudolfoborges.utils.jwt.JWTBuilder;
import br.com.rudolfoborges.utils.serializers.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Transactional
@RequestMapping("api/v1/auth")
public class AuthControlle {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final SecretRepository secretRepository;

    @Autowired
    public AuthControlle(UserRepository userRepository,
                         SessionRepository sessionRepository,
                         SecretRepository secretRepository){

        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.secretRepository = secretRepository;
    }

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public SuccessResponse login(@RequestBody @Valid Login login){
        User user = userRepository.findOneByEmail(login.getEmail());

        if(!login.verify(new BCryptStrategy(), user)){
            throw new EmailOrPasswordInvalidException();
        }

        Secret secret = secretRepository.findFirstByEnabled(true);

        Date loginDate = new Date();
        String token = new JWTBuilder(secret.getValue()).build(user, loginDate);
        Session session = new Session(user, loginDate, token);
        sessionRepository.save(session);

        return new SuccessResponse(user, session);
    }

    @RequestMapping(path = "perfil/{id}", method = RequestMethod.GET)
    public SuccessResponse perfil(@PathVariable("id") Long id, @RequestHeader("Authorization") String token){
        User user = userRepository.findOne(id);

        if(token == null || user == null){
            throw new UnauthorizeException();
        }

        Session session = sessionRepository.findOneByToken(token);

        if(session == null || !session.verify(user, token)){
            throw new UnauthorizeException();
        }

        if(!session.isValid()){
            throw new InvalidSessionException();
        }

        return new SuccessResponse(user, session);
    }

}
