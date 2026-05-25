package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private TimeUtils() {
    }

    public static String getCurrentTime() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
