package com.school.message.message.emun;

public enum MessageState {
    READ(1),
    UNREAD(-1),
    UNSENT(0);
    private int state;

    MessageState(int state) {
        this.state = state;
    }

    public int value() {
        return state;
    }
}
