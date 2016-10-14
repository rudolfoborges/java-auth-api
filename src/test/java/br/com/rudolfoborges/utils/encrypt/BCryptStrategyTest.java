package br.com.rudolfoborges.utils.encrypt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BCryptStrategyTest {

    @Test
    public void encodeTest(){
        EncryptStrategy encryptStrategy = new BCryptStrategy();
        Assert.assertNotNull(encryptStrategy.encode("1234", Salt.get()));
    }

    @Test(expected = NoSuchMethodException.class)
    public void decodeTest() throws NoSuchMethodException {
        EncryptStrategy encryptStrategy = new BCryptStrategy();
        encryptStrategy.decode("1234", Salt.get());
    }

}
