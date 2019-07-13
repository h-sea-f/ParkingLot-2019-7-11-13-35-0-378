package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void should_return_a_ticket_when_park_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket ticket = parkingLot.parkCar(car);
        //then
        Assertions.assertEquals(ticket.getCar(), car);
    }
}
