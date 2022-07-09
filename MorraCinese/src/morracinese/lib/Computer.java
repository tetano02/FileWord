package morracinese.lib;

import it.unibs.fp.mylib.EstrazioniCasuali;

public class Computer extends Giocatore{

	public Computer() {
		super();
	}
	
	public void generaMossa() {
		int rand=EstrazioniCasuali.estraiIntero(0, 2);
		switch(rand) {
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
	
	public void generaMossaBarata(Mossa mossa) {
		generaMossa();
		int rand=EstrazioniCasuali.estraiIntero(0,1);
		if(rand==0) {
			this.setMossa(GestioneMosse.mossaVincente(mossa));
		}
	}
}
