package nfa035.projet2.feuille;

import java.util.TreeSet;

import nfa035.projet2.exceptions.HorsFeuilleException;

/**
 * Cette classe repr�sente une bloc de cellule qui correspond � une feuille existante. 
 * @author bbseb
 *
 */
public class Bloc extends Feuille {

	/**
	 * Ce constructeur cr�e un bloc � partir d'une liste de cellules
	 * @param c
	 * @throws HorsFeuilleException
	 */
	Bloc(TreeSet<Cellule> c) throws HorsFeuilleException {
		super();
		this.setCellules(c);
	}

	/**
	 * Permet de verifier si un bloc contient des cellules vides.
	 * @return vrai si il n'y a pas de cellules vides dans le bloc, faux sinon
	 */
	boolean estSansCelluleVide() {
		for (Cellule c : this.getCellules()) {
			if (c.estVide())
				return false;
		}
		return true;
	}

}
