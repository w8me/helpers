package com.relucks.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Objects;

public class DateHelper {

    public static String convertDate(String value, String oldFormat, String newFormat) {
        try {
            return new SimpleDateFormat(newFormat, Locale.ENGLISH).format(Objects.requireNonNull(new SimpleDateFormat(oldFormat, Locale.ENGLISH).parse(value)));
        } catch (ParseException ignored) {
            return value;
        }
    }

    public static long getTimeInMls(String value, String format) {
        try {
            return Objects.requireNonNull(new SimpleDateFormat(format, Locale.ENGLISH).parse(value)).getTime();
        } catch (ParseException ignored) {
            return 0;
        }
    }
}
