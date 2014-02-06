package exceptions;

import models.Message;
import models.MessageType;
import play.Logger;

public class WebRadioExceptionHandler {

	public static final String DEFAULT_MESSAGE = "A operação não pôde ser efetuada, verifique sua conexão e tente novamente.";
	
	public Message handle(Exception exception){
		
		String message = getMessage(exception);
		Logger.error(exception, message);
		
		return new Message(MessageType.ERROR, message);
	}
	
	public String getMessage(Exception exception) {
		return (exception instanceof WebRadioException) ? exception.getMessage() : DEFAULT_MESSAGE;
	}
}
