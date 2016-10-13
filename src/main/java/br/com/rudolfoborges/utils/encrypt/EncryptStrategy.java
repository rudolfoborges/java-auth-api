package br.com.rudolfoborges.utils.encrypt;

public interface EncryptStrategy {

    String encode(String value, String salt);
    String decode(String value, String salt) throws NoSuchMethodException;

}
