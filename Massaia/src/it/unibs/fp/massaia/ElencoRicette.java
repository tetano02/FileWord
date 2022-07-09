package it.unibs.fp.massaia;

import java.util.ArrayList;

import it.unibs.fp.mylib.InputDati;

public class ElencoRicette {

	private static final String RICETTA_GIUSTA = "Ricetta aggiunta correttamente!";
	private static final String TITOLO = "ELENCO RICETTE";
	private static final String RICHIESTA_AGGIUNTA = "Vuoi aggiungere ingredienti alla ricetta?";
	private static final String INGREDIENTE_NON_TROVATO = "Ingrediente non trovato, impossibile aggiungerlo";
	private static final String ERRORE_AGGIUNTA_QUANTITA = "Impossibile aggiungere la ricetta, non ci sono abbastanza ingredienti";
	private static final String ERRORE_AGGIUNTA_ESISTENZA = "Impossbile aggiungere, ricetta già esistente";
	private static final String RICHIESTA_DESCRIZIONI = "Vuoi aggiungere altre descrizioni alla ricetta?";
	private static final String RICHIESTA_INGREDIENTE_RIMOZIONE = "Inserisci che ricetta rimuovere:";
	private static final String ERRORE_RIMOZIONE = "Impossibile rimuoverlo, ricetta non trovata";
	private static final String RIMOZIONE = "Ricetta rimossa con successo";
	private static final String ERRORE_QUANTITA = "Elenco delle ricette vuoto, riempilo!";
	private static final String SECONDO = "Secondo";
	private static final String PRIMO = "Primo";
	private static final String DECISIONE = "Inserire se il piatto è un primo o un secondo, inserendo 1 o 2:";
	private static final String INPUT_DESCRIZIONE = "Inserisci una nuova descrizione: ";
	
	private ArrayList<Ricetta> elenco=new ArrayList<Ricetta>();

	public boolean isVuoto() {
		if(elenco.size()>0)
			return false;
		return true;
	}
	
	public int cercaRicetta(String nome){
		for(int i=0; i<this.elenco.size(); i++)
			if(this.elenco.get(i).getNome().equalsIgnoreCase(nome))
				return i;
		return -1;
	}
	
	public void nuovaRicetta(ElencoIngredienti elencoIngredienti) {
		
		Ricetta ricetta=creaRicetta(elencoIngredienti);
		
		if(!elencoIngredienti.isVuoto()) {
			if(ricetta!=null) {
				if(ricetta.getListaIngredienti().size()!=0) {
					ricetta.calcolaCalorieTotali();
					aggiungiRicetta(ricetta);
					System.out.println(RICETTA_GIUSTA);
				}else {
					System.out.println(ERRORE_AGGIUNTA_QUANTITA);
				}
			}else {
				System.out.println(ERRORE_AGGIUNTA_ESISTENZA);
			}
		}else {
			System.out.println(ERRORE_AGGIUNTA_QUANTITA);
		}
	}

	public void aggiungiRicetta(Ricetta ricetta) {
		this.elenco.add(ricetta);
	}
	
	public void rimuoviRicetta() {
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
		int indice=cercaRicetta(nome);
		if(indice>=0)
			return indice;
		System.out.println(ERRORE_RIMOZIONE);
		return -1;
	}
	
	public boolean esistenzaPrimo() {
		for(int i=0; i<elenco.size(); i++) {
			if(elenco.get(i).getDescrizione().get(0).equalsIgnoreCase("primo"))
				return true;
		}
		return false;
	}
	
	public boolean esistenzaSecondo() {
		for(int i=0; i<elenco.size(); i++) {
			if(elenco.get(i).getDescrizione().get(0).equalsIgnoreCase("secondo"))
				return true;
		}
		return false;
	}
	
	public Ricetta getInputRicetta() {
		String nome=InputDati.leggiStringaNonVuota("Inserisci una ricetta da cercare: ");
		return getRicetta(nome);
	}
	
	public Ricetta getRicetta(String nome) {
		int indice=cercaRicetta(nome);
		if(indice>=0)
			return elenco.get(indice);
		return null;
	}

	public String getErroreQuantita() {
		return ERRORE_QUANTITA;
	}	
	
	public Ricetta creaRicetta(ElencoIngredienti elencoIngredienti) {
		
		if(elencoIngredienti.isVuoto())
			return null;
		String nome=InputDati.leggiStringaNonVuota("Inserisci il nome:");
		
		if(cercaRicetta(nome)!=-1)
			return null;
		ArrayList<String> descrizione=new ArrayList<String>();
		descrizione.add(primaDescrizione());
		while(InputDati.yesOrNo(RICHIESTA_DESCRIZIONI)){
			descrizione.add(InputDati.leggiStringaNonVuota(INPUT_DESCRIZIONE));
		}
		
		ArrayList<Ingrediente> ingredientiRicetta=new ArrayList<Ingrediente>();
		do {
			Ingrediente ing=elencoIngredienti.getInputIngrediente();
			if(ing!=null)
				ingredientiRicetta.add(ing);
			else
				System.out.println(INGREDIENTE_NON_TROVATO);
		}while(InputDati.yesOrNo(RICHIESTA_AGGIUNTA));
		
		return new Ricetta(nome,descrizione,ingredientiRicetta);
	}
	
	
	/**
	 * Metodo che modifica il primo dato della descrizione indicando se esso è un primo o un secondo
	 */
	public String primaDescrizione() {
		int scelta=InputDati.leggiIntero(DECISIONE,1,2);
		if(scelta==1)
			return PRIMO;
		else
			return SECONDO;
	}
	
	
	@Override
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
