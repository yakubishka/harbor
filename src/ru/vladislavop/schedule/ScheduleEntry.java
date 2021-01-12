package ru.vladislavop.schedule;

import ru.vladislavop.Ship;
import ru.vladislavop.utils.DateUtils;
import ru.vladislavop.utils.Utils;

public class ScheduleEntry {

  private long arriveDate;
  private Ship ship;
  private long plannedUnloadPeriod;

  private long realStartUnloadDate;
  private long realEndUnloadDate;

  public ScheduleEntry(Ship ship, long arriveDate, long plannedUnloadPeriod) {
    this.arriveDate = arriveDate;
    this.ship = ship;
    this.plannedUnloadPeriod = plannedUnloadPeriod;
  }

  public long getArriveDate() {
    return arriveDate;
  }

  public void setArriveDate(long arriveDate) {
    this.arriveDate = arriveDate;
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

  public long getPlannedSailOffTime() {
    return arriveDate + plannedUnloadPeriod;
  }

  public long getRealStartUnloadDate() {
    return realStartUnloadDate;
  }

  public void setRealStartUnloadDate(long realStartUnloadDate) {
    this.realStartUnloadDate = realStartUnloadDate;
  }

  public long getRealEndUnloadDate() {
    return realEndUnloadDate;
  }

  public void setRealEndUnloadDate(long realEndUnloadDate) {
    this.realEndUnloadDate = realEndUnloadDate;
  }

  public long expireTimeInDays() {
    long expiration = DateUtils.calculateDayDiff(getRealEndUnloadDate(), getPlannedSailOffTime());
    return expiration > 0 ? expiration : 0;
  }

  @Override
  public String toString() {
    return "Ship name: " + ship.getName() + Utils.columnDelimiter +
        "arrive date: " + DateUtils.convertTimestampToString(arriveDate) + Utils.columnDelimiter +
        "upload period: " + DateUtils.secondsToDays(plannedUnloadPeriod) + Utils.columnDelimiter +
        "real unload end: " + DateUtils.convertTimestampToString(realEndUnloadDate) + Utils.columnDelimiter +
        "expiration: " + expireTimeInDays() + " days" + Utils.columnDelimiter;
  }
}
