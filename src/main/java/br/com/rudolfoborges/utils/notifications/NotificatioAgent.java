package br.com.rudolfoborges.utils.notifications;

import java.util.ArrayList;
import java.util.List;

public class NotificatioAgent {

    private final List<Message> messages;
    private final List<Pipe> pipes;

    public NotificatioAgent(){
        messages = new ArrayList<Message>();
        pipes = new ArrayList<Pipe>();
    }

    public NotificatioAgent message(Message message){
        messages.add(message);
        return this;
    }

    public NotificatioAgent pipe(Pipe pipe){
        pipes.add(pipe);
        return this;
    }

    public void send(){
        pipes.forEach(pipe -> pipe.send(messages));
    }

}
