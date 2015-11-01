package edu.depaul.se359.exception;

public class FullCapacityException extends Exception {
	public FullCapacityException(String message){
		super(message);
	}

	public FullCapacityException(){
		super();
	}
}

