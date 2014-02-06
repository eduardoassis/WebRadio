package exceptions;

public class WebRadioException extends RuntimeException{

	public WebRadioException() {
	}

	public WebRadioException(String message) {
		super(message);
	}
	
	public WebRadioException(Throwable cause) {
		super(cause);
	}
	
	public WebRadioException(String message, Throwable cause) {
		super(message, cause);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
