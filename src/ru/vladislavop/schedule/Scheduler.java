package ru.vladislavop.schedule;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.cargo.types.ContainerCargo;
import ru.vladislavop.cargo.types.LiquidCargo;
import ru.vladislavop.cargo.types.LooseCargo;

import java.util.ArrayList;

public class Scheduler {

  private final ArrayList<ScheduleEntry> scheduleList = new ArrayList<>();

  public void addEntry(ScheduleEntry<?> entry) {
    int sortedPosition = 0;
    for (int i = 0; i < scheduleList.size(); i++)
      if (scheduleList.get(i).getArriveDateTimestamp() < entry.getArriveDateTimestamp())
        sortedPosition = i + 1;
      else
        break;
    scheduleList.add(sortedPosition, entry);
  }

  public void remove() {

  }

  public void printSchedule() {
  }

}
