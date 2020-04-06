package com.school.message.message;

import com.school.message.message.message.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageHandler {
    private ISendMessage[] sendMessage;

    public void init(ISendMessage... sendMessage) {
        if (sendMessage == null) {
            this.sendMessage = new ISendMessage[0];
        } else {
            this.sendMessage = sendMessage;
        }
    }

    public void send(Message msg) {
        for (int i = 0, j = sendMessage.length; i < j; i++) {
            sendMessage[i].send(msg);
        }
    }


}
