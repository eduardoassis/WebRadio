package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import models.Message;
import models.MessageType;
import models.User;
import play.Play;
import play.cache.Cache;
import play.mvc.Before;
import secure.AuthenticationService;

public class WebRadioSecure extends Secure.Security{

	private static HashMap<Long, ArrayList<String>> hashSessionsIds = new HashMap<Long, ArrayList<String>>();
	
	@Before(unless = {"signIn", "signOut"})
	public static void authenticate() {
		
		if(Cache.get(session.getId()) == null) {
			renderJSON(new Message(MessageType.UNAUTHORIZED, "Usuário não autenticado."));
		}
	}
	
	public static void signIn() {

		User user = new AuthenticationService().signIn(request);
		
		if( user != null ){
			Cache.set(session.getId(), user);
			ArrayList<String> sessionsIds = hashSessionsIds.get(user.id);
			
			if(sessionsIds == null) {
				sessionsIds = new ArrayList<String>();
			}
			
			sessionsIds.add(session.getId());
			
			hashSessionsIds.put(user.id, sessionsIds);
			
			redirect(Play.configuration.getProperty("webradio.authentication.url.success"));
		} else {
			redirect(Play.configuration.getProperty("webradio.authentication.url.error"));
		}
	}
	
	public static void signOut(Long idUser){

		ArrayList<String> sessionsIds = hashSessionsIds.get(idUser);
		
		if( sessionsIds != null ){
			
			for (String sessionId : sessionsIds) {
				Cache.delete(sessionId);
			}
			
			hashSessionsIds.remove(idUser);
		}
		renderJSON(new Message(MessageType.SUCCESS, "Logout efetuado com sucesso."));
	}
}
