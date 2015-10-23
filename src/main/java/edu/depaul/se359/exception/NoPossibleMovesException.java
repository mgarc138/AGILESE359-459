package edu.depaul.se359.exception;

@SuppressWarnings("serial")
public class NoPossibleMovesException extends Exception {
	public NoPossibleMovesException(String message){
		super(message);
	}
	
	public NoPossibleMovesException(){
		super();
	}
}

