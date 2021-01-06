package ru.vladislavop.crane;

public class DelayCondition {

  private String conditionName;
  private long delayTime;
  private long startTime;
  private long endTime;

  public DelayCondition(String conditionName, long delayTime, long startTime, long endTime) {
    this.conditionName = conditionName;
    this.delayTime = delayTime;
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

  public void setDelayTime(long delayTime) {
    this.delayTime = delayTime;
  }

  public long getStartTime() {
    return startTime;
  }

  public void setStartTime(long startTime) {
    this.startTime = startTime;
  }

  public long getEndTime() {
    return endTime;
  }

  public void setEndTime(long endTime) {
    this.endTime = endTime;
  }
}
