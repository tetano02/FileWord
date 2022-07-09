package it.unibs.fp.massaia;

import it.unibs.fp.mylib.InputDati;

public class Menu {

	private static final String SECONDO = "Impossibile comporre il menu, aggiungi un secondo alle ricette!";
	private static final String PRIMO = "Impossibile comporre il menu, aggiungi un primo alle ricette!";
	private Ricetta primo;
	private Ricetta secondo;
	private int calorieMassime;
	
	public void costruisciMenu(ElencoRicette elenco) {
		if(!elenco.isVuoto()) {
			this.inputCalorieMassime();
			if(elenco.esistenzaPrimo() && elenco.esistenzaSecondo()) {
				this.primo=elenco.getInputRicetta();
				this.secondo=elenco.getInputRicetta();
				if(this.primo==null || this.secondo==null) {
					System.out.println("Una o più ricette non trovate, impossibile creare il menu");
					return;
				}
				if(this.primo.getDescrizione().get(0).equalsIgnoreCase("primo") && this.secondo.getDescrizione().get(0).equalsIgnoreCase("secondo")) {
					if(calcoloCalorie()<=this.calorieMassime)
						System.out.println("Menu corretto, buon appetito");
					else
						System.out.println("Menu ipercalorico, non adatto");
				}else {
					System.out.println("Inserire in ordine un primo e un secondo!");
				}
			}else if(!elenco.esistenzaPrimo()){
				System.out.println(PRIMO);
			}else {
				System.out.println(SECONDO);
			}
		}else {
			System.out.println(elenco.getErroreQuantita());
		}
	}
	
	public int calcoloCalorie() {
		return this.primo.getCalorieTotali()+this.secondo.getCalorieTotali();
	}
	
	public void inputCalorieMassime() {
		int calorieMax=InputDati.leggiInteroConMinimo("Inserisci il numero di calorie massime: ", 0);
		this.setCalorieMassime(calorieMax);
	}

	public int getCalorieMassime() {
		return calorieMassime;
	}

	public void setCalorieMassime(int calorieMassime) {
		this.calorieMassime = calorieMassime;
	}
}
