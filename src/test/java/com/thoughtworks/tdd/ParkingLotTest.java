package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    @DisplayName("shoule return a ticket when park a car")
    public void should_return_a_ticket_when_park_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        ParkingTicket ticket = parkingLot.parkCar(car);
        //then
        Assertions.assertEquals(ticket.getCar(), car);
    }

    @Test
    @DisplayName("shoule return a ticket when park a car")
    public void should_return_a_car_when_takeCar() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingTicket ticket = parkingLot.parkCar(car);
        //when
        //then
        Assertions.assertEquals(parkingLot.takeCar(ticket).getCarId(), car.getCarId());
    }


}
