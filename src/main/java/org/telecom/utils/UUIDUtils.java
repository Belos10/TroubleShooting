package org.telecom.utils;

import java.util.UUID;

public class UUIDUtils {
    public static String getUUIDTopEight() {
        String preUuid = UUID.randomUUID().toString();
        return preUuid.substring(0, 8);
    }
}

