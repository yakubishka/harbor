package ru.vladislavop.crane;

import ru.vladislavop.cargo.BaseCargo;

public interface Loadable{
  long calculateUnloadTime(BaseCargo cargo);
}
