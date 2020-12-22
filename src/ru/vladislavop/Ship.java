package ru.vladislavop;

import ru.vladislavop.cargo.BaseCargo;

public class Ship {

  private String name;
  private BaseCargo cargo;

  public Ship(String name, BaseCargo cargo) {
    this.name = name;
    this.cargo = cargo;
  }

  public String getName() {
    return name;
  }

  public BaseCargo getCargo() {
    return cargo;
  }

}
