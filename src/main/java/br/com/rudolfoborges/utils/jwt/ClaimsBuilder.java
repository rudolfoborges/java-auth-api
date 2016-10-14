package br.com.rudolfoborges.utils.jwt;

import java.util.Map;

public class ClaimsBuilder {

    private final String secret;

    public ClaimsBuilder(String secret){
        this.secret = secret;
    }

    public Map<String, Object> build(String token){
        return null;
    }
}
