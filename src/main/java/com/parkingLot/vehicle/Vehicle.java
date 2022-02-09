package main.java.com.parkingLot.vehicle;

import main.java.com.parkingLot.ParkingTicket;
import main.java.com.parkingLot.enums.VehicleType;

public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;

    public VehicleType getType() {
        return type;
    }

    private ParkingTicket ticket;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
