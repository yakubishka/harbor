package ru.vladislavop.offloadline;

import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseLine<T extends Loadable> {

  protected ArrayList<T> cranes = new ArrayList<>();
  protected List<DelayCondition> delayConditionList;

  public BaseLine(List<DelayCondition> delayConditionList) {
    this.delayConditionList = delayConditionList;
  }

  abstract void handle();

}
