package learning.springboot.orders.exception;

public class CutomerAlreadyExistsException extends Exception{
	
	
	public CutomerAlreadyExistsException(String message){
		super(message);
	}

}
