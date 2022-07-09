package it.unibs.fp.massaia;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class MassaiaMain {

	private static final String SALUTI_FINALI = "Grazie per aver mangiato da noi, arrivederci!";
	private static final String TITOLO = "MASSAIA";
	private static final String[] voci= {"Aggiungi ingrediente all'elenco","Rimuovi ingrediente dall'elenco","Mostra elenco ingredienti",
			"Aggiungi ricetta all'elenco", "Rimuovi ricetta dall'elenco","Mostra Ricette","Componi un menu"};
	
	public static void main(String[] args) {
		
		
		MyMenu menuScelta=new MyMenu(TITOLO,voci);
		boolean finito=false;
		ElencoIngredienti elencoIngredienti=new ElencoIngredienti();
		ElencoRicette elencoRicette=new ElencoRicette();
		Menu menuPasto=new Menu();
		
		do {
			menuScelta.stampaMenu();
			int scelta=InputDati.leggiIntero("Scegli cosa fare: ",0,7);
			switch(scelta) {
			case 0:
				finito=true;
			break;
			case 1:
				elencoIngredienti.aggiungiIngrediente();
			break;
			case 2:
				elencoIngredienti.rimuoviIngrediente();
			break;
			case 3:
				System.out.println(elencoIngredienti.toString());
			break;
			case 4:
				elencoRicette.nuovaRicetta(elencoIngredienti);
			break;
			case 5:
				elencoRicette.rimuoviRicetta();
			break;
			case 6:
				System.out.println(elencoRicette.toString());
			break;
			case 7:
				menuPasto.costruisciMenu(elencoRicette);
			break;
			}
		}while(!finito);
		System.out.println(SALUTI_FINALI);
	}

}
