package ru.vladislavop.schedule;

import ru.vladislavop.Ship;
import ru.vladislavop.Utils;
import ru.vladislavop.cargo.BaseCargo;

public class ScheduleEntry<T extends BaseCargo> {

  private long arriveDateTimestamp;
  private Ship<T> ship;
  private long plannedUnloadPeriod;

  public ScheduleEntry(Ship<T> ship, long arriveDateTimestamp, long plannedUnloadPeriod) {
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

  public Ship<? extends BaseCargo> getShip() {
    return ship;
  }

  public void setShip(Ship<T> ship) {
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
