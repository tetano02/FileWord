package it.unibs.fp.aziendasanitaria;

public class Paziente {

	private String nome;
	private String cognome;
	private int tesseraSanitaria;
	
	public Paziente(String nome,String cognome,int tesseraSanitaria) {
		this.nome=nome;
		this.cognome=cognome;
		this.tesseraSanitaria=tesseraSanitaria;
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
	public int getTesseraSanitaria() {
		return tesseraSanitaria;
	}
	public void setTesseraSanitaria(int tesseraSanitaria) {
		this.tesseraSanitaria = tesseraSanitaria;
	}
	
	
}
