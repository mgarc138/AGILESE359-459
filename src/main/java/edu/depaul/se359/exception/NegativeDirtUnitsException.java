package edu.depaul.se359.exception;

public class NegativeDirtUnitsException extends Exception {
	public NegativeDirtUnitsException(String message){
		super(message);
	}

	public NegativeDirtUnitsException(){
		super();
	}
}

