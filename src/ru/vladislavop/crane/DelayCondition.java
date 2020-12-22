package ru.vladislavop.crane;

public class DelayCondition {

  private String conditionName;
  private long delayTime;

  public DelayCondition(String conditionName, long delayTime) {
    this.conditionName = conditionName;
    this.delayTime = delayTime;
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

}
