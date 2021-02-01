package com.github.surgeon.util;

public class IdUtil extends cn.hutool.core.util.IdUtil {
    public static Long getNextId() {
        return getSnowflake(1, 1).nextId();
    }

    public static String getNextIdStr() {
        return getSnowflake(1, 1).nextIdStr();
    }
}
