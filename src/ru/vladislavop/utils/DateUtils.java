package ru.vladislavop.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

  private static final long SECONDS_IN_DAY = 60 * 60 * 24;

  public static long calculateDayDiff(long date1, long date2) {
    return secondsToDays(date1) - secondsToDays(date2);
  }

  public static String convertTimestampToString(long timestamp) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ROOT);
    Date date = new Date(timestamp * 1000);
    return formatter.format(date);
  }

  public static long secondsToDays(long date) {
    return date / SECONDS_IN_DAY;
  }

  public static long daysToSeconds(long days) {
    return days * SECONDS_IN_DAY;
  }

}
