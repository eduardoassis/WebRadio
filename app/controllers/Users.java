package controllers;

import java.util.List;

import play.mvc.Before;
import play.mvc.With;
import models.Message;
import models.MessageType;
import models.User;

public class Users extends DefaultController{

	@Before(unless = {"create", "list"})
	private static void authenticate(){
		WebRadioSecure.authenticate();
	}
	
	public static void list(){
		List<User> users = User.findAll();
		
		if( users == null || users.size() <=0 ) {
			renderJSON(new Message(MessageType.ERROR, "Nenhum usuário cadastrado no sistema."));
		}
		
		renderJSON(users);
	}
	
	public static void getLogged(){
		User user = WebRadioSecure.getUserAuthenticated();
		returnIfNull(user);
		renderJSON(User.findById(user.id));
	}
	
	public static void create(User user){
		user.email = request.params.get("email");
		returnIfNull(user);
		returnIfNull(user.email);
		returnIfNull(user.name);
		returnIfNull(user.password);
		
		user.save();
		renderJSON(new Message(MessageType.SUCCESS, "Usuário cadastrado com sucesso."));
	}
	
	public static void delete(Long id){
		
		returnIfNull(id);
		
		User user = User.findById(id);
		
		if (user == null) {
			renderJSON(new Message(MessageType.ERROR, "Usuário não existente."));
		} else {
			user.delete();
			renderJSON(new Message(MessageType.SUCCESS, "Usuário cadastrado com sucesso."));
		}
	}
}