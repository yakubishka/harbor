package ru.vladislavop.schedule;

import ru.vladislavop.Ship;
import ru.vladislavop.Utils;
import ru.vladislavop.cargo.BaseCargo;

public class ScheduleEntry{

  private long arriveDateTimestamp;
  private Ship ship;
  private long plannedUnloadPeriod;

  public ScheduleEntry(Ship ship, long arriveDateTimestamp, long plannedUnloadPeriod) {
    this.arriveDateTimestamp = arriveDateTimestamp;
    this.ship = ship;
    this.plannedUnloadPeriod = plannedUnloadPeriod;
  }

  public long getArriveDateTimestamp() {
    return arriveDateTimestamp;
  }

  public void setArriveDateTimestamp(long arriveDateTimestamp) {
    this.arriveDateTimestamp = arriveDateTimestamp;
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public long getPlannedUnloadPeriod() {
    return plannedUnloadPeriod;
  }

  public void setPlannedUnloadPeriod(long plannedUnloadPeriod) {
    this.plannedUnloadPeriod = plannedUnloadPeriod;
  }

  @Override
  public String toString() {
    return "Ship name: " + ship.getName() + Utils.columnDelimiter +
           "arrive date: " + arriveDateTimestamp + Utils.columnDelimiter +
           "upload period: " + plannedUnloadPeriod + Utils.columnDelimiter;
  }
}
