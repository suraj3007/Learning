package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;

public class ElectricSpot extends ParkingSpot {
    @Override
    public boolean IsFree() {
        return false;
    }

    public ElectricSpot() {
        super(ParkingSpotType.ELECTRIC);
    }
}
