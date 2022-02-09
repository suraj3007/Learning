package main.java.com.parkingLot;

import main.java.com.parkingLot.parkingSpot.*;
import main.java.com.parkingLot.vehicle.Vehicle;

import java.util.HashMap;

public class ParkingFloor {
    private String name;
    private HashMap<String, ParkingSpot> handicappedSpots;
    private HashMap<String, ParkingSpot> compactSpots;
    private HashMap<String, ParkingSpot> largeSpots;
    private HashMap<String, ParkingSpot> motorbikeSpots;
    private HashMap<String, ParkingSpot> electricSpots;
//    private HashMap<String, CustomerInfoPortal> infoPortals;
    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getType()) {
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), spot);
                break;
            case MOTORBIKE:
                motorbikeSpots.put(spot.getNumber(), spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        switch (spot.getType()) {
            case HANDICAPPED:
                updateDisplayBoardForHandicapped(spot);
                break;
            case COMPACT:
                updateDisplayBoardForCompact(spot);
                break;
//            case LARGE:
//                updateDisplayBoardForLarge(spot);
//                break;
//            case MOTORBIKE:
//                updateDisplayBoardForMotorbike(spot);
//                break;
//            case ELECTRIC:
//                updateDisplayBoardForElectric(spot);
//                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            // find another free handicapped parking and assign to displayBoard
            for (String key : handicappedSpots.keySet()) {
//                if (handicappedSpots.get(key).isFree()) {
//                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
//                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
//                if (compactSpots.get(key).isFree()) {
//                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
//                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    public void freeSpot(ParkingSpot spot) {
        spot.removeVehicle();
        switch (spot.getType()) {
            case HANDICAPPED:
//                freeHandicappedSpotCount++;
                break;
            case COMPACT:
//                freeCompactSpotCount++;
                break;
            case LARGE:
//                freeLargeSpotCount++;
                break;
            case MOTORBIKE:
//                freeMotorbikeSpotCount++;
                break;
            case ELECTRIC:
//                freeElectricSpotCount++;
                break;
            default:
//                print("Wrong parking spot type!");
        }
    }
}
