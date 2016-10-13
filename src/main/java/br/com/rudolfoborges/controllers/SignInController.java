package br.com.rudolfoborges.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.encrypt.BCryptStrategy;
import br.com.rudolfoborges.utils.exceptions.BusinessException;
import br.com.rudolfoborges.utils.serializers.ResponseBuilder;

@RestController
@Transactional
@RequestMapping("api/v1/signin")
public class SignInController {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final SecretRepository secretRepository;
	private final MessagesProperties messagesProperties;
	

    @Autowired
    public SignInController(UserRepository userRepository, 
    		SessionRepository sessionRepository, 
    		SecretRepository secretRepository,
    		MessagesProperties messagesProperties){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.secretRepository = secretRepository;
		this.messagesProperties = messagesProperties;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> signIn(@RequestBody @Valid User user){
        if(userRepository.countByEmail(user.getEmail()) > 0){
            throw new BusinessException(messagesProperties.getUserExists());
        }

        user.defineCreatedDate();
        user.encodePassword(new BCryptStrategy());
        userRepository.save(user);

        Secret secret = secretRepository.findFirstByEnabled(true);
        
        Session session = new Session(user);
        session.createJWTToken(secret.getValue());
        sessionRepository.save(session);

        return ResponseBuilder.signin(user, session);
    }

}
