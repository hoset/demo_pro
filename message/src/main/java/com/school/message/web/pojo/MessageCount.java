package com.school.message.web.pojo;

public class MessageCount {
    private Integer total; // 总数
    private Integer type; // 类型
    private Integer countRead; // 已读
    private Integer countUnRead; // 未读

    public MessageCount() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCountRead() {
        return countRead;
    }

    public void setCountRead(Integer countRead) {
        this.countRead = countRead;
    }

    public Integer getCountUnRead() {
        return countUnRead;
    }

    public void setCountUnRead(Integer countUnRead) {
        this.countUnRead = countUnRead;
    }

    @Override
    public String toString() {
        return "MessageCount{" +
                "total=" + total +
                ", type=" + type +
                ", countRead=" + countRead +
                ", countUnRead=" + countUnRead +
                '}';
    }
}
