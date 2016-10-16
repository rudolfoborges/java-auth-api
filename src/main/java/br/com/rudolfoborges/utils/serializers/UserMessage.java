package br.com.rudolfoborges.utils.serializers;

import br.com.rudolfoborges.models.User;
import br.com.rudolfoborges.utils.notifications.Message;

public class UserMessage extends UserResponse implements Message {

    public UserMessage(User user) {
        super(user);
    }
}
