package secure;

import models.User;
import play.mvc.Http.Request;

public class AuthenticationService {

	public User signIn(Request request){
		String email = request.params.get("username");
		String password = request.params.get("password");
		
		User user = User.find("byEmailAndPassword", email, password).first();

		if(user != null){
			return user;
		}
		
		return null;
	}
}

