package com.school.message.message.emun;

public enum SendType {
    TIMING(-1),
    PROMPTLY(0),
    LOOP(1),
    ;
    private int type;

    SendType(int type) {
        this.type = type;
    }
}
