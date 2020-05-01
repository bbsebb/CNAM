package nfa035.projet;

/**
 * Cette classe est un cellule poss�dant {@link Fonction une fonction} associ� � un bloc de {@link Cellule (cellule)}
 * @author bbseb
 *
 */
public class CelluleFonction extends Cellule implements Contenu{

	private Bloc bloc;
	private Fonction fonction;
	
	

	
	public CelluleFonction(int x, int y,Fonction f) {
		super(x,y);
		bloc = f.getBloc();
		fonction = f;
	}
	
	@Override
	public float getResultat() {
		
		return this.fonction.getResultat();
	}


	
}
