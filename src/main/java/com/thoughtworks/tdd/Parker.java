package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public abstract class Parker implements Parkable {
    protected List<ParkingLot> parkingLots = new ArrayList<>();

    public Car takeCar(ParkingTicket parkingTicket) {
        if (parkingTicket == null) {
            throw new PleaseProvideYourParkingTicketException();
        }
        for (ParkingLot parkingLot : parkingLots
                ) {
            if (parkingLot.getCars().containsKey(parkingTicket)) {
                return parkingLot.takeCar(parkingTicket);
            }
        }
        throw new UnrecognizedParkingTicketException();
    }
}
