package br.com.rudolfoborges.utils.jwt;

import br.com.rudolfoborges.utils.exceptions.UnauthorizeException;
import com.auth0.jwt.JWTVerifier;

import java.util.Map;

public class ClaimsBuilder {

    private final String secret;

    public ClaimsBuilder(String secret){
        this.secret = secret;
    }

    public Claims build(String token){
        try {
            JWTVerifier jwtVerifier = new JWTVerifier(secret);
            return new Claims(jwtVerifier.verify(token));
        } catch (Exception e){
            throw new UnauthorizeException();
        }
    }
}
