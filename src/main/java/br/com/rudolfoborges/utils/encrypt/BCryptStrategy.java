package br.com.rudolfoborges.utils.encrypt;

public class BCryptStrategy implements EncryptStrategy {

    public String encode(String value, String salt) {
        return BCrypt.hashpw(value, salt);
    }

    public String decode(String value, String salt) throws NoSuchMethodException {
        throw new NoSuchMethodException();
    }
}
