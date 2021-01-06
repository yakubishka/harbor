package ru.vladislavop.schedule;

import java.util.ArrayList;

public class Scheduler {

  private final ArrayList<ScheduleEntry> scheduleList = new ArrayList<>();

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
    for (ScheduleEntry entry : scheduleList)
      System.out.println(entry);
  }

  public void printAvgWaitingTime() {
    long waitingTime = 0;
    for (ScheduleEntry entry : scheduleList)
      waitingTime += entry.getRealStartUnloadDate() - entry.getArriveDate();
    System.out.println("----------------------------------");
    System.out.println("Average waiting time is " + (waitingTime / scheduleList.size()));
  }

  public void printCountOfUnloadedShips() {
    System.out.println("----------------------------------");
    System.out.println("Count of unloaded ships is " + scheduleList.size());
  }

  public void printMaxAndMinWaitingTime() {
    long maxWaitingTime = 0;
    long minWaitingTime = scheduleList.get(0).getRealStartUnloadDate() - scheduleList.get(0).getArriveDate();
    for (ScheduleEntry entry : scheduleList) {
      long entryWaitingTime = entry.getRealStartUnloadDate() - entry.getArriveDate();
      if (maxWaitingTime < entryWaitingTime)
        maxWaitingTime = entryWaitingTime;
      if (minWaitingTime > entryWaitingTime)
        minWaitingTime = entryWaitingTime;
    }
    System.out.println("----------------------------------");
    System.out.println("Min waiting time is " + minWaitingTime);
    System.out.println("Max waiting time is " + maxWaitingTime);
  }

  //TODO minor refactor
  public void printFullExpirationPrice() {
    long fullExpirationTime = 0;
    for (ScheduleEntry entry : scheduleList)
      fullExpirationTime += entry.getRealEndUnloadDate() - entry.getPlannedSailOffTime();
    System.out.println("----------------------------------");
    System.out.println("Full price for expiration is " + fullExpirationTime);
  }

  public ArrayList<ScheduleEntry> getScheduleList() {
    return scheduleList;
  }

}
