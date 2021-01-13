package ru.vladislavop.crane;

import ru.vladislavop.utils.DateUtils;

import java.util.Random;

public class DelayCondition {

  private String conditionName;
  private final long delayTime;
  private final long startTime;
  private final long endTime;

  public DelayCondition(String conditionName, long startTime, long endTime) {
    this.conditionName = conditionName;
    this.delayTime = DateUtils.daysToMillis((new Random()).nextInt(11));
    this.startTime = startTime;
    this.endTime = endTime;
  }

  public String getConditionName() {
    return conditionName;
  }

  public void setConditionName(String conditionName) {
    this.conditionName = conditionName;
  }

  public long getDelayTime() {
    return delayTime;
  }

  public long getStartTime() {
    return startTime;
  }

  public long getEndTime() {
    return endTime;
  }

}
