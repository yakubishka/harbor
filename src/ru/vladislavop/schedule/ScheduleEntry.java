package ru.vladislavop.schedule;

import ru.vladislavop.Ship;
import ru.vladislavop.utils.DateUtils;
import ru.vladislavop.utils.Utils;

import java.text.ParseException;

public class ScheduleEntry {

  private Ship ship;

  private long arriveDate = 0L;
  private long plannedUnloadPeriod;

  private long realStartUnloadDate;
  private long realEndUnloadDate;

  public ScheduleEntry(Ship ship, String arriveDate, int plannedUnloadDaysPeriod) {
    this.ship = ship;
    try {
      this.arriveDate = DateUtils.convertStringToTimestamp(arriveDate);
    } catch (ParseException e) { e.printStackTrace(); }
    this.plannedUnloadPeriod = DateUtils.daysToMillis(plannedUnloadDaysPeriod);
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
    return "name: " + ship.getName() + Utils.columnDelimiter +
        "arrive date: " + DateUtils.convertTimestampToString(arriveDate) + Utils.columnDelimiter +
        "planned unload end: " + DateUtils.convertTimestampToString(getPlannedSailOffTime()) + Utils.columnDelimiter +
        "real unload start: " + DateUtils.convertTimestampToString(getRealStartUnloadDate()) + Utils.columnDelimiter +
        "real unload end: " + DateUtils.convertTimestampToString(realEndUnloadDate) + Utils.columnDelimiter +
        "expiration: " + expireTimeInDays() + " days" + Utils.columnDelimiter;
  }
}
