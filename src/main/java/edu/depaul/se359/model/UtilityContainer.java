package edu.depaul.se359.model;

public class UtilityContainer {
	
	private static final int SWEEEP_DIRT_MAXCAPACITY = 50;
	private int SweepCurrentDirt;
	private boolean EmptyMeLight;
	
	public UtilityContainer(){
		
		// when the container is been istatiated in the object it means that 
		// that the sweep contains a clean container bag
		emptyMeBag();
		setEmptyMeLight(false);	
	}
	
	public void emptyMeBag(){
		
		this.SweepCurrentDirt = 0;
		setEmptyMeLight(false);	
	}
		
	private void setEmptyMeLight(boolean SetLightState){
		
		this.EmptyMeLight = SetLightState;
		
	}
	
	public int getSweepCurrentDirt(){
		
		return this.SweepCurrentDirt;
	}
	
	public boolean emptyMeLightIsOn(){
		
		return this.EmptyMeLight;
	}
	

}
