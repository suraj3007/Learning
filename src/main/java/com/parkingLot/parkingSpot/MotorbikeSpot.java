package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;

public class MotorbikeSpot extends ParkingSpot {
    public MotorbikeSpot() {
        super(ParkingSpotType.MOTORBIKE);
    }

    @Override
    public boolean IsFree() {
        return false;
    }
}