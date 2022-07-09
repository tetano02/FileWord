package morracinese.lib;

public class Partita {

	private static final String STACCO = "\n-----------------------------------\n";
	private static final String VITTORIA = "Complimenti %s, hai vinto!";
	private static final int NUMERO_VITTORIE_MAX = 3;
	private Umano g1=new Umano();
	private Computer g2=new Computer();
	private int esitoAttuale;

	public Umano getG1() {
		return g1;
	}

	public Computer getG2() {
		return g2;
	}
	
	public void nuovaPartita() {
		this.g1.azzeraVittorieScontri();
		this.g2.azzeraVittorieScontri();
	}
	
	public void gioca() {
			this.g1.generaMossa();
			this.g2.generaMossa();
			this.esitoAttuale=GestioneMosse.confrontaMosse(g1.getMossa(),g2.getMossa());
			this.aggiornaVittorieScontri();
	}
	
	public void giocaBarato() {
		this.g1.generaMossa();
		this.g2.generaMossaBarata(g1.getMossa());
		this.esitoAttuale=GestioneMosse.confrontaMosse(g1.getMossa(),g2.getMossa());
		this.aggiornaVittorieScontri();
	}
	
	private void aggiornaVittorieScontri() {
		if(this.esitoAttuale==1)
			this.g1.aggiornaVittorieScontri();
		else if(this.esitoAttuale==-1)
			this.g2.aggiornaVittorieScontri();
	}

	
	
	
	public String toString() {
		StringBuffer str=new StringBuffer();
		str.append(STACCO);
		str.append("Hai giocato "+g1.getMossa());
		str.append("\nIl computer gioca "+g2.getMossa());
		if(this.esitoAttuale==0)
			str.append("\nPartita finita in pareggio");
		else if(this.esitoAttuale==1) {
			str.append("\nHa vinto l'umano");
		}else {
			str.append("\nHa vinto il computer");
		}
		str.append(STACCO);
		str.append("VITTORIE ATTUALI:\nTU: "+this.g1.getVittorieScontri()+"\nCOMPUTER: "+this.g2.getVittorieScontri());
		str.append(STACCO);
		return str.toString();
	}
	
	public boolean isFinito() {
		return this.g1.getVittorieScontri()==NUMERO_VITTORIE_MAX || this.g2.getVittorieScontri()==NUMERO_VITTORIE_MAX;
	}
	
	public String stampaEsito() {
		String vincitore=null;
		if(this.g1.getVittorieScontri()==NUMERO_VITTORIE_MAX)
			vincitore="umano";
		else
			vincitore="computer";
		return String.format(VITTORIA, vincitore);
	}

	public void aggiornamentoVincitore() {
		if(this.g1.getVittorieScontri()==NUMERO_VITTORIE_MAX)
			this.g1.aggiornaVittoriePartite();
		else
			this.g2.aggiornaVittoriePartite();
	}
	


}
