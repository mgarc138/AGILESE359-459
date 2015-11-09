package edu.depaul.se359.sensor;

import java.io.FileNotFoundException;

import junit.framework.TestCase;
import edu.depaul.se359.model.Cell;
import edu.depaul.se359.model.CleanSweep;
import edu.depaul.se359.service.LayoutParser;
import edu.depaul.se359.model.HomeLayoutPlanMap;

import org.junit.Test;

public class CleanSweepTest extends TestCase {

	private HomeLayoutPlanMap layouts;
	
	@Test
    public void testCleanSweep() throws Exception {
		
		 try {
			 
			 layouts = LayoutParser.parseHomeLayout("./FloorPlans/FloorPlanLayoutHome2.json");
			 
			 int xPosition = 0, yPosition = 0, rightPath = 4, leftPath = 4, upPath = 4, downPath = 4;
				
			 Cell chargeStation = new Cell(xPosition, yPosition, rightPath, leftPath, upPath, downPath, false, 2, 1);
			 
			CleanSweep cleanSweep = new CleanSweep(chargeStation, layouts.getHomeLayout());
			
			assertTrue(0 == cleanSweep.getCurrentPosition().getX());
			assertTrue(0 == cleanSweep.getCurrentPosition().getY());
			 
		 }
		 catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
		 		 	 
	}
	
		
}
