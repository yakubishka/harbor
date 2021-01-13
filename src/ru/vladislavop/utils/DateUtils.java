package ru.vladislavop.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

  private static final long MILLIS_IN_DAY = 60 * 60 * 24 * 1000;
  private static final String DATE_FORMAT = "dd.MM.yyyy";

  public static long calculateDayDiff(long date1, long date2) {
    return millisToDays(date1) - millisToDays(date2);
  }

  public static String convertTimestampToString(long timestamp) {
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT, Locale.ROOT);
    Date date = new Date(timestamp);
    return formatter.format(date);
  }

  public static long convertStringToTimestamp(String dateStr) throws ParseException {
    DateFormat df = new SimpleDateFormat(DATE_FORMAT);
    return df.parse(dateStr).getTime();
  }

  public static long millisToDays(long date) {
    return date / MILLIS_IN_DAY;
  }

  public static long daysToMillis(long days) {
    return days * MILLIS_IN_DAY;
  }

}
