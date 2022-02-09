package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot() {
        super(ParkingSpotType.HANDICAPPED);
    }

    @Override
    public boolean IsFree() {
        return false;
    }
}
