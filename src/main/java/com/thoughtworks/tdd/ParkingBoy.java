package com.thoughtworks.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    public ParkingTicket parkingBoyParkCar(Car car,ParkingLot parkingLot){
        return parkingLot.parkCar(car);
    }

    public List<ParkingTicket> parkingBoyParkCars(List<Car> cars,ParkingLot parkingLot){
        return cars.stream().map(parkingLot::parkCar).collect(Collectors.toList());
    }

    public Car parkingBoyTakeCar(ParkingTicket parkingTicket,ParkingLot parkingLot){
        return parkingLot.takeCar(parkingTicket);
    }

    public Car parkingBoyTakeCar(ParkingLot parkingLot){
        return parkingLot.takeCar();
    }
}
