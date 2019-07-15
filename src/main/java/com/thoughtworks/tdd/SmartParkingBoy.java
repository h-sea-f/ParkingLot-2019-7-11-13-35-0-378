package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SmartParkingBoy extends Parker {

    @Override
    public ParkingTicket parkCar(Car car) {
        ParkingLot vancanestParkingLot = parkingLots.get(0);
        for (ParkingLot prakingLot : parkingLots) {
            boolean isVancanestParkingLot = prakingLot.getRemainder() > vancanestParkingLot.getRemainder();
            if (isVancanestParkingLot) {
                vancanestParkingLot = prakingLot;
            }
        }
        return vancanestParkingLot.parkCar(car);
    }
}
