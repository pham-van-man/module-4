package org.example.bai_tap_1.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LocalDateFormatter implements Formatter<LocalDate> {
    private final DateTimeFormatter dateFormatter;

    public LocalDateFormatter(String pattern) {
        this.dateFormatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, dateFormatter);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return object.format(dateFormatter);
    }
}
