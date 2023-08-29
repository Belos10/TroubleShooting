package org.telecom.common;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LocalTimeConvert
{
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp)
    {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }
}
