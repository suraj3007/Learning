package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;

public class CompactSpot extends ParkingSpot {
    public CompactSpot() {
        super(ParkingSpotType.COMPACT);
    }

    @Override
    public boolean IsFree() {
        return false;
    }
}
