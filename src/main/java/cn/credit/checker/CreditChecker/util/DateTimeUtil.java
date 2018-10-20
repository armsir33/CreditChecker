package cn.credit.checker.CreditChecker.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static cn.credit.checker.CreditChecker.service.AliServiceConstants.ZHIMA_TIMESTAMP;

public class DateTimeUtil {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(ZHIMA_TIMESTAMP);

    public static String getCurrentTimeAsString() {
        return DATE_TIME_FORMATTER.format(LocalDateTime.now());
    }
}
