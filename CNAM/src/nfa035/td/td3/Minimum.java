package nfa035.td.td3;

public class Minimum {
	/**
	 * Renvoie la valeur minimum contenue dans un tableau.
	 * 
	 * @param tab un tableau non vide
	 * @return le minimum d'un tableau
	 * @throws IllegalArgumentException si le tableau est vide
	 * @throws NullPointerException     si le tab vaut null
	 */
	public Minimum(double[] tab) {
		if(tab.length == 0) {
			throw new IllegalArgumentException();
		}
		double m = tab[0];
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] < m)
				m = tab[i];
		}
		
	}
}
