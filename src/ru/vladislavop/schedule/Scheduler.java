package ru.vladislavop.schedule;

import java.util.ArrayList;

public class Scheduler {

  final ArrayList<ScheduleEntry> scheduleList = new ArrayList<>();

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
  }

  public ArrayList<ScheduleEntry> getScheduleList() {
    return scheduleList;
  }

}
