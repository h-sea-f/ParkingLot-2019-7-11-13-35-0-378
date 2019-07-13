package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<ParkingTicket, Car>();

    public ParkingTicket parkCar(Car car) {
        if (this.cars.size() < this.capacity) {
            ParkingTicket ticket = new ParkingTicket(car);
            this.cars.put(ticket, car);
            return ticket;
        } else {
            return null;
        }

    }

    public Car takeCar(ParkingTicket ticket) {
        if (cars.containsKey(ticket)) {
            return ticket.getCar();
        } else {
            return null;
        }

    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public int getCapacity() {
        return capacity;
    }
}
