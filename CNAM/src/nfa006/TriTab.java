package nfa006;

/**
 * <p>
 * Catalogue de tri d'alogrithme de tri de tableau
 * </p>
 * <ul>
 * <li>tri à insertion croissant</li>
 * <li>tri à insertion avec choix sens</li>
 * <li>tri à bulle croissant</li>
 * <li>tri à bulle avec choix de sens</li>
 * </ul>
 * 
 * @author bbseb
 *
 */
public class TriTab {

	/**
	 * Tri un tableau d'entier avec l'algorithme de tri à insertion dans le sens
	 * croissant
	 * 
	 * @param tab est le tableau d'entier à trier
	 */
	public static void triInsertion(int[] tab) {
		int j, elementCompare;
		for (int i = 1; i < tab.length; i++) {
			elementCompare = tab[i];
			j = i;
			while (j > 0 && tab[j - 1] > elementCompare) {
				tab[j] = tab[j - 1];
				j--;
			}
			tab[j] = elementCompare;
		}
	}

	/**
	 * Tri un tableau d'entier avec l'algorithme de tri à insertion dans le sens
	 * choisis
	 * 
	 * @param tab  est le tableau d'entier à trier
	 * @param sens est le sens du tri. Il faut noter "decroissant" pour faire en
	 *             décroissant sinon, c'est toujours croissant
	 */
	public static void triInsertion(int[] tab, String sens) {
		int j, elementCompare;
		for (int i = 1; i < tab.length; i++) {
			elementCompare = tab[i];
			j = i;
			if (sens.equals("decroissant")) {
				while (j > 0 && tab[j - 1] < elementCompare) {
					tab[j] = tab[j - 1];
					j--;
				}
				tab[j] = elementCompare;
			} else {
				while (j > 0 && tab[j - 1] > elementCompare) {
					tab[j] = tab[j - 1];
					j--;
				}
				tab[j] = elementCompare;
			}

		}
	}

	/**
	 * Tri un tableau d'entier avec l'algorithme de tri à bulle dans le sens
	 * croissant
	 * 
	 * @param tab est le tableau d'entier à trier
	 */
	public static void triBulle(int[] tab) {
		for (int i = tab.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (tab[j] > tab[j + 1]) {
					int temp = tab[j];
					tab[j] = tab[j + 1];
					tab[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Tri un tableau d'entier avec l'algorithme de tri à bulle dans le sens choisis
	 * 
	 * @param tab  est le tableau d'entier à trier
	 * @param sens est le sens du tri. Il faut noter "decroissant" pour faire en
	 *             décroissant sinon, c'est toujours croissant
	 */
	public static void triBulle(int[] tab, String sens) {
		for (int i = tab.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (sens.equals("decroissant")) {
					if (tab[j] < tab[j + 1]) {
						int temp = tab[j];
						tab[j] = tab[j + 1];
						tab[j + 1] = temp;
					}
				} else {
					int temp = tab[j];
					tab[j] = tab[j + 1];
					tab[j + 1] = temp;
				}
			}
		}
	}

}
