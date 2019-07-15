package com.thoughtworks.tdd;

public interface Parkable {
    ParkingTicket parkCar(Car car);

    Car takeCar(ParkingTicket parkingTicket);
}
