package edu.depaul.se359.model;

import edu.depaul.se359.exception.FullCapacityException;
import edu.depaul.se359.exception.NegativeDirtUnitsException;

public class DirtContainer {

    private static final int SWEEP_DIRT_MAXCAPACITY = 50;
    private int sweepCurrentDirt;
    private boolean EmptyMeLight;

    public DirtContainer() {

        // when the container is been instantiated in the object it means that
        // that the sweep contains a clean container bag
        emptyMeBag();
        setEmptyMeLight(false);
    }

    public void emptyMeBag() {

        this.sweepCurrentDirt = 0;
        setEmptyMeLight(false);
    }

    public void setEmptyMeLight(boolean SetLightState) {

        this.EmptyMeLight = SetLightState;

    }

    public int getSweepCurrentDirt() {

        return this.sweepCurrentDirt;
    }

    public boolean emptyMeLightIsOn() {

        return this.EmptyMeLight;
    }
    
    /**
     * Adds to the container of dirt.
     * @param value
     * @throws NegativeDirtUnitsException 
     * @throws FullCapacityException 
     */
    public void addDirt(int value) throws NegativeDirtUnitsException, FullCapacityException{
    	if (value <= 0 || value > 50){
    		throw new NegativeDirtUnitsException("Invalid value!");
    	}
    	if ((sweepCurrentDirt + value) > SWEEP_DIRT_MAXCAPACITY){
    		throw new FullCapacityException("I'm full!");
    	}
    	sweepCurrentDirt += value;
    }


}
