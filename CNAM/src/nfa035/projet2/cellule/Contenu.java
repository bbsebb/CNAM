package nfa035.projet2.cellule;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.feuille.Cellule;

/**
 * <b>Interface qui représente le contenu des cellules</b>
 * @author bbseb
 * @see Cellule
 *
 */
public interface Contenu {
	/**
	 * 
	 * @return le resultat d'une formule de la cellule possédant ce contenu
	 * @throws ErreurAffichage si la cellule contient un contenu {@link Erreur "Erreur"}
	 */
	public abstract float getResultat() throws ErreurAffichage;
	/**
	 * 
	 * @return la formule de la cellule possédant ce contenu
	 */
	public abstract String getFormule();
}
