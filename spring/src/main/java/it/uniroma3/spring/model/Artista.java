package it.uniroma3.spring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "artista")
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String nome;
	
	@NotNull
	@Size(min=1)
	private String cognome;
	
	@NotNull
	@Size(min=1)
	private String nazione;
	
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	
	@Past
	@Temporal(TemporalType.DATE)
	private Date dataMorte;
	
	
	
	
	
	
	@OneToMany(mappedBy ="artista" , cascade = CascadeType.REMOVE)
	private List<Opera> opere;
	
	@ManyToOne
	private Stanza stanza;
	
	
	public Artista(){}
	
	public Artista(String nome, String cognome, String nazione, Date dataNascita, Date dataMorte, List<Opera> opere, Stanza stanza){
		this.nome = nome;
		this.cognome = cognome;
		this.nazione = nazione;
		this.dataNascita = dataNascita;
		this.opere = new ArrayList<>();
		this.stanza = stanza;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
	
	
	
	
	
	
	
	
	
	

}
