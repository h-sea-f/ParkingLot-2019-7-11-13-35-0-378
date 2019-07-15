package com.thoughtworks.tdd;

public class SuperSmartParkingBoy extends Parker {

    @Override
    public ParkingTicket parkCar(Car car) {
        ParkingLot lowestUtilizationParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            boolean isLowestUtilizationParkingLot =  parkingLot.getUtilizationRate() < lowestUtilizationParkingLot.getUtilizationRate();
            if (isLowestUtilizationParkingLot) {
                lowestUtilizationParkingLot = parkingLot;
            }
        }
        return lowestUtilizationParkingLot.parkCar(car);
    }
}
