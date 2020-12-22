package ru.vladislavop.crane;

import ru.vladislavop.cargo.BaseCargo;

public interface Loadable {
  double calculateUnloadTime(BaseCargo cargo);
}
