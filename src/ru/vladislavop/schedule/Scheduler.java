package ru.vladislavop.schedule;

import ru.vladislavop.utils.DateUtils;
import ru.vladislavop.utils.Utils;

import java.util.ArrayList;

public class Scheduler {

  private final ArrayList<ScheduleEntry> scheduleList = new ArrayList<>();

  public ArrayList<ScheduleEntry> getScheduleList() {
    return scheduleList;
  }

  public void addEntry(ScheduleEntry entry) {
    int sortedPosition = 0;
    for (int i = 0; i < scheduleList.size(); i++)
      if (scheduleList.get(i).getArriveDate() < entry.getArriveDate())
        sortedPosition = i + 1;
      else
        break;
    scheduleList.add(sortedPosition, entry);
  }

  public void printSchedule() {
    System.out.printf((Utils.entryFormat) + "%n",
        "Ship",
        "Arrive",
        "Sail off",
        "Start unload",
        "End unload",
        "Expiration");
    for (ScheduleEntry entry : scheduleList)
      System.out.println(entry);
  }

  public void printAvgWaitingTime() {
    long waitingTime = 0;
    for (ScheduleEntry entry : scheduleList)
      waitingTime += entry.getRealStartUnloadDate() - entry.getArriveDate();
    System.out.println(Utils.rowDelimiter);
    System.out.println("Average waiting time: " + DateUtils.millisToDays(waitingTime / scheduleList.size()));
  }

  public void printCountOfUnloadedShips() {
    System.out.println("Count of unloaded ships: " + scheduleList.size());
  }

  public void printMaxAndMinWaitingTime() {
    long maxWaitingTime = 0;
    if (!scheduleList.isEmpty()) {
      long minWaitingTime = -1;
      for (ScheduleEntry entry : scheduleList) {
        long entryWaitingTime = DateUtils.calculateDayDiff(entry.getRealStartUnloadDate(), entry.getArriveDate());
        if (maxWaitingTime < entryWaitingTime)
          maxWaitingTime = entryWaitingTime;
        if ((minWaitingTime > entryWaitingTime || minWaitingTime == -1) && entryWaitingTime > 0)
          minWaitingTime = entryWaitingTime;
      }
      System.out.println("Min waiting time: " + minWaitingTime);
      System.out.println("Max waiting time: " + maxWaitingTime);
    }
  }

  public void printFullExpirationPrice() {
    System.out.println("Full price for expiration: " + getFullExpirationTimeInDays() * Utils.penniPerDay);
  }

  public void printExtraCranesCountRequired() {
    System.out.println("Extra cranes needed for unloading: " + calculateExtraCranesCountReq());
  }

  public void printReport() {
    System.out.println(Utils.rowDelimiter);
    printSchedule();
    System.out.println(Utils.rowDelimiter);
    printCountOfUnloadedShips();
    System.out.println(Utils.rowDelimiter);
    printMaxAndMinWaitingTime();
    System.out.println(Utils.rowDelimiter);
    printAvgWaitingTime();
    System.out.println(Utils.rowDelimiter);
    printFullExpirationPrice();
    System.out.println(Utils.rowDelimiter);
    printExtraCranesCountRequired();
  }

  private int calculateExtraCranesCountReq() {
    int extraCraneCount = 0;
    for (ScheduleEntry entry : scheduleList)
      if (entry.expireTimeInDays() > 1 && entry.getRealStartUnloadDate() > entry.getArriveDate())
        extraCraneCount++;
    return extraCraneCount;
  }

  private long getFullExpirationTimeInDays() {
    long fullExpirationTime = 0;
    for (ScheduleEntry entry : scheduleList)
      fullExpirationTime += entry.expireTimeInDays();
    return fullExpirationTime;
  }

}
