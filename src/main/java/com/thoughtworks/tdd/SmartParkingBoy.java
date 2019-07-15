package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    @Override
    public ParkingTicket parkCar(Car car) {
        return null;
    }

    @Override
    public ParkingTicket parkingBoyParkCar(Car car, List<ParkingLot> parkingLotList) {
        ParkingLot vancanestParkingLot = parkingLotList.get(0);
        for (ParkingLot prakingLot : parkingLotList) {
            boolean isVancanestParkingLot = (prakingLot.getCapacity() - prakingLot.getCars().size()) > (vancanestParkingLot.getCapacity() - vancanestParkingLot.getCars().size());
            if (isVancanestParkingLot) {
                vancanestParkingLot = prakingLot;
            }
        }
        return vancanestParkingLot.parkCar(car);
    }
}
