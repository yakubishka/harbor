package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.crane.Loadable;

public class CraneLoose implements Loadable {

  @Override
  public long calculateUnloadTime(BaseCargo cargo) {
    return (long)cargo.getWeight() * 1000L;
  }

}
