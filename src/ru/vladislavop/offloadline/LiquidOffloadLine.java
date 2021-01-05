package ru.vladislavop.offloadline;

import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.types.CraneLiquid;

import java.util.List;

public class LiquidOffloadLine extends BaseLine<CraneLiquid> {

  public LiquidOffloadLine(List<DelayCondition> delayConditionList) {
    super(delayConditionList);
  }

  @Override
  void handle() {}

}
