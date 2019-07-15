package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class LotServiceManager {
    private List<Parkable> parkables = new ArrayList<>();

    public void addParkable(Parkable parkable) {
        this.parkables.add(parkable);
    }

    public ParkingTicket parkCar(Car car) {
        for (Parkable parkable : parkables
                ) {
            if (!parkable.isFull()) {
                parkable.parkCar(car);
            }
        }
        throw new NotEnoughPositionException();
    }

    public Car takeCar(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new PleaseProvideYourParkingTicketException();
        } else {
            for (Parkable parkable : parkables
                    ) {
                if (parkable.isContainCorrespondCar(parkingTicket)) {
                    return parkable.takeCar(parkingTicket);
                }
            }
            throw new UnrecognizedParkingTicketException();
        }
    }

}
