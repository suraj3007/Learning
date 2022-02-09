package main.java.com.parkingLot.parkingSpot;

import main.java.com.parkingLot.enums.ParkingSpotType;
import main.java.com.parkingLot.vehicle.Vehicle;

public abstract class ParkingSpot {
    private String number;

    public String getNumber() {
        return number;
    }

    private boolean free;
    private Vehicle vehicle;
    private final ParkingSpotType type;

    public ParkingSpotType getType() {
        return type;
    }

    public abstract boolean IsFree();

    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public boolean assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
        return free;
    }

    public boolean removeVehicle() {
        this.vehicle = null;
        free = true;
        return free;
    }
}
