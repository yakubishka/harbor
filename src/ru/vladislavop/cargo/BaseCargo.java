package ru.vladislavop.cargo;

public abstract class BaseCargo {

  public enum CargoType { LIQUID, CONTAINER, LOOSE }

  private final double weight;

  public BaseCargo(double weight) {
    this.weight = weight;
  }

  public double getWeight() {
    return weight;
  }

  public abstract CargoType getCargoType();

}
