package com.school.message.web.pojo;

import java.util.Date;
import java.util.List;

public class SendMessage {


    private Long from;
    private List<Long> to;
    private String content;// 内容
    private Integer type; // 类型

    private Long timeStamp = new Date().getTime(); // 时间戳


    public SendMessage() {
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public List<Long> getTo() {
        return to;
    }

    public void setTo(List<Long> to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "SendMessage{" +
                "from=" + from +
                ", to=" + to +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
