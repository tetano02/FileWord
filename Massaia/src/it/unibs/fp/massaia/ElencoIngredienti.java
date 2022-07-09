package it.unibs.fp.massaia;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class ElencoIngredienti {

	private static final String RICHIESTA_INGREDIENTE = "Inserisci che ingrediente vuoi:";

	private static final String RIMOZIONE = "Ingrediente rimosso con successo";

	private static final String ERRORE_QUANTITA = "Elenco degli ingredienti vuoto, riempilo!";

	private static final String RICHIESTA_INGREDIENTE_RIMOZIONE = "Inserisci che ingrediente rimuovere:";

	private static final int MINIMO_CALORIE = 0;
	
	private static final String TITOLO = "ELENCO INGREDIENTI";
	private static final String ERRORE_RIMOZIONE = "Impossibile rimuoverlo, ingrediente non trovato";
	private static final String ERRORE_AGGIUNTA = "Impossibile aggiungere all'elenco, ingrediente già esistente";
	private static final String RICHIESTA_CALORIE = "Inserisci il numero di calorie:";
	private static final String RICHIESTA_NOME = "Inserisci il nome dell'ingrediente:";
	
	private ArrayList<Ingrediente> elenco=new ArrayList<Ingrediente>();
	
	
	public int cercaIngrediente(String nome){
		for(int i=0; i<this.elenco.size(); i++)
			if(this.elenco.get(i).getNome().equalsIgnoreCase(nome))
				return i;
		return -1;
	}
	
	public void aggiungiIngrediente() {
		Ingrediente ingrediente=creaIngrediente();
		if(verificaPossibileAggiunta(ingrediente.getNome()))
			this.elenco.add(ingrediente);
	}
	
	public boolean verificaPossibileAggiunta(String nome) {
		if(cercaIngrediente(nome)==-1)
			return true;
		System.out.println(ERRORE_AGGIUNTA);
		return false;
	}
	
	public void rimuoviIngrediente() {
		if(!isVuoto()) {
			String nome=InputDati.leggiStringaNonVuota(RICHIESTA_INGREDIENTE_RIMOZIONE);
			int index=verificaPossibileRimozione(nome);
			if(index>=0) {
				this.elenco.remove(index);
				System.out.println(RIMOZIONE);
			}
		}else {
			System.out.println(ERRORE_QUANTITA);
		}
	}
	
	public int verificaPossibileRimozione(String nome) {
		int indice=cercaIngrediente(nome);
		if(indice>=0)
			return indice;
		System.out.println(ERRORE_RIMOZIONE);
		return -1;
	}
	
	public boolean isVuoto() {
		if(elenco.size()>0)
			return false;
		return true;
	}

	public Ingrediente getInputIngrediente() {
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_INGREDIENTE);
		return getIngrediente(nome);
	}
	
	public Ingrediente getIngrediente(String nome) {
		int indice=cercaIngrediente(nome);
		if(indice>=0)
			return elenco.get(indice);
		return null;
	}	
	
	public Ingrediente creaIngrediente() {
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_NOME);
		int calorie=InputDati.leggiInteroConMinimo(RICHIESTA_CALORIE,MINIMO_CALORIE);
		return new Ingrediente(nome,calorie);
	}

	public String getErroreQuantita() {
		return ERRORE_QUANTITA;
	}
	
	public String toString() {
		StringBuffer str=new StringBuffer(TITOLO);
		if(!isVuoto()) {
		for(int i=0; i<this.elenco.size(); i++)
			str.append("\n- "+this.elenco.get(i).getNome());
		}else {
			str.append("\n"+ERRORE_QUANTITA);
		}
		return str.toString();
	}
	
	
}
