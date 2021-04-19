package br.com.portobello.digital.partnerspurchaseorderbatch.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class DateUtils {
    public static LocalDateTime parseStringToDateFormatterPba(String date) {
        String[] strings = date.split("/");
        int month = Integer.parseInt(strings[0]);
        int day = Integer.parseInt(strings[1]);
        var formattedStringDate = month < 10 ? "0".concat(date) : date;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a").withZone(ZoneId.systemDefault());
        if (day < 10) {
            dateTimeFormatter = DateTimeFormatter.ofPattern("MM/d/yyyy hh:mm:ss a").withZone(ZoneId.systemDefault());
        }

        return LocalDateTime.parse(formattedStringDate, dateTimeFormatter);
    }

    public static LocalDateTime parseStringToDateFormatterLeroy(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").withZone(ZoneId.systemDefault()));
    }
}
