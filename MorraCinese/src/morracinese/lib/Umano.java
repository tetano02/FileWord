package morracinese.lib;

import it.unibs.fp.mylib.InputDati;

public class Umano extends Giocatore{

	private static final String SCELTA_MOSSA = "Inserisci cosa giocare tra sasso,carta e forbice scegliendo 0,1,2:";

	public Umano() {
		super();
	}
	
	public void generaMossa(){
		int scelta=InputDati.leggiIntero(SCELTA_MOSSA,0,2);
		switch(scelta) {
		case 0:
			this.setMossa(Mossa.SASSO);
		break;
		case 1:
			this.setMossa(Mossa.CARTA);
		break;
		case 2:
			this.setMossa(Mossa.FORBICE);
		break;
		}
	}
}
