package nfa035.projet;

/**
 * Cette classe est un cellule possédant {@link Fonction une fonction} associé à un bloc de {@link Cellule (cellule)}
 * @author bbseb
 *
 */
public class CelluleFonction extends Cellule implements Contenu{

	private Bloc bloc;
	private Fonction fonction;
	
	
	public CelluleFonction() {
		super();
		bloc = null;
		fonction = null;
	}
	
	public CelluleFonction(int x, int y) {
		super(x,y);
		bloc = null;
		fonction = null;
	}
	
	public CelluleFonction(int x, int y,Fonction f) {
		super(x,y);
		bloc = null;
		fonction = f;
	}
	
	@Override
	public float getResultat() {
		
		return 0;
	}


	
}
