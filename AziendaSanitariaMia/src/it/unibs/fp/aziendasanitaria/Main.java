package it.unibs.fp.aziendasanitaria;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Main {

	private static final String AGGIUNTA_MEDICO = "Prima di procedere, aggiungi un medico";
	private static final String SALUTI = "Grazie per essere passato, arrivederci!";
	private static final String NUOVO_MEDICO = "Scelta nuovo medico\n";
	private static final String SCEGLI_GIORNO = "Scegli un giorno della settimana inserendo il numero";
	private static final int MAX = 999999;
	private static final int MIN = 100000;
	private static final String TESSERA = "Inserisci numero della tessera sanitaria";
	private static final String CODICE = "Inserisci il codice: ";
	private static final String SCELTA_MEDICO = "Scegli un medico dal codice univoco\n";
	private static final String[] voci= {"Aggiungi un medico","Aggiungi un paziente","Cerca medico per codice","Cerca medico per giorno di riposo"
			,"Trova paziente per tessera sanitaria","Cambia medico di un paziente"};
	
	public static void main(String[] args) {
		
		MyMenu menu=new MyMenu("AZIENDA SANITARIA",voci);
		boolean finito=false;
		AziendaSanitaria azienda=new AziendaSanitaria();
		
		do {
			menu.stampaMenu();
			int scelta=InputDati.leggiIntero("Inserisci la tua scelta: ", 0, 6);
			switch(scelta) {
			case 0:
				finito=true;
			break;
			case 1:
				azienda.aggiungiMedico(ManagerAziendaSanitaria.creaMedico());
			break;
			case 2:
				if(azienda.getElencoMedici().size()!=0) {
					Paziente paziente=ManagerAziendaSanitaria.creaPaziente();
					azienda.stampaElencoMedici();
					boolean valido=false;
					do {
						String codice=InputDati.leggiStringaNonVuota(SCELTA_MEDICO+CODICE);
						try {
							azienda.ricercaMedico(codice).aggiungiPaziente(paziente);
							valido=true;
						}catch(NullPointerException e) {
							System.out.println("Medico non trovato, prova con un altro codice");
						}
					}while(!valido);
				}else
					System.out.println(AGGIUNTA_MEDICO);
			break;
			case 3:
				if(azienda.getElencoMedici().size()!=0) {
					String cercaCodice=InputDati.leggiStringaNonVuota(CODICE);
					azienda.stampaMedico(cercaCodice);
				}else
					System.out.println(AGGIUNTA_MEDICO);
			break;
			case 4:
				if(azienda.getElencoMedici().size()!=0) {
					Settimana.stampaElencoSettimana();
					azienda.ricercaMedico(Settimana.getGiorno(InputDati.leggiIntero(SCEGLI_GIORNO, 1,6)));
				}else
					System.out.println(AGGIUNTA_MEDICO);
			break;
			case 5:
				if(azienda.getElencoMedici().size()!=0)
					azienda.trovaPaziente(InputDati.leggiIntero(TESSERA, MIN,MAX));
				else
					System.out.println(AGGIUNTA_MEDICO);
			break;
			case 6:
				if(azienda.getElencoMedici().size()!=0) {
					int sceltaNumero=InputDati.leggiIntero(TESSERA, MIN,MAX);
					String codice=InputDati.leggiStringaNonVuota(NUOVO_MEDICO+CODICE);
					azienda.cambiaMedico(sceltaNumero, codice);
				}else
					System.out.println(AGGIUNTA_MEDICO);
			break;
			}
			
		}while(!finito);
		System.out.println(SALUTI);
	}

}
