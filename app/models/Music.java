package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Music extends Model{

	public String nome;
	public String artista;
	public String album;
	public String path;
}
