package com.xhlim.jdk18;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-13 14:55
 */
public class Value<T> {
    public static <T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
