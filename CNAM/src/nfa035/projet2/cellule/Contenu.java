package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;

public interface Contenu {
	/**
	 * Renvoie la valeur du conteneur
	 * @return la valeur du conteneur
	 */
	public abstract float getResultat() throws ErreurAffichage;
	public abstract String getFormule();
}
