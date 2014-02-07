package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Music extends Model{

	public String nome;
	public String artista;
	public String album;
	public String path;
	
	public static Music getMusic(String filtro) {
		
		filtro = "%" + filtro + "%";
		
		Music music = Music.find("UPPER(nome) LIKE UPPER(:filtro) OR "
							+ "UPPER(artista) LIKE UPPER(:filtro) OR "
							+ "UPPER(album) LIKE UPPER(:filtro)")
							.setParameter("filtro", filtro).first();
		
		return music;
	}
}
