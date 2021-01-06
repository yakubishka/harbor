package ru.vladislavop;

import ru.vladislavop.cargo.types.ContainerCargo;
import ru.vladislavop.cargo.types.LiquidCargo;
import ru.vladislavop.offload.Offloader;
import ru.vladislavop.schedule.ScheduleEntry;
import ru.vladislavop.schedule.Scheduler;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    LiquidCargo liqCargo = new LiquidCargo(20.100);
    ContainerCargo contCargo = new ContainerCargo(102321.210);

    Ship rusShip = new Ship("Аврора", liqCargo);
    Ship usShip = new Ship("Susana", contCargo);

    ScheduleEntry firstEntry = new ScheduleEntry(rusShip, 21321312312L, 2131L);
    ScheduleEntry secondEntry = new ScheduleEntry(usShip, 12312321321L, 12312312L);

    Scheduler scheduler = new Scheduler();
    scheduler.addEntry(firstEntry);
    scheduler.addEntry(secondEntry);

    scheduler.printSchedule();

    Offloader offloader = new Offloader();
    offloader.offload(scheduler, new ArrayList<>());

    System.out.println("-------------------------------------");
    scheduler.printSchedule();

  }
}
