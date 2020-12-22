package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.cargo.types.ContainerCargo;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;

import java.util.List;

public class CraneContainer implements Loadable {

  @Override
  public double calculateUnloadTime(BaseCargo cargo, List<DelayCondition> delays) {
    return 0;
  }

}
