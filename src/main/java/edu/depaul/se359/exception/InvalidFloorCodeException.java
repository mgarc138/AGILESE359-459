package edu.depaul.se359.exception;

public class InvalidFloorCodeException extends Exception {
	public InvalidFloorCodeException(String message){
		super(message);
	}
	
	public InvalidFloorCodeException(){
		super();
	}
}
