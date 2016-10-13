package br.com.rudolfoborges.utils.serializers;

import br.com.rudolfoborges.models.Session;
import br.com.rudolfoborges.models.User;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static Map<String, Object> signin(User user, Session session){
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", user.getId());
        model.put("created", user.getCreated());
        model.put("modified", user.getModified());
        model.put("last_login", null);
        model.put("token", null);
        return model;
    }

    public static Map<String, Object> login(User user, Session session){
        return signin(user, session);
    }

}
