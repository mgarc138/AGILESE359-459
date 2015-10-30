package edu.depaul.se359;

import edu.depaul.se359.model.*;
import edu.depaul.se359.service.LayoutParser;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

public final class Simulation {
    private static Logger logger = Logger.getLogger("Simulation");

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
                            logger.info("Found charge station: " + chargeStation.toString());
                        }
                    }
                }
            }

            
            CleanSweep cleanSweep = new CleanSweep(chargeStation);
            cleanSweep.cleanHome();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
		 

}
