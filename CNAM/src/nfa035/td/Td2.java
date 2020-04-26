package nfa035.td;

public class Td2 {
	public static void main(String[] args) {
		// 1
		String str = new String("Monsieur LION");
		String str2 = new String("Madame ZOPA");
		/*
		 * Java 8 1.1 15 constructeurs 2.2 Il y a deux méthode qui teste l'ordre de deux
		 * 
		 * 1.2 chaines :
		 */
		System.out.println(str.compareTo(str2));
		System.out.println(str.compareToIgnoreCase(str2));
		/*
		 * retourne 0 si égal, négatif, si la chaine de l'objet est dans un ordre
		 * précedent l'objet en argumet. Positif pour l'inverse.
		 * 
		 * 1.3
		 */
		System.out.println(str2.toLowerCase());
		/*
		 * 1.4
		 * 
		 * valueOf() transforme l'argument en String.
		 * 
		 * 1.5 subString() retourne la chaine à partir de l'index du caractère entré en
		 * argument
		 * 
		 * 2
		 */
		System.out.println(compareNom(str, str2));
	}

	/**
	 * <p>
	 * <b><i>compareNom()</i></b> compare deux chaines et renvoie le premier nom
	 * selon l'ordre alphabétique sans tenir compte du prefixe de genre.
	 * <p>
	 * 
	 * @param str1 est la prémière chaine comparée
	 * @param str2 est la deuxième chaine comparée
	 * @return La chaine dans l'ordre lexicographique est le plus bas. Si égal
	 *         renvoie la chaine en premier argument (hors genre)
	 * @throws IllegalArgumentException si str1 ou str2 est vide
	 * @see #normalise(String)
	 */
	public static String compareNom(String str1, String str2) {
		String str;
		if (str1.isEmpty())
			throw new IllegalArgumentException();
		if (str2.isEmpty())
			throw new IllegalArgumentException();

		if (normalise(str1).compareTo(normalise(str2)) > 0)
			str = str2;
		else
			str = str1;

		return str;
	}
	/**
	* renvoie un nom sans sa civilité si elle est précisée.
	* @param str: String non vide,
	* @return le nom sans sa civilité
	* @throws IllegalArgumentException si s est vide
	* @see #compareNom(String, String)
	*/
	public static String normalise(String str) {
		if (str.isEmpty())
			throw new IllegalArgumentException();
		str = str.toLowerCase();

		try {
			if (str.startsWith("monsieur")) {
				str = str.substring(8).trim();
			}
			if (str.startsWith("madame")) {
				str = str.substring(6).trim();
			}
		} catch (IndexOutOfBoundsException e) {
		}
		return str;
	}
}
