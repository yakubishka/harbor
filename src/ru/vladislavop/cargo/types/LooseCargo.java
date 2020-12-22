package ru.vladislavop.cargo.types;

import ru.vladislavop.cargo.BaseCargo;

public class LooseCargo extends BaseCargo {

  public LooseCargo(double weight) {
    super(weight);
  }

  @Override
  public CargoType getCargoType() {
    return CargoType.LOOSE;
  }

}
