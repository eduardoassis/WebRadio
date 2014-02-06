package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class PlayList extends Model{

	public String nome;
	
	@ManyToMany
	public List<Music> musicas;
	
	@ManyToOne
	public User usuario;
}
