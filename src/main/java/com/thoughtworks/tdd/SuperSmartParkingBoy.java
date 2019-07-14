package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy {
    public ParkingTicket paringBoyParkCar(Car car, List<ParkingLot> parkingLotList) {
        ParkingLot lowestUtilizationParkingLot = parkingLotList.get(0);
        for (ParkingLot parkingLot : parkingLotList) {
            boolean isLowestUtilizationParkingLot = (parkingLot.getCars().size() / parkingLot.getCapacity()) < (lowestUtilizationParkingLot.getCars().size() / lowestUtilizationParkingLot.getCapacity());
            if (isLowestUtilizationParkingLot) {
                lowestUtilizationParkingLot = parkingLot;
            }
        }
        return lowestUtilizationParkingLot.parkCar(car);
    }
}
