package com.school.message.message.emun;

public enum MessageType {
    EMAIL(1),
    WEI_XIN(2),
    SHORT_MESSAGE(3),
    ALL(4)
    ;
    private int type;

    MessageType(int type) {
        this.type = type;
    }

    public int value(){
        return type;
    }
}
