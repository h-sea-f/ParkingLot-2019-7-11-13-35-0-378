package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class LotServiceManager extends SillyParkingBoy {
    private List<ParkingLot> parkingLotList;
    private List<ParkingBoy> parkingBoyList=new ArrayList<>();

    public void addParkingBoy(ParkingBoy parkingBoy){
        this.parkingBoyList.add(parkingBoy);
    }

    public ParkingTicket targetParkingBoyParkCar(Car car){
        if(this.parkingBoyList.size() > 0) {
            int randomNumber=(int)(Math.random()*(parkingBoyList.size()));
            return parkingBoyList.get(randomNumber).parkingBoyParkCar(car,this.parkingLotList);
        } else {
            System.out.print("Don't hava any parking boy.\n");
            return null;
        }
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
}
