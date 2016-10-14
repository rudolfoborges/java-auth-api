package br.com.rudolfoborges.utils.jwt;

import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;
import com.auth0.jwt.JWTSigner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTBuilder {

    private final String secret;

    public JWTBuilder(String secret){
        this.secret = secret;
    }

    public String build(User user, Date loginDate){
        JWTSigner jwtSigner = new JWTSigner(secret);
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("id", user.getId());
        claims.put("email", user.getEmail());
        claims.put("last_login", loginDate);
        return jwtSigner.sign(claims);
    }

}
