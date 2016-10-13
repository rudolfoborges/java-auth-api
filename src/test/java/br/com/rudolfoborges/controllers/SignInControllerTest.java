package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.SessionRepository;
import br.com.rudolfoborges.repositories.UserRepository;
import br.com.rudolfoborges.utils.exceptions.BusinessException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SignInControllerTest {

    private UserRepository userRepository;
    private SessionRepository sessionRepository;
    private SignInController signInController;
    private User user;

    @Before
    public void before(){
        userRepository = mock(UserRepository.class);
        sessionRepository = mock(SessionRepository.class);
        signInController = new SignInController(userRepository, sessionRepository);
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
