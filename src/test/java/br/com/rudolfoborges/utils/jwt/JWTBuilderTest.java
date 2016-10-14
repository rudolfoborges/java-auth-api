package br.com.rudolfoborges.utils.jwt;

import br.com.rudolfoborges.models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class JWTBuilderTest {

    @Test
    public void buildTest(){
        JWTBuilder jwtBuilder = new JWTBuilder("ff298e4c4f975caa25114d524167027dd47275f4bf7e414fce87b993ad12d058");
        User user = mock(User.class);
        Date date = new Date();

        String token = jwtBuilder.build(user, date);
        Assert.assertNotNull(token);
    }

}
