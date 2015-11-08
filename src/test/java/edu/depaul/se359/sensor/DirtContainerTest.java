package edu.depaul.se359.sensor;


import edu.depaul.se359.exception.FullCapacityException;
import edu.depaul.se359.exception.NegativeDirtUnitsException;
import edu.depaul.se359.model.DirtContainer;
import junit.framework.TestCase;


import org.junit.Test;


public class DirtContainerTest extends TestCase  {
	
	
	
	
	@Test
    public void testSweepDirtCapacity() throws Exception {
				
		DirtContainer SweepVacuum = new DirtContainer();
		
		assertTrue(50 == SweepVacuum.getMaxCapacity());
		 		 	 
	}
	
	@Test
    public void test1CurrentSweepDirtCollected() throws Exception {
	
		DirtContainer SweepVacuum = new DirtContainer();
		
		assertTrue(0 == SweepVacuum.getSweepCurrentDirt());
		
	}
	
	
	
	
	
	
	@Test
    public void test2CurrentSweepDirtCollected() throws Exception {
	
		DirtContainer SweepVacuum = new DirtContainer();
		
		assertTrue(0 == SweepVacuum.getSweepCurrentDirt());
		
		SweepVacuum.addDirt(30);
		
		assertTrue(30 == SweepVacuum.getSweepCurrentDirt());
		
		SweepVacuum.addDirt(10);
		
		assertTrue(40 == SweepVacuum.getSweepCurrentDirt());
		
		
	}
	
	
	@Test
    public void testLight() throws Exception{
	
		DirtContainer SweepVacuum = new DirtContainer();
		SweepVacuum.addDirt(30);
		
		assertTrue(false == SweepVacuum.emptyMeLightIsOn());
		SweepVacuum.setEmptyMeLight(true);
		assertTrue(true == SweepVacuum.emptyMeLightIsOn());
					
	}
	
	
	@Test
    public void testEmptyLight() throws Exception{
	
		DirtContainer SweepVacuum = new DirtContainer();
		SweepVacuum.addDirt(30);
		assertTrue(30 == SweepVacuum.getSweepCurrentDirt());
		
		assertTrue(false == SweepVacuum.emptyMeLightIsOn());
		SweepVacuum.setEmptyMeLight(true);
		assertTrue(true == SweepVacuum.emptyMeLightIsOn());
		SweepVacuum.emptyMeBag();
		
		// final test of everything is been empty from the Vacuum Bag
		assertTrue(0 == SweepVacuum.getSweepCurrentDirt());
		
		
					
	}
	
	
	
	@Test(expected = FullCapacityException.class)
	public void test3CurrentSweepDirtCollected() throws FullCapacityException, NegativeDirtUnitsException{
	
		DirtContainer SweepVacuum = new DirtContainer();
		SweepVacuum.addDirt(30);
		SweepVacuum.addDirt(40);
		
			
	}
	
	

}
