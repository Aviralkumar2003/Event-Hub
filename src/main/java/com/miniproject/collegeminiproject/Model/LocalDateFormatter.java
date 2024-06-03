package com.miniproject.collegeminiproject.Model;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateFormatter implements Formatter<LocalDate> {

    private final DateTimeFormatter formatter;

    public LocalDateFormatter() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @SuppressWarnings("null")
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, formatter);
    }

    @SuppressWarnings("null")
    @Override
    public String print(LocalDate object, Locale locale) {
        return formatter.format(object);
    }
}