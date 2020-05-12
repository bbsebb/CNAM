package nfa035.projet2.feuille;

import java.util.TreeSet;

import nfa035.projet2.exceptions.HorsFeuilleException;

public class Bloc extends Feuille{
	

	Bloc(TreeSet<Cellule> c) throws HorsFeuilleException {
		super();
		this.setCellules(c);
	}






	boolean estSansCelluleVide() {
		for(Cellule c : this.getCellules()) {
			if(c.estVide())
				return false;
		}
		return true;
	}
	



}
