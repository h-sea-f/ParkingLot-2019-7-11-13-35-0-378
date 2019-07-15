package com.thoughtworks.tdd;

import java.util.stream.Collectors;

public class ParkingBoy extends Parker {

    @Override
    public ParkingTicket parkCar(Car car) {
        for (ParkingLot parkingLot:parkingLots
             ) {
            if(!parkingLot.isFull()) {
                return parkingLot.parkCar(car);
            }
        }
        throw new NotEnoughPositionException();
    }
}
