package nfa006;
/**
 * Cr�e un tableau d'entier al�atoire
 * @author bbseb
 *
 */
public class AlgoTab {
	public int[] tab;
	/**
	 * Cr�e un tableau d'entier al�atoire de taille n
	 * @param n est la taille du tableau
	 */
	public AlgoTab(int n) {
		tab = new int[n];
		affectTab(tab);
	}
	
	/**
	 * Affiche le tableau
	 * @param tab
	 */
	public static void afficher(int[] tab) {
		for(int i =0; i<tab.length;i++) {
			System.out.print(tab[i]+ " ");
		}
		System.out.println();
	}
	
	/**
	 * Rempli le tableau de nombre al�atoire allant de 0 � n.
	 * @param tab est le tableau d'entier � remplir
	 */
	public static void affectTab(int[] tab) {
		for(int i = 0; i < tab.length; i++) {
			 // Je met un max qui correspond � la taille du tableau, mais je pourrais ne peux en mettre		 
			tab[i] = 0 + (int)(Math.random() * ((tab.length - 0) + 1)); 
		}
	}
	
	public static void affectTabTri(int[] tab) {
		for(int i = 0; i < tab.length; i++) {
			 // Je met un max qui correspond � la taille du tableau, mais je pourrais ne peux en mettre		 
			tab[i] = i; 
		}
	}
		
		public static void affectTab(int[] tab,int max) {
			for(int i = 0; i < tab.length; i++) {
				 // Je met un max qui correspond � la taille du tableau, mais je pourrais ne peux en mettre		 
				tab[i] = 0 + (int)(Math.random() * ((max) + 1)); 
			}
	}
	
}
