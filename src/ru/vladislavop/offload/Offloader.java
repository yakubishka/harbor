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

  private final int CRANES_COUNT = 10;

  private final OffloadLine<CraneLiquid> liquidOffloadLine = new OffloadLine<>(CRANES_COUNT, new CraneLiquid());
  private final OffloadLine<CraneContainer> containerOffloadLine = new OffloadLine<>(CRANES_COUNT, new CraneContainer());
  private final OffloadLine<CraneLoose> looseOffloadLine = new OffloadLine<>(CRANES_COUNT, new CraneLoose());

  public void offload(Scheduler scheduler, List<DelayCondition> delayConditions) {
    for (ScheduleEntry entry : scheduler.getScheduleList()) {
      Ship ship = entry.getShip();
      OffloadLine<?> line = switch (ship.getCargo().getCargoType()) {
        case LIQUID -> liquidOffloadLine;
        case LOOSE -> looseOffloadLine;
        case CONTAINER -> containerOffloadLine;
      };
      entry.setRealStartUnloadDate(line.getStartOffloadTime(entry.getArriveDate()));
      entry.setRealEndUnloadDate(line.getNextOffloadTime(entry.getArriveDate(), ship, delayConditions));
    }
  }

}
