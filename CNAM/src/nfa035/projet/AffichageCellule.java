package nfa035.projet;

public interface AffichageCellule {

	/**
	 * Renvoie la cellule sous sa forme de formule (Un simple nombre renverra ce nombre sous format texte)
	 * @return le contenu de la cellule 
	 */
	abstract String getFormule() ;
	
	/**
	 * Renvoie le resultat de la formule. 
	 * @return le resultat de la formule.
	 */
	abstract float getResultat();
	
	
}
