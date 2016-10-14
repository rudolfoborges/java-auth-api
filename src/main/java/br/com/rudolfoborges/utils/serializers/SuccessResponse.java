package br.com.rudolfoborges.utils.serializers;

import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;

import java.util.HashMap;

public class SuccessResponse extends HashMap<String, Object> {

    public SuccessResponse(User user, Session session){
        this.put("id", user.getId());
        this.put("created", user.getCreated());
        this.put("modified", user.getModified());
        this.put("last_login", session.getLastLogin());
        this.put("token", session.getToken());
    }

}
