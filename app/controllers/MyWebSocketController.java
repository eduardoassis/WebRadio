package controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import play.mvc.WebSocketController;

public class MyWebSocketController extends WebSocketController{

	public static void hello(String name){
		
		String path = "/home/eduardo/Música/Roupa Nova - Anjo.mp3";
		
		try {
			
			System.out.println(request.host);
			
			File file = new File(path);
			
			BufferedInputStream bufferedInputStream = new BufferedInputStream( new FileInputStream( file ) );
			
			int len = 0;    
		    byte[] buffer =new byte[12408];            
		                
		        
		    System.out.println("Iniciando a transferencia do arquivo");  
		      
		    //contar o tempo da transfericia 
		    
		    
		    request.current().contentType = "audio/mpeg";
		    
		    while ((len = bufferedInputStream.read(buffer)) > 0) {
		    	outbound.send("t", buffer);
		    }
		    
		}catch( FileNotFoundException fileNotFoundException ) {
			
		} catch (IOException ioException) {
			
		}
	}
}
