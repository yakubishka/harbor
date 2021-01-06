package ru.vladislavop.offload;

import ru.vladislavop.Ship;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;

import java.util.ArrayList;
import java.util.List;

public class OffloadLine<T extends Loadable> {

  protected ArrayList<Long> releaseTimes = new ArrayList<>();
  protected T crane;

  public OffloadLine(int cranesCount, T crane) {
    for (int i = 0; i < cranesCount; i++) releaseTimes.add(0L);
    this.crane = crane;
  }

  public long getNextOffloadTime(long plannedStartHandleTime, Ship ship, List<DelayCondition> delayConditions) {
    int nearestTimeInd = 0;
    for (int i = 0; i < releaseTimes.size(); i++) {
      if (plannedStartHandleTime > releaseTimes.get(i)) {
        long resultTime = plannedStartHandleTime + crane.calculateUnloadTime(ship.getCargo());
        resultTime += calculateFullDelayTime(plannedStartHandleTime, resultTime, delayConditions);
        releaseTimes.set(i, resultTime);
        return releaseTimes.get(i);
      } else if (releaseTimes.get(nearestTimeInd) - plannedStartHandleTime > releaseTimes.get(i) - plannedStartHandleTime)
        nearestTimeInd = i;
    }
    long resultTime = releaseTimes.get(nearestTimeInd) + crane.calculateUnloadTime(ship.getCargo());
    resultTime += calculateFullDelayTime(releaseTimes.get(nearestTimeInd), resultTime, delayConditions);
    return resultTime;
  }


  public long getNextOffloadTime(long plannedStartHandleTime, Ship ship) {
    return this.getNextOffloadTime(plannedStartHandleTime, ship, new ArrayList<>());
  }

  private long calculateFullDelayTime(long startTime, long plannedEndTime, List<DelayCondition> delayConditions) {
    long fullDelayTime = 0;
    for (DelayCondition delay : delayConditions) {
      if ((delay.getStartTime() > startTime && delay.getStartTime() < plannedEndTime) ||
          (delay.getEndTime() < plannedEndTime && delay.getEndTime() > startTime))
        fullDelayTime += delay.getDelayTime();
    }
    return fullDelayTime;
  }

}
