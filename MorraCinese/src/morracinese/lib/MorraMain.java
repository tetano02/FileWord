package morracinese.lib;

import java.io.FileNotFoundException;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

/**
 * Morra cinese
 * Scrivere un programma che gioca a "morra cinese" tra computer ed utente.
 * Il computer chiede all'utente di inserire la sua mossa (carta, forbice, sasso), garantendo che la sua
 * sarà scelta a caso senza tener conto di quella dell'utente.
 * Quindi presenta la propria mossa segnalando chi ha vinto la mossa oppure il pareggio. Il gioco si
 * ripete ciclicamente fino a quando l'utente decide di ritirarsi o uno dei due ha raggiunto un numero di
 * vittorie prefissato.
 * Al termine viene visualizzata (e salvata su un file di testo) la statistica del numero di vittorie e di
 * pareggi.
 * Facoltativamente introdurre una modalità grazie alla quale il computer si assicura una certa
 * probabilità di vittoria barando sull'estrazione.
 * @author Stefano
 *
 */
public class MorraMain {

	private static final String SCELTA = "Inserisci cosa vuoi fare: ";
	private static final String BENVENUTO = "Benvenuto giocatore!";
	private static final String SALUTO_FINALE = "Grazie per aver giocato, arrivederci!";
	private static final String TITOLO = "MORRA CINESE";
	private static final String voci[]= {"Gioca partita","Gioca partita barata","Stampa risultati"};
	
	public static void main(String args[]) throws FileNotFoundException {
		
		MyMenu menu=new MyMenu(TITOLO,voci);
		boolean finito=false;
		Partita game=new Partita();
		
		System.out.println(BENVENUTO);
		do {
			menu.stampaMenu();
			int scelta=InputDati.leggiIntero(SCELTA,0,3);
			switch(scelta) {
			case 0:
				finito=true;
			break;
			case 1:
				game.nuovaPartita();
				do {
				game.gioca();
				System.out.println(game.toString());
				}while(!game.isFinito());
				System.out.println(game.stampaEsito());
				game.aggiornamentoVincitore();
			break;
			case 2:
				game.nuovaPartita();
				do {
				game.giocaBarato();
				System.out.println(game.toString());
				}while(!game.isFinito());
				System.out.println(game.stampaEsito());
				game.aggiornamentoVincitore();
			break;
			case 3:
				GestioneFile.stampaEsito(game);
			break;
			}
		}while(!finito);
		System.out.println(SALUTO_FINALE);
	}
}
