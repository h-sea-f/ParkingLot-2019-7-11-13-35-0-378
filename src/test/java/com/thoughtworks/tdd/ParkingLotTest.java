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
    @DisplayName("shoule return a car when takeCar give right ticket")
    public void should_return_a_car_when_takeCar_give_right_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingTicket ticket = parkingLot.parkCar(car);
        //when
        //then
        Assertions.assertEquals(parkingLot.takeCar(ticket).getCarId(), car.getCarId());
    }

    @Test
    @DisplayName("should return UnrecognizedParkingTicketException when takeCar give error ticket")
    public void should_return_UnrecognizedParkingTicketException_when_takeCar_give_error_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingTicket ticket = parkingLot.parkCar(car);
        ParkingTicket ticket1 = new ParkingTicket();
        //when
        //then
        Assertions.assertThrows(UnrecognizedParkingTicketException.class, () -> parkingLot.takeCar(ticket1));
    }

    @Test
    @DisplayName("should throw NotEnoughPositionException when parkCar park full give a car")
    public void should_throw_NotEnoughPositionException_when_parkCar_park_full_give_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car(123);
        //when
        //then
        Assertions.assertThrows(NotEnoughPositionException.class, () -> parkingLot.parkCar(car));
    }

    @Test
    public void should_return_ticket_when_parkCar_give_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        ParkingLot parkingLot1 = new ParkingLot(2);
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.addParkingLot(parkingLot1);
        //when
        ParkingTicket ticket = parkingBoy.parkCar(car);
        //then
        Assertions.assertEquals(ticket.getCar(), car);
    }

    @Test
    @DisplayName("should add car into parkingLot2 when parkCar  give a car and parkingLot1 is full")
    public void should_add_car_into_parkingLot2_when_smartParkingBoy_parkCar_give_a_car_and_parkingLot1_is_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Car car = new Car(123);
        Parker parkingBoy = new SmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        parkingBoy.addParkingLot(parkingLot2);
        //when
        ParkingTicket ticket = parkingBoy.parkCar(car);
        //then
        Assertions.assertEquals(parkingLot2.takeCar(ticket), car);
    }

    @Test
    public void should_add_car_into_parkingLot2_when_superParkingBoy_parkCar_give_a_car_and_parkingLot2_lower_utilization() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Car car = new Car(123);
        Parker parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        parkingBoy.addParkingLot(parkingLot2);
        Car car1 = new Car(222);
        //when
        parkingBoy.parkCar(car);
        ParkingTicket parkingTicket = parkingBoy.parkCar(car1);
        //then
        Assertions.assertEquals(parkingLot2.takeCar(parkingTicket), car1);
    }

    @Test
    public void should_return_parkingLotTicket_when_LotServiceManager_give_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        Car car = new Car(123);
        Parker parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        LotServiceManager lotServiceManager = new LotServiceManager();
        lotServiceManager.addParkable(parkingBoy);
        //when
        ParkingTicket parkingTicket = lotServiceManager.parkCar(car);
        //then
        Assertions.assertEquals(parkingTicket.getCar(), car);
    }

    @Test
    public void should_throw_NotEnoughPositionException_when_LotServiceManager_give_a_car_and_parkables_all_full() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(0);
        Car car = new Car(123);
        Parker parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        LotServiceManager lotServiceManager = new LotServiceManager();
        lotServiceManager.addParkable(parkingBoy);
        //when
        //then
        Assertions.assertThrows(NotEnoughPositionException.class, () -> lotServiceManager.parkCar(car));
    }

    @Test
    public void should_throw_UnrecognizedParkingTicketException_when_LotServiceManager_give_a_error_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        Car car = new Car(123);
        Parker parkingBoy = new SuperSmartParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        LotServiceManager lotServiceManager = new LotServiceManager();
        lotServiceManager.addParkable(parkingBoy);
        lotServiceManager.parkCar(car);
        ParkingTicket ticket=new ParkingTicket();
        //when
        //then
        Assertions.assertThrows(UnrecognizedParkingTicketException.class, () -> lotServiceManager.takeCar(ticket));
    }
}
