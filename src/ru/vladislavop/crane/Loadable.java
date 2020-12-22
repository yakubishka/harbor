package ru.vladislavop.crane;

import ru.vladislavop.cargo.BaseCargo;

import java.util.List;

public interface Loadable <T extends BaseCargo> {
  double calculateUnloadTime(T cargo, List<DelayCondition> delays);
}
