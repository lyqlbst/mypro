package com.bonc.test.util;

import java.util.UUID;

/**
 * Created by LinYuQiang on 2018/1/9 0009.
 */
public class UUIDUtil {

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
