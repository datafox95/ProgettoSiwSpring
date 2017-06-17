package it.uniroma3.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ruoli_utente")
public class RuoloUtente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name="ruolo")
	private String ruolo;

	@NotNull
	@Column(name="nome utente")
	private String nome;

	public RuoloUtente(){
		this.ruolo = "ROLE_USER";
	}

	public RuoloUtente(String nome){
		this.nome = nome;
		this.ruolo = "ROLE_USER";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}




}
