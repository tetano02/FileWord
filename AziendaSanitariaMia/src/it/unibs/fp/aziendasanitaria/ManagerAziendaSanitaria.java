package it.unibs.fp.aziendasanitaria;

import it.unibs.fp.mylib.InputDati;

public class ManagerAziendaSanitaria {

	private static final String SCELTA_GIORNO = "Scegli il giorno di riposo della settimana";
	private static final String NUOVO_PAZIENTE = "NUOVO PAZIENTE";
	private static final String NUOVO_MEDICO = "NUOVO MEDICO";
	private static final String RICHIESTA_TESSERA = "Inserisci il numero della tessera sanitaria del paziente(6 cifre, prima cifra diversa da 0):";
	private static final String RICHIESTA_NOME = "Inserisci il nome:";
	private static final String RICHIESTA_COGNOME = "Inserisci il cognome:";
	private static final String RICHIESTA_CODICE = "Inserisci il codice univoco del medico:";

	public static Medico creaMedico() {
		System.out.println(NUOVO_MEDICO);
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_NOME);
		String cognome=InputDati.leggiStringaNonVuota(RICHIESTA_COGNOME);
		String codiceUnivoco=InputDati.leggiStringaNonVuota(RICHIESTA_CODICE);
		Settimana.stampaElencoSettimana();
		int scelta=InputDati.leggiIntero(SCELTA_GIORNO,1,6);
		Settimana giorno=Settimana.getGiorno(scelta);
		return new Medico(nome,cognome,codiceUnivoco,giorno);
	}
	
	public static Paziente creaPaziente() {
		System.out.println(NUOVO_PAZIENTE);
		String nome=InputDati.leggiStringaNonVuota(RICHIESTA_NOME);
		String cognome=InputDati.leggiStringaNonVuota(RICHIESTA_COGNOME);
		int numeroTessera=InputDati.leggiIntero(RICHIESTA_TESSERA, 100000, 999999);
		return new Paziente(nome,cognome,numeroTessera);
	}
	
}
