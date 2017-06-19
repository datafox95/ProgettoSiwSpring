package it.uniroma3.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=5)
	private String username; //username dell'utente
	
	@NotNull
	@Size(min=1)
	private String password; //password dell'utente
	
	@OneToOne
	private RuoloAdmin ruolo;
	
	
	/*costruttore vuoto*/
	public Admin (){}
	
	/*costruttore*/
	public Admin(String username, String password){
		this.ruolo = new RuoloAdmin(username);
		this.username = username;
		this.password = password;
	}
	
	/*Getters and setters*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RuoloAdmin getRuolo() {
		return ruolo;
	}

	public void setRuolo(RuoloAdmin ruolo) {
		this.ruolo = ruolo;
	}
	
	

	

}
