package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.types.ContainerCargo;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;

import java.util.List;

public class CraneContainer implements Loadable<ContainerCargo> {

  @Override
  public double calculateUnloadTime(ContainerCargo cargo, List<DelayCondition> delays) {
    return 0;
  }

}
