package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.crane.Loadable;

public class CraneLiquid implements Loadable {

  @Override
  public long calculateUnloadTime(BaseCargo cargo) {
    return (long) cargo.getWeight() * 500L;
  }

}
