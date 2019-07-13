package com.thoughtworks.tdd;

import sun.security.krb5.internal.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int capacity;
    private Map<ParkingTicket, Car> cars = new HashMap<ParkingTicket, Car>();

    public ParkingTicket parkCar(Car car){
        ParkingTicket ticket=new ParkingTicket(car);
        this.cars.put(ticket,car);
        return ticket;
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
