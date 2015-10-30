package edu.depaul.se359;

import edu.depaul.se359.exception.InvalidFloorCodeException;
import edu.depaul.se359.exception.InvalidRoomCodeException;
import edu.depaul.se359.model.*;
import edu.depaul.se359.service.LayoutParser;

import java.io.FileNotFoundException;
import java.util.logging.Level;

public final class Simulation {

    private Simulation(){
		
	}


    public static void main(String[] args) {

        try {
            HomeLayoutPlanMap layouts = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");
            Cell chargeStation = null;
            // Get the charge station
            for (Floor floor : layouts.getHomeLayout().getFloors()) {
                for (Room room : floor.getRooms()) {
                    for (Cell cell : room.getCells()) {
                        if (cell.CheckisaChargingStation()) {
                            chargeStation = cell;
                            LogFile.getInstance().writeLogFile(Level.INFO, "Charge station was found!");
                        }
                    }
                }
            }

            
            CleanSweep cleanSweep = new CleanSweep(chargeStation);
            cleanSweep.cleanHome(layouts.getHomeLayout());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFloorCodeException e) {
            e.printStackTrace();
        } catch (InvalidRoomCodeException e) {
            e.printStackTrace();
        }
    }
		 

}
