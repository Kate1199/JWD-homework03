package by.epam.kisel.task01.exception;

public class EmptyArrayException extends Exception {
	public EmptyArrayException() {
		super();
	}
	
	public EmptyArrayException(String message) {
		super(message);
	}
	
	public EmptyArrayException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EmptyArrayException(Throwable cause) {
		super(cause);
	}
}
