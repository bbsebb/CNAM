package nfa035.projet;


/**
 * Cette classe est un cellule possédant une simple valeur {@link Operande (operande)}
 * @author bbseb
 *
 */
public class CelluleValeur extends Cellule implements Contenu{
	
	
	private float valeur;
	
	public CelluleValeur() {
		super();
		this.setValeur(0);
	}
	public CelluleValeur(int x, int y) {
		super(x,y);
		
	}
	public CelluleValeur(int x, int y,float valeur) {
		super(x,y);
		this.setValeur(valeur);
	}
	@Override
	public float getResultat() {
		
		return this.valeur;
	}

	
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}


}
