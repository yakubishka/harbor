package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.types.LiquidCargo;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;
import java.util.List;

public class CraneLiquid implements Loadable<LiquidCargo> {

  @Override
  public double calculateUnloadTime(LiquidCargo cargo, List<DelayCondition> delays) {
    return 0;
  }

}
