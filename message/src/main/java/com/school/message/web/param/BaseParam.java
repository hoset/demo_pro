package com.school.message.web.param;

public class BaseParam {
    private int current;
    private int size;

    public BaseParam() {
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BaseParam{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
