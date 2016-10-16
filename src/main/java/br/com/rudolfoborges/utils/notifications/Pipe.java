package br.com.rudolfoborges.utils.notifications;

import java.util.List;

public interface Pipe {

    void send(List<Message> messages);

}
