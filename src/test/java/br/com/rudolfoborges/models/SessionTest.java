package br.com.rudolfoborges.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class SessionTest {

    private User user1 = null;
    private User user2 = null;
    private Date loginDate = null;
    private String token = null;

    @Before
    public void before(){
        user1 = new User();
        user2 = new User();

        user1.setId(1L);
        user2.setId(2L);


        loginDate = new Date();
        token = "7110eda4d09e062aa5e4a390b0a572ac0d2c0220";

    }

    @Test
    public void verifyOkTest(){
        Session session = new Session(user1, loginDate, token);
        Assert.assertTrue(session.verify(user1, token));
    }

    @Test
    public void verifyErrorTest(){
        Session session = new Session(user1, loginDate, token);
        Assert.assertFalse(session.verify(user2, token));
        Assert.assertFalse(session.verify(user1, "1234"));
        Assert.assertFalse(session.verify(user2, "1234"));
    }

    @Test
    public void isValidTest(){
        Session session = new Session(user1, loginDate, token);
        Assert.assertTrue(session.isValid());
    }

}
