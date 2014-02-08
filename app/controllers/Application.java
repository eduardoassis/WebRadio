package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(WebRadioSecure.class)
public class Application extends Controller {

	public static void login(){
		render();
	}
	
    public static void index() {
        render();
    }
}