package com.thoughtworks.tdd;

public class ParkingTicket {
    private Car car;

    public ParkingTicket(Car car) {
        this.car = car;
    }

    public ParkingTicket(){}

    public Car getCar() {
        return car;
    }
}
