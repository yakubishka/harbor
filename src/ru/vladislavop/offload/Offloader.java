package ru.vladislavop.offload;

import ru.vladislavop.Ship;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.types.CraneContainer;
import ru.vladislavop.crane.types.CraneLiquid;
import ru.vladislavop.crane.types.CraneLoose;
import ru.vladislavop.schedule.ScheduleEntry;
import ru.vladislavop.schedule.Scheduler;

import java.util.List;

public class Offloader {

  private final OffloadLine<CraneLiquid> liquidOffloadLine = new OffloadLine<>(10, new CraneLiquid());
  private final OffloadLine<CraneContainer> containerOffloadLine = new OffloadLine<>(10, new CraneContainer());
  private final OffloadLine<CraneLoose> looseOffloadLine = new OffloadLine<>(10, new CraneLoose());

  public void offload(Scheduler scheduler, List<DelayCondition> delayConditions) {
    for (ScheduleEntry entry : scheduler.getScheduleList()) {
      Ship ship = entry.getShip();
      entry.setRealEndUnloadDate( switch (ship.getCargo().getCargoType()) {
        case LIQUID -> liquidOffloadLine.getNextOffloadTime(entry.getArriveDate(), ship);
        case LOOSE -> looseOffloadLine.getNextOffloadTime(entry.getArriveDate(), ship);
        case CONTAINER -> containerOffloadLine.getNextOffloadTime(entry.getArriveDate(), ship);
      });
      System.out.println(entry.getRealEndUnloadDate());
    }
  }

}
