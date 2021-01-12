package ru.vladislavop.crane.types;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.crane.Loadable;
import ru.vladislavop.utils.DateUtils;

public class CraneLoose implements Loadable {

  @Override
  public long calculateUnloadTime(BaseCargo cargo) {
    return (long)cargo.getWeight() * DateUtils.daysToSeconds(3);
  }

}
