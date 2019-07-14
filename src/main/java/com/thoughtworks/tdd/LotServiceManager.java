package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class LotServiceManager extends SillyParkingBoy {
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingBoyList = new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoyList.add(parkingBoy);
    }

    public ParkingTicket targetParkingBoyParkCar(Car car) {
        if (this.parkingBoyList.size() > 0) {
            int randomNumber = (int) (Math.random() * (parkingBoyList.size()));
            return parkingBoyList.get(randomNumber).parkingBoyParkCar(car, this.parkingLotList);
        } else {
            System.out.print("Don't have any parking boy.\n");
            return null;
        }
    }

    public Car targetParkingBoyTakeCar(ParkingTicket parkingTicket) {
        if (this.parkingBoyList.size() > 0) {
            int randomNumber = (int) (Math.random() * (parkingBoyList.size()));
            for (ParkingLot parkingLot : this.parkingLotList
                    ) {
                if (parkingLot.takeCar(parkingTicket) != null) {
                    return parkingBoyList.get(randomNumber).parkingBoyTakeCar(parkingTicket, parkingLot);
                }
            }
            System.out.print("Unrecognized parking ticket.\n");
            return null;
        } else {
            System.out.print("Don't have any parking boy.\n");
            return null;
        }
    }

    public Car managerTakeCar(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : this.parkingLotList
                ) {
            if (parkingLot.takeCar(parkingTicket) != null) {
                return parkingLot.takeCar(parkingTicket);
            }
        }
        System.out.print("Unrecognized parking ticket.\n");
        return null;
    }

    public ParkingTicket managerParkCar(Car car) {
        return this.parkingBoyParkCar(car, this.parkingLotList);
    }

    public LotServiceManager(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
