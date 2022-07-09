package morracinese.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class GestioneFile {

	private static final String COMPUTER = "Vittorie computer: ";
	private static final String UMANO = "VITTORIE UMANO: ";
	private static final String TITOLO = "ESITI MORRA CINESE";

	public static void stampaEsito(Partita partita) throws FileNotFoundException {
		
		File file=new File("EsitoMorraCinese.txt");
		PrintWriter pw=new PrintWriter(file);
		
		pw.println(TITOLO);
		pw.println(UMANO+partita.getG1().getVittoriePartite());
		pw.println(COMPUTER+partita.getG2().getVittoriePartite());
		
		pw.close();
	}
}
