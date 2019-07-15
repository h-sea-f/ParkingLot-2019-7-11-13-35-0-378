package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {

    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<ParkingTicket, Car>();

    public ParkingTicket parkCar(Car car) {
        if (this.cars.size() < this.capacity) {
            ParkingTicket ticket = new ParkingTicket(car);
            this.cars.put(ticket, car);
            return ticket;
        } else {
            throw new NotEnoughPositionException();
        }

    }

    public Car takeCar(ParkingTicket ticket) {
        if (ticket == null) {
            throw new PleaseProvideYourParkingTicketException();
        }
        if (cars.containsKey(ticket)) {
            return cars.remove(ticket);
        } else {
            throw new UnrecognizedParkingTicketException();
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

    public Map<ParkingTicket, Car> getCars() {
        return cars;
    }
}
