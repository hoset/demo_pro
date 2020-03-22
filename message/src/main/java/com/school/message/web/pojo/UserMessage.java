package com.school.message.web.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class UserMessage {

    private Long id; // id
    private String content;// 内容
    private Integer type; // 类型

    private Long timeStamp = new Date().getTime(); // 时间戳


    public UserMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "UserMessage{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
