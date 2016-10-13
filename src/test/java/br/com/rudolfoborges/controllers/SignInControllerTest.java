package br.com.rudolfoborges.controllers;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.rudolfoborges.models.Secret;
import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SecretRepository;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.MessagesProperties;
import br.com.rudolfoborges.utils.exceptions.BusinessException;

@RunWith(MockitoJUnitRunner.class)
public class SignInControllerTest {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private SecretRepository secretRepository;
    private MessagesProperties messagesProperties;

    private SignInController signInController;
    private User user;

    @Before
    public void before(){
        userRepository = mock(UserRepository.class);
        sessionRepository = mock(SessionRepository.class);
        secretRepository = mock(SecretRepository.class);
        messagesProperties = mock(MessagesProperties.class);
        
        Secret secret = mock(Secret.class);
        when(secret.getValue()).thenReturn("secret");
        when(secretRepository.findFirstByEnabled(true)).thenReturn(secret);

        signInController = new SignInController(userRepository, sessionRepository, secretRepository, messagesProperties);
        user = mock(User.class);
    }

    @Test
    public void signinTest(){
        signInController.signIn(user);
    }

    @Test(expected = BusinessException.class)
    public void signinUniqueEmailTest(){
        when(userRepository.countByEmail(anyString())).thenReturn(1L);
        signInController.signIn(user);
    }

}
