package ru.vladislavop;

import ru.vladislavop.cargo.BaseCargo;

public class Ship <T extends BaseCargo> {

  private final String name;
  private final T cargo;

  public Ship(String name, T cargo) {
    this.name = name;
    this.cargo = cargo;
  }

  public String getName() {
    return name;
  }

  public T getCargo() {
    return cargo;
  }

}
