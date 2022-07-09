package morracinese.lib;

public abstract class Giocatore {

	private int vittoriePartite;
	private int vittorieScontri;
	private Mossa mossaAttuale;
	
	public Giocatore() {
		this.vittorieScontri=0;
		this.vittoriePartite=0;
	}
	
	public int getVittorieScontri() {
		return vittorieScontri;
	}


	public void aggiornaVittorieScontri() {
		this.vittorieScontri++;
	}
	
	public void azzeraVittorieScontri() {
		this.vittorieScontri=0;
	}

	public Mossa getMossa() {
		return this.mossaAttuale;
	}
	
	public void setMossa(Mossa mossa) {
		this.mossaAttuale=mossa;
	}

	public int getVittoriePartite() {
		return this.vittoriePartite;
	}
	
	public void aggiornaVittoriePartite() {
		this.vittoriePartite++;
	}
	
	public abstract void generaMossa();
	
}
