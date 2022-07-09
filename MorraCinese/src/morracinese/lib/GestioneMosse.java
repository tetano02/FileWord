package morracinese.lib;

public class GestioneMosse {
	
	public static int confrontaMosse(Mossa mossaUmano, Mossa mossaComputer) {
		if(mossaUmano.equals(mossaComputer))
			return 0;
		switch(mossaUmano) {
		case SASSO:
			switch(mossaComputer) {
			case FORBICE:
				return 1;
			case CARTA: 
				return -1;
			default:
				break;
			}
		case CARTA:
			switch(mossaComputer) {
			case SASSO:
				return 1;
			case FORBICE: 
				return -1;
			default:
				break;
			}
		case FORBICE:
			switch(mossaComputer) {
			case CARTA:
				return 1;
			case SASSO: 
				return -1;
			default:
				break;
			}
		default:
			break;
		}
		return 0;
	}
	
	public static Mossa mossaVincente(Mossa mossa) {
		switch(mossa) {
		case SASSO:
			return	Mossa.CARTA;
		case CARTA:
			return Mossa.FORBICE;
		default:
			return Mossa.SASSO;
		}
	}
}
