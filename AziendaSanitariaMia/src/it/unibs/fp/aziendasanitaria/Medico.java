package it.unibs.fp.aziendasanitaria;

import java.util.ArrayList;

public class Medico {

	private static final String NESSUN_PAZIENTE = "Nessun paziente attualmente";
	private static final String TRATTINO = "-";
	private static final String SPAZIO = " ";
	private static final String LISTA = "LISTA DI PAZIENTI DEL MEDICO:";
	private String nome;
	private String cognome;
	private String codiceUnivoco;
	private Settimana giornoDiRiposo;
	private ArrayList<Paziente> elencoPazienti=new ArrayList<Paziente>();
	
	public Medico(String nome,String cognome,String codice,Settimana giorno) {
		this.nome=nome;
		this.cognome=cognome;
		this.codiceUnivoco=codice;
		this.giornoDiRiposo=giorno;
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
	public String getCodiceUnivoco() {
		return codiceUnivoco;
	}
	public void setCodiceUnivoco(String codiceUnivoco) {
		this.codiceUnivoco = codiceUnivoco;
	}
	public Settimana getGiornoDiRiposo() {
		return giornoDiRiposo;
	}
	public void setGiornoDiRiposo(Settimana giornoDiRiposo) {
		this.giornoDiRiposo = giornoDiRiposo;
	}
	public ArrayList<Paziente> getElencoPazienti() {
		return elencoPazienti;
	}
	public void aggiungiPaziente(Paziente paziente) {
		this.elencoPazienti.add(paziente);
	}
	
	/**
	 * Stampa la lista dei pazienti di un medico
	 */
	public void stampaPazienti() {
		System.out.println(LISTA);
		if(elencoPazienti.size()==0)
			System.out.println(NESSUN_PAZIENTE);
		for(int i=0; i<elencoPazienti.size(); i++)
			System.out.println(TRATTINO+elencoPazienti.get(i).getNome()+SPAZIO+elencoPazienti.get(i).getCognome());
	}
	
	public int trovaPaziente(int num) {
		for(int i=0; i<elencoPazienti.size(); i++) {
			if(elencoPazienti.get(i).getTesseraSanitaria()==num)
				return i;
		}
		return -1;
	}
	
	public Paziente getPaziente(int indice) {
		return elencoPazienti.get(indice);
	}
	
	public void rimuoviPaziente(int indice) {
		if(indice>=0)
			elencoPazienti.remove(indice);
	}
	
}
