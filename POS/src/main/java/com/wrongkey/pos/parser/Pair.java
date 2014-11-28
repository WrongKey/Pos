package com.wrongkey.pos.parser;

/**
 * @author wrongkey
 * @version v1.0
 * @description 类似于C++的Pair
 * @date 2014/11/28
 */
public class Pair {
    private String key;
    private int value;

    public Pair(String key) {
        this.key = key;
        value = 1;
    }

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "barcode: " + getKey() + "  value: " + getValue();
    }
}
