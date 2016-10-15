package br.com.rudolfoborges.controllers;

import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Test
    public void getAllTest(){
        UserRepository userRepository = mock(UserRepository.class);
        List<User> users = Arrays.asList(mock(User.class), mock(User.class));
        when(userRepository.findAllByOrderByName()).thenReturn(users);

        UserController userController = new UserController(userRepository);

        Assert.assertNotNull(userController.getAll());
        Assert.assertTrue(userController.getAll().size() == 2);
    }



}
