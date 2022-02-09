package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;

public class LargeSpot extends ParkingSpot {
    public LargeSpot() {
        super(ParkingSpotType.LARGE);
    }

    @Override
    public boolean IsFree() {
        return false;
    }
}