package ru.vladislavop.offload;

import ru.vladislavop.Ship;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;
import ru.vladislavop.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class OffloadLine<T extends Loadable> {

  private final ArrayList<Long> releaseTimes = new ArrayList<>();
  private final T crane;

  public OffloadLine(int cranesCount, T crane) {
    for (int i = 0; i < cranesCount; i++) releaseTimes.add(0L);
    this.crane = crane;
  }

  /**
   * @param delayConditions must be sorted by delayStartTime list
   */
  public long getNextOffloadTime(long plannedStartHandleTime, Ship ship, List<DelayCondition> delayConditions) {
    long startOffloadTime = getStartOffloadTime(plannedStartHandleTime);
    long resultTime =  startOffloadTime + crane.calculateUnloadTime(ship.getCargo());
    resultTime += calculateFullDelayTime(startOffloadTime, resultTime, delayConditions);
    releaseTimes.set(getNearestTimeIndex(plannedStartHandleTime), resultTime);
    return resultTime;
  }

  public long getStartOffloadTime(long plannedStartHandleTime) {
    int releaseTimeIndex = getNearestTimeIndex(plannedStartHandleTime);
    return plannedStartHandleTime > releaseTimes.get(releaseTimeIndex) ? plannedStartHandleTime : releaseTimes.get(releaseTimeIndex);
  }

  private long calculateFullDelayTime(long startTime, long plannedEndTime, List<DelayCondition> delayConditions) {
    long fullDelayTime = 0;
    for (DelayCondition delay : delayConditions) {
      if ((delay.getStartTime() > startTime && delay.getStartTime() < plannedEndTime) ||
          (delay.getEndTime() < plannedEndTime && delay.getEndTime() > startTime)) {
        fullDelayTime += delay.getDelayTime();
      }
    }
    return fullDelayTime;
  }

  private int getNearestTimeIndex(long plannedStartHandleTime) {
    int nearestTimeInd = 0;
    for (int i = 0; i < releaseTimes.size(); i++)
      if (plannedStartHandleTime > releaseTimes.get(i))
        return i;
      else if (releaseTimes.get(nearestTimeInd) - plannedStartHandleTime > releaseTimes.get(i) - plannedStartHandleTime)
        nearestTimeInd = i;
    return nearestTimeInd;
  }

}
