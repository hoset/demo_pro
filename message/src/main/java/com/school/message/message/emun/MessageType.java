package com.school.message.message.emun;

public enum MessageType {
    EMAIL(1),
    WEI_XIN(2),
    SHORT_MESSAGE(3),
    ALL(4),
    WEB_PAGE(5)
    ;
    private Integer type;

    MessageType(Integer type) {
        this.type = type;
    }

    public Integer value(){
        return type;
    }
}
