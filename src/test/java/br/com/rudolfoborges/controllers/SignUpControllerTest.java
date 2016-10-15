package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.exceptions.BusinessException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SignUpControllerTest {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private SecretRepository secretRepository;
    private MessagesProperties messagesProperties;

    private SignUpController signUpController;

    @Before
    public void before(){
        userRepository = mock(UserRepository.class);
        sessionRepository = mock(SessionRepository.class);
        secretRepository = mock(SecretRepository.class);
        messagesProperties = mock(MessagesProperties.class);
        
        Secret secret = new Secret("secret");
        when(secretRepository.findFirstByEnabled(true)).thenReturn(secret);

        signUpController = new SignUpController(userRepository, sessionRepository, secretRepository, messagesProperties);
    }

    @Test
    public void signinTest(){
    	User user = new User();
        signUpController.signIn(user);
    }

    @Test(expected = BusinessException.class)
    public void signinUniqueEmailTest(){
    	User user = new User();
        when(userRepository.countByEmail(anyString())).thenReturn(1L);
        signUpController.signIn(user);
    }

}
