package br.com.rudolfoborges.utils.serializers;


import java.util.HashMap;
import java.util.List;

public class MessagesResponse extends HashMap<String, Object> {

    private final List<String> messages;

    public MessagesResponse(List<String> messages){
        this.messages = messages;
        this.put("messages", this.messages);
    }

    public void add(String message) {
        messages.add(message);
    }

}
