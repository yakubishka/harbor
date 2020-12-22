package ru.vladislavop.crane;

import ru.vladislavop.cargo.BaseCargo;

import java.util.List;

public interface Loadable{
  double calculateUnloadTime(BaseCargo cargo, List<DelayCondition> delays);
}
