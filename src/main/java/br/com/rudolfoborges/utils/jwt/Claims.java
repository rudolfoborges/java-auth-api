package br.com.rudolfoborges.utils.jwt;

import java.util.Map;

public class Claims {

    private final Map<String, Object> claims;

    public Claims(Map<String, Object> claims){
        this.claims = claims;
    }

    public Long getId(){
        return Long.valueOf(claims.get("id").toString());
    }

}
