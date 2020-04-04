package com.school.message.web.pojo;

public class MessageCount {

    private Long id; // id
    private  String content; // 内容
    private Integer type; // 类型
    private Integer state; //状态
    private Integer total; // 总数
    private String from;
    private String to;


    public MessageCount() {
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "MessageCount{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", state=" + state +
                ", total=" + total +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
