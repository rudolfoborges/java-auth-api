package br.com.rudolfoborges.utils.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TopicUsersWSPipe implements Pipe{

    private final SimpMessagingTemplate template;

    @Autowired
    public TopicUsersWSPipe(SimpMessagingTemplate template){
        this.template = template;
    }

    public void send(List<Message> messages) {
        messages.forEach(message -> template.convertAndSend("/topic/users", message));
    }
}
