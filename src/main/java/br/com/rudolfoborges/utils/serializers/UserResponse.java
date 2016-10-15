package br.com.rudolfoborges.utils.serializers;

import br.com.rudolfoborges.models.User;

import java.util.HashMap;

public class UserResponse extends HashMap<String, Object> {

    public UserResponse(User user){
        this.put("id", user.getId());
        this.put("name", user.getName());
        this.put("email", user.getEmail());
        this.put("created", user.getCreated());
    }

}
