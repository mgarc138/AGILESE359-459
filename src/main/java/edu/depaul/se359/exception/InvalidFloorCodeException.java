package edu.depaul.se359.exception;

@SuppressWarnings("serial")
public class InvalidFloorCodeException extends Exception {
	public InvalidFloorCodeException(String message){
		super(message);
	}
	
	public InvalidFloorCodeException(){
		super();
	}
}
