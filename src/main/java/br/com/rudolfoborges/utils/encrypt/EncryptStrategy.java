package br.com.rudolfoborges.utils.encrypt;

public interface EncryptStrategy {

    String encode(String value);
    String decode(String value) throws NoSuchMethodException;

}
