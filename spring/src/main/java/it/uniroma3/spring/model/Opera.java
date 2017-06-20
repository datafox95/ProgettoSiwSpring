package it.uniroma3.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "opera")
public class Opera{
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1)
	private String titolo; //nome dell'opera
	
	@NotNull
	@Size(min=1)
	private String tecnica; //tecnica di realizzazione dell'opera
	
	@NotNull
	private Integer lunghezza; //lunghezza del dipinto 
	
	@NotNull
	private Integer larghezza; //larghezza del dipinto
	
	@NotNull
	@Min(1)
	private Integer anno; //anno di realizzazione dell'opera
	
	//politica di cascade: ogni operazione sull'opera aggiorna lo stato dell'artista
	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	private Artista artista;
	
	@NotNull
	@ManyToOne(optional=true)
	private Stanza stanza; //stanza in cui l'opera è esposta
	
	@NotNull
	private String UrlImmagine; //indirizzo url dell'immagine rappresentante l'opera
	
	/*costruttore vuoto */
	public Opera(){}
	
	
	/* costruttore*/
	public Opera(String titolo, String tecnica, Integer lunghezza, Integer larghezza, Integer anno, Artista artista, Stanza stanza, String UrlImmagine) {
		super();
		this.titolo = titolo;
		this.tecnica = tecnica;
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.anno = anno;
		this.artista = artista;
		this.stanza = stanza;
		this.UrlImmagine = UrlImmagine;
	}
	

	/*Getters and setters*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}


	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Stanza getStanza() {
		return stanza;
	}

	public void setStanza(Stanza stanza) {
		this.stanza = stanza;
	}

	public String getUrlImmagine() {
		return UrlImmagine;
	}

	public void setUrlImmagine(String UrlImmagine) {
		this.UrlImmagine = UrlImmagine;
	}

	@Override
	public String toString() {
		return String.format(
                "Opera[id=%d, titolo='%s', tecnica='%s', anno=%d]",
                id, titolo, tecnica , anno);
	}

	public Integer getLunghezza() {
		return lunghezza;
	}

	public void setLunghezza(Integer lunghezza) {
		this.lunghezza = lunghezza;
	}

	public Integer getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(Integer larghezza) {
		this.larghezza = larghezza;
	}



}
