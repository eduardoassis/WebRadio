package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

	@Before(unless = {"cadastroUsuario", "signIn"})
	private static void authenticate(){
		WebRadioSecure.authenticate();
	}
	
    public static void index() {
        render();
    }
    
    public static void cadastroUsuario(){
    	render();
    }
    
    public static void signIn(){
    	render();
    }
}