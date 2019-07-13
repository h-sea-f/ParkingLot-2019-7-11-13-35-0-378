package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    @DisplayName("shoule return null when takeCar give error ticket")
    public void should_return_null_when_takeCar_give_error_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingTicket ticket = parkingLot.parkCar(car);
        ParkingTicket ticket1 = new ParkingTicket();
        //when
        //then
        Assertions.assertEquals(parkingLot.takeCar(ticket1), null);
    }

    @Test
    @DisplayName("shoule return null when parkCar park full give a car")
    public void should_return_null_when_parkCar_park_full_give_a_car() {
        //given
        ParkingLot parkingLot=new ParkingLot(0);
        Car car=new Car(123);
        ParkingTicket ticket=parkingLot.parkCar(car);
        //when
        //then
        Assertions.assertEquals(ticket,null);
    }

    @Test
    @DisplayName("shoule return ticket when parkingBoyParkCar p give a car and a parkingLot")
    public void should_return_ticket_when_parkingBoyParkCar_give_a_car_and_a_parkingLot() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        Car car=new Car(123);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        ParkingTicket ticket=parkingBoy.parkingBoyParkCar(car,parkingLot);
        //then
        Assertions.assertEquals(ticket.getCar(),car);
    }

    @Test
    @DisplayName("shoule return ticketList when parkingBoyParkCars p give a carList and a parkingLot")
    public void should_return_ticketList_when_parkingBoyParkCars_give_a_carList_and_a_parkingLot() {
        //given
        ParkingLot parkingLot=new ParkingLot(10);
        Car car=new Car(123);
        Car car1=new Car(222);
        List<Car> carList=new ArrayList<>();
        carList.add(car);
        carList.add(car1);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        List<ParkingTicket> ticketList=parkingBoy.parkingBoyParkCars(carList,parkingLot);
        //then
        Assertions.assertEquals(ticketList.get(0).getCar(),car);
        Assertions.assertEquals(ticketList.get(1).getCar(),car1);
    }

    @Test
    @DisplayName("shoule return a car when parkingBoyTakeCar give right ticket and parkingLot")
    public void should_return_a_car_when_parkingBoyTakeCar_give_right_ticket_and_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingTicket parkingTicket=parkingBoy.parkingBoyParkCar(car,parkingLot);
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingTicket,parkingLot).getCarId(), car.getCarId());
    }

    @Test
    @DisplayName("shoule return null when parkingBoyTakeCar give erro ticket and parkingLot")
    public void should_return_null_when_parkingBoyTakeCar_give_error_ticket_and_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy=new ParkingBoy();
        ParkingTicket parkingTicket=new ParkingTicket();
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingTicket,parkingLot), null);
    }

    @Test
    @DisplayName("shoule return null when parkingBoyTakeCar give  parkingLot")
    public void should_return_null_when_parkingBoyTakeCar_give_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingLot), null);
    }
}
