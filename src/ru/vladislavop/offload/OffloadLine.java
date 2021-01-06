package ru.vladislavop.offload;

import ru.vladislavop.Ship;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OffloadLine<T extends Loadable> {

  protected ArrayList<Long> releaseTimes = new ArrayList<>();
  protected T crane;

  public OffloadLine(int cranesCount, T crane) {
    for (int i = 0; i < cranesCount; i++) releaseTimes.add(0L);
    this.crane = crane;
  }

  public long getNextOffloadTime(long plannedStartHandleTime, Ship ship, List<DelayCondition> delayConditions) {
    HashMap<Integer, Long> map = getStartOffloadTime(plannedStartHandleTime);
    int nearestIndex = 0;
    for (Integer index: map.keySet())
      nearestIndex = index;
    long resultTime =  map.get(nearestIndex) + crane.calculateUnloadTime(ship.getCargo());
    resultTime += calculateFullDelayTime(map.get(nearestIndex), resultTime, delayConditions);
    releaseTimes.set(nearestIndex, resultTime);
    return resultTime;
  }

  public HashMap<Integer, Long> getStartOffloadTime(long plannedStartHandleTime) {
    HashMap<Integer, Long> resultMap = new HashMap<>();
    int releaseTimeIndex = getNearestTimeIndex(plannedStartHandleTime);
    resultMap.put(releaseTimeIndex, plannedStartHandleTime > releaseTimes.get(releaseTimeIndex)
        ? plannedStartHandleTime
        : releaseTimes.get(releaseTimeIndex));
    return resultMap;
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
