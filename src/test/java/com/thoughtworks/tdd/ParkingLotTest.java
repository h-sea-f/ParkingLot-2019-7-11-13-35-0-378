package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

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
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car(123);
        ParkingTicket ticket = parkingLot.parkCar(car);
        //when
        //then
        Assertions.assertEquals(ticket, null);
    }

    @Test
    @DisplayName("shoule return ticket when parkingBoyParkCar p give a car and a parkingLot")
    public void should_return_ticket_when_parkingBoyParkCar_give_a_car_and_a_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        ParkingTicket ticket = parkingBoy.parkingBoyParkCar(car, parkingLot);
        //then
        Assertions.assertEquals(ticket.getCar(), car);
    }

    @Test
    @DisplayName("shoule return ticketList when parkingBoyParkCars p give a carList and a parkingLot")
    public void should_return_ticketList_when_parkingBoyParkCars_give_a_carList_and_a_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        Car car = new Car(123);
        Car car1 = new Car(222);
        List<Car> carList = new ArrayList<>();
        carList.add(car);
        carList.add(car1);
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        List<ParkingTicket> ticketList = parkingBoy.parkingBoyParkCars(carList, parkingLot);
        //then
        Assertions.assertEquals(ticketList.get(0).getCar(), car);
        Assertions.assertEquals(ticketList.get(1).getCar(), car1);
    }

    @Test
    @DisplayName("shoule return a car when parkingBoyTakeCar give right ticket and parkingLot")
    public void should_return_a_car_when_parkingBoyTakeCar_give_right_ticket_and_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = parkingBoy.parkingBoyParkCar(car, parkingLot);
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingTicket, parkingLot).getCarId(), car.getCarId());
    }

    @Test
    @DisplayName("shoule return null when parkingBoyTakeCar give erro ticket and parkingLot")
    public void should_return_null_when_parkingBoyTakeCar_give_error_ticket_and_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingTicket parkingTicket = new ParkingTicket();
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingTicket, parkingLot), null);
    }

    @Test
    @DisplayName("shoule return null when parkingBoyTakeCar give  parkingLot")
    public void should_return_null_when_parkingBoyTakeCar_give_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        //then
        Assertions.assertEquals(parkingBoy.parkingBoyTakeCar(parkingLot), null);
    }

    @Test
    @DisplayName("shoule have error message  when parkingBoyTakeCar give  parkingLot")
    public void should_have_error_message_when_parkingBoyTakeCar_give_parkingLot() {
        //given
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(123);
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        parkingBoy.parkingBoyTakeCar(parkingLot);
        //then
        Assertions.assertEquals(outContent.toString(), "Please provide your parking ticket.\n");
    }

    @Test
    @DisplayName("shoule return ticket  when SillyParkingBoy parkingBoyParkCar give car and parkingLotList")
    public void should_return_ticket_when_SillyParkingBoy_parkingBoyTakeCar_give_car_and_parkingLotList() {
        //given
        SillyParkingBoy sillyParkingBoy = new SillyParkingBoy();
        Car car = new Car(123);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        //when
        ParkingTicket parkingTicket = sillyParkingBoy.parkingBoyParkCar(car, parkingLotList);
        //then
        Assertions.assertEquals(parkingTicket.getCar(), car);
    }

    @Test
    @DisplayName("shoule return error message  when SillyParkingBoy parkingBoyParkCar give car and parkingLotList all full")
    public void should_return_error_message_when_SillyParkingBoy_parkingBoyTakeCar_give_car_and_parkingLotList_all_full() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //given
        SillyParkingBoy sillyParkingBoy=new SillyParkingBoy();
        Car car=new Car(123);
        ParkingLot parkingLot1=new ParkingLot(0);
        ParkingLot parkingLot2=new ParkingLot(0);
        List<ParkingLot> parkingLotList=new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        //when
        ParkingTicket parkingTicket=sillyParkingBoy.parkingBoyParkCar(car,parkingLotList);
        //then
        Assertions.assertEquals(outContent.toString(), "Not enough position.\n");
    }

    @Test
    @DisplayName("shoule return ticket  when SmartParkingBoy parkingBoyParkCar give car and parkingLotList")
    public void should_return_ticket_when_SmartParkingBoy_parkingBoyTakeCar_give_car_and_parkingLotList() {
        //given
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        Car car = new Car(123);
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);
        //when
        ParkingTicket parkingTicket = smartParkingBoy.prarkingBoyParkCar(car,parkingLotList);
        //then
        Assertions.assertEquals(parkingTicket.getCar(), car);
    }

}
