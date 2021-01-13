package ru.vladislavop;

import ru.vladislavop.cargo.BaseCargo;
import ru.vladislavop.cargo.types.ContainerCargo;
import ru.vladislavop.cargo.types.LiquidCargo;
import ru.vladislavop.cargo.types.LooseCargo;
import ru.vladislavop.offload.Offloader;
import ru.vladislavop.schedule.ScheduleEntry;
import ru.vladislavop.schedule.Scheduler;
import ru.vladislavop.utils.DateUtils;
import ru.vladislavop.utils.Utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

  public static void main(String[] args) {
//    LiquidCargo liqCargo = new LiquidCargo(20.100);
//    ContainerCargo contCargo = new ContainerCargo(30);
//
//    Ship rusShip = new Ship("Аврора", liqCargo);
//    Ship usShip = new Ship("Susana", contCargo);
//
//    ScheduleEntry firstEntry = new ScheduleEntry(rusShip, "22.02.2020", 2);
//    ScheduleEntry secondEntry = new ScheduleEntry(usShip, "15.02.2020", 2);
//
//    Scheduler scheduler = new Scheduler();
//    scheduler.addEntry(firstEntry);
//    scheduler.addEntry(secondEntry);
//
//    Offloader offloader = new Offloader();
//    offloader.offload(scheduler, new ArrayList<>());

    Scheduler scheduler = createSchedule(System.currentTimeMillis());
    Offloader offloader = new Offloader();
    offloader.offload(scheduler, new ArrayList<>());
    scheduler.printReport();

  }

  public static Scheduler createSchedule(long startDateInMillis) {
    int modelingPeriod = 0;
    int step;
    int shipNumber = 0;
    Random rnd = new Random();
    Scheduler scheduler = new Scheduler();

    while (modelingPeriod <= 30) {
      shipNumber++;
      int weight = rnd.nextInt(15) + 1;
      BaseCargo cargo = switch (rnd.nextInt(3)) {
        case 0 -> new LiquidCargo(weight);
        case 1 -> new ContainerCargo(weight);
        default -> new LooseCargo(weight);
      };
      Ship newShip = new Ship("Судно №" + shipNumber, cargo);

      step = rnd.nextInt(3) + 1;
      modelingPeriod += step;
      long arriveTime = startDateInMillis + DateUtils.daysToMillis(modelingPeriod);
      scheduler.addEntry(new ScheduleEntry(newShip, DateUtils.convertTimestampToString(arriveTime), rnd.nextInt(3)));
    }
    return scheduler;
  }

}
