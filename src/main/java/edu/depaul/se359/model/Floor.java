package edu.depaul.se359.model;

import edu.depaul.se359.exception.InvalidRoomCodeException;

import java.util.ArrayList;

/**
 * Created by eric on 10/29/15.
 */
public class Floor {
    private int id;
    private ArrayList<Room> rooms;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets all of the rooms in the current Floor
     *
     * @return
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoom(String roomId) throws InvalidRoomCodeException {
        for (Room room : this.rooms) {
            if (room.getId().equals(roomId)) {
                return room;
            }
        }

        throw new InvalidRoomCodeException("Room " + roomId + " does not exist");
    }

    @Override
    public String toString() {
        return "Floor{" +
                "id=" + id +
                ", rooms=" + rooms +
                '}';
    }
}
