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
    
    public static void playList(){
    	render();
    }
    
    public static void musicas(){
    	render();
    }
    
    public static void contato(){
    	render();
    }
    
    public static void angular(){
    	render();
    }
}