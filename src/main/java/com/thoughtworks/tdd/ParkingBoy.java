package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public abstract class ParkingBoy {
    protected List<ParkingLot> parkingLotList = new ArrayList<>();

    public abstract ParkingTicket parkCar(Car car);

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);
    }


    public Car parkingBoyTakeCar(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        return parkingLot.takeCar(parkingTicket);
    }

}
