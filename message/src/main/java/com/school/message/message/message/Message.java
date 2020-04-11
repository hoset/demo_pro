package com.school.message.message.message;

import java.util.Arrays;

public class Message {
    private String from;
    private String[] to;
    private String subject;
    private String content;


    public Message() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", to=" + Arrays.toString(to) +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
