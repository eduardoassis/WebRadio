package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import models.Music;
import play.mvc.Http;
import play.mvc.With;

@With(WebRadioSecure.class)
public class Musics extends DefaultController {

	public static void list(){
		List<Music> musics = Music.findAll();
		renderJSON(musics);
	}
	
	public static void getUrlMusic(Long id) {
		
		Music musica = Music.findById(id);
		renderJSON(musica.path);
	}
	
	public static void getMusic(String filtro) {
		
		returnIfNull(filtro);
		
		List<Music> musics= Music.getMusic(filtro);
		renderJSON(musics);
	}
	
	public static void getMusicById(Long id) {
		
		Music musica = Music.findById(id);
		renderJSON(musica);
	}
	
	public static void getMusicMp3(Long id){
		
		Music music = Music.findById(id);
		
		returnIfNull(music);
		
		File file = new File(music.path);
		
		try {
			InputStream inputStream = new FileInputStream(file);
			response.current().contentType = "audio/mpeg";
			response.status = 200;
			renderBinary(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(Exception exception){
			exception.printStackTrace();
		}
		
		
	}
}
