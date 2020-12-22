package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;
import java.util.List;

public class CraneLiquid implements Loadable {

  @Override
  public double calculateUnloadTime(BaseCargo cargo, List<DelayCondition> delays) {
    return 0;
  }

}
