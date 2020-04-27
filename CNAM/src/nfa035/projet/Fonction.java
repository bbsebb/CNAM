package nfa035.projet;

/**
 * Cette classe abstraite represente une fonction de calcule dans {@link Feuille une feuille de calcule} sur un bloc de {@link Cellule cellules}
 * @author bbseb
 *
 */
public abstract class Fonction {
	private Bloc bloc;
	
    
	/**
	 * 
	 * @param bloc est le bloc de cellule ou l'on applique la fonction
	 */
	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}

	public abstract float getResultat();
	
	public abstract boolean estFonction();
	
}
