package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.types.LooseCargo;
import ru.vladislavop.crane.DelayCondition;
import ru.vladislavop.crane.Loadable;
import java.util.List;

public class CraneLoose implements Loadable<LooseCargo> {
  @Override
  public double calculateUnloadTime(LooseCargo cargo, List<DelayCondition> delays) {
    return 0;
  }
}
