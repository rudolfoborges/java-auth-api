package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.Login;
import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.encrypt.BCryptStrategy;
import br.com.rudolfoborges.utils.exceptions.EmailOrPasswordInvalidException;
import br.com.rudolfoborges.utils.serializers.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("api/v1/login")
public class LoginControlle {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final SecretRepository secretRepository;
	private final MessagesProperties messagesProperties;

    @Autowired
    public LoginControlle(UserRepository userRepository, 
    		SessionRepository sessionRepository, 
    		SecretRepository secretRepository,
    		MessagesProperties messagesProperties){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.secretRepository = secretRepository;
		this.messagesProperties = messagesProperties;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody @Valid Login login){
        User user = userRepository.findOneByEmail(login.getEmail());

        if(!login.verify(new BCryptStrategy(), user)){
            throw new EmailOrPasswordInvalidException(messagesProperties);
        }

        Secret secret = secretRepository.findFirstByEnabled(true);

        Session session = new Session(user);
        session.createJWTToken(secret.getValue());
        sessionRepository.save(session);

        return ResponseBuilder.login(user, session);
    }

}
