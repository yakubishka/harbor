package ru.vladislavop.cargo.types;

import ru.vladislavop.cargo.BaseCargo;

public class ContainerCargo extends BaseCargo {

  public ContainerCargo(double weight) {
    super(weight);
  }

  @Override
  public CargoType getCargoType() {
    return CargoType.CONTAINER;
  }

}
