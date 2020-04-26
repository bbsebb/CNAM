package nfa032.td.td6;

/**
 * Collection de mehtodes pour comparer deux instance de Convertible
 * @author Seb
 * @see Convertible
 */
public class Comparer {
	/**
	 * Compare a et b, si a>b renvoie true, sinon false
	 * @param a instance de Convertible
	 * @param b instance de Convertible
	 * @return
	 */
	public static boolean comparePlusGrand(Convertible a, Convertible b) {
		if (a.toInt() > b.toInt())
			return true;
		else
			return false;
	}
	/**
	 * Compare a et b, si a<b renvoie true, sinon false
	 * @param a instance de Convertible
	 * @param b instance de Convertible
	 * @return
	 */
	public static boolean comparePlusPetit(Convertible a, Convertible b) {
		if (a.toInt() < b.toInt())
			return true;
		else
			return false;		
	}
	/**
	 * Compare a et b, si a=b renvoie true, sinon false
	 * @param a instance de Convertible
	 * @param b instance de Convertible
	 * @return
	 */
	public static boolean compareEgal(Convertible a, Convertible b) {
		if (a.toInt() == b.toInt())
			return true;
		else
			return false;				
	}
	
	public static void tri(Convertible[] tab) {
		int j;
		Convertible c;
		for(int i = 1 ; i < tab.length;i++) {
			j=i;
			c = tab[i];
			while(j>0 && tab[j-1].toInt()>c.toInt()) {
				tab[j]=tab[j-1];
				j--;
			}
			tab[j] = c;
		}
	}
}
