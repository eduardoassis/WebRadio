package controllers;

import exceptions.WebRadioExceptionHandler;
import play.data.validation.Error;
import play.mvc.Controller;

public class DefaultController extends Controller{

	protected static WebRadioExceptionHandler exceptionHandler = new WebRadioExceptionHandler();
	
	protected static void returnIfNull(Object model) {
		if(model == null) {
			renderError("O parâmetro passado não é válido.");
		}
	}
	
	protected static void returnIfNull(Object model, Object ... models) {
		if(model == null) {
			renderError("O id informado não foi encontrado.");
		}
		
		if(models != null && models.length > 0) {
			for (int i = 0; i < models.length; i++) {
				
				if(models[i] == null) {
					renderError("O id informado não foi encontrado.");
				}
			}
		}
	}
	
	protected static void returnIfNotFound(Object model, Object ... models) {
		returnIfNull(model, models);
	}
	
	protected static void renderError(String ... messages) {

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < messages.length; i++) {

			sb.append(messages[i]);

			if (i != messages.length - 1) {
				sb.append(";");
			}
		}

		error(sb.toString());
	}

}
