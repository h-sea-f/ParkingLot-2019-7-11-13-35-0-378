package com.thoughtworks.tdd;

import java.util.List;

public class SillyParkingBoy extends ParkingBoy {
    @Override
    public ParkingTicket parkCar(Car car) {
        return null;
    }

    @Override
    public ParkingTicket parkingBoyParkCar(Car car, List<ParkingLot> parkingLotList) {
        for (ParkingLot parkingLot : parkingLotList) {
            if (parkingLot.getCapacity() > parkingLot.getCars().size()) {
                return parkingLot.parkCar(car);
            }
        }
        System.out.print("Not enough position.\n");
        return null;
    }
}
