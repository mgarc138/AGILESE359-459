package edu.depaul.se359.model;

import edu.depaul.se359.exception.InvalidFloorCodeException;

import java.util.ArrayList;

/**
 * Created on 10/10/15.
 * Class: HomeLayout.java
 * Author: eric, marlon
 * Assignment: SE459
 */
public class HomeLayout {

    private ArrayList<Floor> floors;

    public HomeLayout() {
        floors = new ArrayList<Floor>();
    }

    public ArrayList<Floor> getFloors() {
        return floors;
    }

    public void setFloors(ArrayList<Floor> floor) {
        this.floors = floor;
    }

    public Floor getFloor(int floorId) throws InvalidFloorCodeException {
        for (Floor floor : this.floors) {
            if (floor.getId() == floorId) {
                return floor;
            }
        }

        throw new InvalidFloorCodeException("Floor " + floorId + " does not exist.");
    }

    public Cell getCell(int x, int y) {
        for (Floor floor : floors) {
            for (Room room : floor.getRooms()) {
                for (Cell cell : room.getCells()) {
                    if (cell.getPoint().equals(new CoordinatePoint(x, y))) {
                        return cell;
                    }
                }
            }
        }

        throw new IllegalArgumentException("Invalid cell coordinates given");
    }

    @Override
    public String toString() {
        return "HomeLayout{" +
                "floors=" + floors +
                '}';
    }
}
