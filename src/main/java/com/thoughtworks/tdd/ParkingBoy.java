package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy extends Parker {
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    @Override
    public ParkingTicket parkCar(Car car) {
        ParkingLot notFullparkingLot = parkingLotList.stream().filter(parkingLot -> !parkingLot.isFull()).collect(Collectors.toList()).get(0);
        if (notFullparkingLot != null) {
            return notFullparkingLot.parkCar(car);
        } else {
            throw new NotEnoughPositionException();
        }

    }
}
