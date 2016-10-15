package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.encrypt.BCryptStrategy;
import br.com.rudolfoborges.utils.exceptions.BusinessException;
import br.com.rudolfoborges.utils.jwt.JWTBuilder;
import br.com.rudolfoborges.utils.serializers.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@Transactional
@RequestMapping("api/v1/signup")
public class SignUpController {

    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    private final SecretRepository secretRepository;
	private final MessagesProperties messagesProperties;
	

    @Autowired
    public SignUpController(UserRepository userRepository,
                            SessionRepository sessionRepository,
                            SecretRepository secretRepository,
                            MessagesProperties messagesProperties){

        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.secretRepository = secretRepository;
		this.messagesProperties = messagesProperties;
    }

    @RequestMapping(method = RequestMethod.POST)
    public SuccessResponse signIn(@RequestBody @Valid User user){
        if(userRepository.countByEmail(user.getEmail()) > 0){
            throw new BusinessException(messagesProperties.getUserExists());
        }

        user.definedCreateDate();
        user.encodedPassword(new BCryptStrategy());
        userRepository.save(user);

        Secret secret = secretRepository.findFirstByEnabled(true);

        Date loginDate = new Date();
        String token = new JWTBuilder(secret.getValue()).build(user, loginDate);
        Session session = new Session(user, loginDate, token);
        sessionRepository.save(session);

        return new SuccessResponse(user, session);
    }

}
