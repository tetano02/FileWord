package it.unibs.fp.aziendasanitaria;

import java.util.ArrayList;

public class AziendaSanitaria {

	private static final String TESSERA = "Numero tessera sanitaria: ";
	private static final String PAZIENTE = "PAZIENTE";
	private static final String NESSUN_PAZIENTE = "Paziente non trovato, codice invalido";
	private static final String NESSUN_MEDICO = "IMPOSSIBILE TROVARE IL MEDICO";
	private static final String NESSUN_RISULTATO = "Nessun medico è a riposo il ";
	private static final String MEDICI_A_RIPOSO = "LISTA DEI MEDICI AVENTI COME GIORNO DI RIPOSO IL ";
	private static final String MEDICO = "MEDICO";
	private static final String CODICE = "Codice univoco: ";
	private static final String COGNOME = "Cognome: ";
	private static final String NOME = "Nome: ";
	private static final String TITOLO = "INFORMAZIONI MEDICO";
	private String nome;
	private String descrizione;
	private ArrayList<Medico> elencoMedici=new ArrayList<Medico>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public ArrayList<Medico> getElencoMedici() {
		return elencoMedici;
	}
	public void setElencoMedici(ArrayList<Medico> elencoMedici) {
		this.elencoMedici = elencoMedici;
	}

	/**
	 * Metodo che permette l'aggiunta di un medico nell'elenco dei medici dell'azienda sanitaria
	 * @param medico
	 */
	public void aggiungiMedico(Medico medico) {
		this.elencoMedici.add(medico);
	}
	
	public void stampaElencoMedici() {
		System.out.println(TITOLO);
		for(int i=0; i<elencoMedici.size(); i++) {
			System.out.println(NOME+elencoMedici.get(i).getNome());
			System.out.println(COGNOME+elencoMedici.get(i).getCognome());
			System.out.println(CODICE+elencoMedici.get(i).getCodiceUnivoco());
		}
	}
	/**
	 * Metodo che permette di cercare un medico tramite codice nell'elenco dei medici dell'azienda sanitaria
	 * @param codice
	 * @return
	 */
	public Medico ricercaMedico(String codice) {
		for(int i=0; i<elencoMedici.size(); i++)
			if(elencoMedici.get(i).getCodiceUnivoco().equals(codice))
				return elencoMedici.get(i);
		return null;
	}
	/**
	 * Stampa le informazioni riguardanti un medico
	 * @param codice
	 */
	public void stampaMedico(String codice) {
		Medico medico=ricercaMedico(codice);
		if(medico==null) {
			System.out.println(NESSUN_MEDICO);
			return;
		}
		System.out.println(TITOLO);
		System.out.println(NOME+medico.getNome());
		System.out.println(COGNOME+medico.getCognome());
		System.out.println(CODICE+medico.getCodiceUnivoco());
		medico.stampaPazienti();
	}
	
	/**
	 * Metodo che stampa i medici a riposo durante un determinato giorno della settimana
	 * @param codice
	 * @return
	 */
	public void ricercaMedico(Settimana giorno) {
		System.out.println(MEDICI_A_RIPOSO+giorno.name());
		boolean trovato=false;
		for(int i=0; i<elencoMedici.size(); i++)
			if(elencoMedici.get(i).getGiornoDiRiposo().equals(giorno)) {
				trovato=true;
				System.out.println(MEDICO);
				System.out.println(NOME+elencoMedici.get(i).getNome());
				System.out.println(COGNOME+elencoMedici.get(i).getCognome());
				System.out.println(CODICE+elencoMedici.get(i).getCodiceUnivoco());
			}
		if(!trovato)
			System.out.println(NESSUN_RISULTATO+giorno.name());
	}
	
	/**
	 * Trova il medico associato al paziente cercato
	 * @param num
	 * @return
	 */
	public int trovaMedicoPaziente(int num) {
		int indice=-1;
		for(int i=0; i<elencoMedici.size(); i++) {
			indice=elencoMedici.get(i).trovaPaziente(num);
			if(indice!=-1)
				return i;
		}
		return -1;
	}
	
	/**
	 * Stampa dati del paziente e del suo medico
	 * @param num
	 */
	public void trovaPaziente(int num) {
		int indiceMedico=trovaMedicoPaziente(num);
		int indicePaziente=-1;
		try{
			indicePaziente=elencoMedici.get(indiceMedico).trovaPaziente(num);
		}catch(Exception e) {
			System.out.println(NESSUN_PAZIENTE);
			return;
		}
		System.out.println(PAZIENTE);
		System.out.println(NOME+elencoMedici.get(indiceMedico).getPaziente(indicePaziente).getNome());
		System.out.println(COGNOME+elencoMedici.get(indiceMedico).getPaziente(indicePaziente).getCognome());
		System.out.println(TESSERA+elencoMedici.get(indiceMedico).getPaziente(indicePaziente).getTesseraSanitaria());
		System.out.println(MEDICO);
		System.out.println(NOME+elencoMedici.get(indiceMedico).getNome());
		System.out.println(COGNOME+elencoMedici.get(indiceMedico).getCognome());
		System.out.println(CODICE+elencoMedici.get(indiceMedico).getCodiceUnivoco());
	}
	
	public void cambiaMedico(int tessera, String codice) {
		int indice=0;
		try {
		indice=elencoMedici.get(trovaMedicoPaziente(tessera)).trovaPaziente(tessera);
		}catch(Exception e) {
			System.out.println("Paziente non trovato");
			return;
		}
		//è sufficiente il try solo all'inizio perchè se il paziente viene trovato il resto viene da sè
		Paziente p=elencoMedici.get(trovaMedicoPaziente(tessera)).getPaziente(indice);
		elencoMedici.get(trovaMedicoPaziente(tessera)).rimuoviPaziente(indice);
		ricercaMedico(codice).aggiungiPaziente(p);
	}
	
}
