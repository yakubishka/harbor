package ru.vladislavop.cargo.types;

import ru.vladislavop.cargo.BaseCargo;

public class LiquidCargo extends BaseCargo {

  public LiquidCargo(double weight) {
    super(weight);
  }

  @Override
  public CargoType getCargoType() {
    return CargoType.LIQUID;
  }


}
