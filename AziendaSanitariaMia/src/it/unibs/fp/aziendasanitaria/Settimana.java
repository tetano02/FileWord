package it.unibs.fp.aziendasanitaria;

public enum Settimana {
	LUNEDI,MARTEDI,MERCOLEDI,GIOVEDI,VENERDI,SABATO; //Domenica è ovvio
	
	public static void stampaElencoSettimana() {
		System.out.println("SETTIMANA");
		int i=1;
		for(Settimana g:Settimana.values()) {
			System.out.println(i+")"+g.name());
			i++;
		}
	}
	
	public static Settimana getGiorno(int num) {
		switch(num) {
		case 1:
			return LUNEDI;
		case 2:
			return MARTEDI;
		case 3:
			return MERCOLEDI;
		case 4:
			return GIOVEDI;
		case 5:
			return VENERDI;
		default:
			return SABATO;
		}
	}
}
