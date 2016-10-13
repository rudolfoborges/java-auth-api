package br.com.rudolfoborges.utils.encrypt;

public class Salt {

    public static String get() {
        return BCrypt.gensalt(10);
    }
}
