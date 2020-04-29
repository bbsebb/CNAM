package nfa035.projet;

/**
 * <p>
 * Permet de tester si la formule entrer par l'uilisateur est correcte et à quel
 * class de cellule elle correspond. On pourra parser la formule en fonction des
 * besoins
 * </p>
 * 
 * @author bbseb
 *
 */
public class ParseFormule {

	private String formule;

	public ParseFormule() {
		this.formule = null;
	}

	/**
	 * Constructeur qui enlève les espaces et met en minuscule le paramettre
	 * 
	 * @param formule
	 */
	public ParseFormule(String formule) {
		this.formule = formule;
		this.formule = this.formule.toLowerCase().trim();

	}

	/**
	 * Renvoie le nombre décimal de la chaine. La chaine doit être composé que d'un
	 * nombre decimal valide avec une , ou non
	 * 
	 * @param str est la chaine à tester
	 * @return le nombre décimal de la chaine
	 * @throws ErreurFormuleException est lancé si str n'est pas une valeur
	 */
	private float parseValeur(String str) throws ErreurFormuleException {
		if (estValeur(str)) {
			char[] chaine = str.toCharArray();
			float i = 1;
			int j = 0;
			if (str.indexOf(',') >= 0)
				j = chaine.length - str.indexOf(',');
			for (; j < chaine.length - 1; j++) {
				i = i * 10;
			}
			float rtr = 0;
			for (int c : chaine) {
				rtr = rtr + (c - 48) * i;
				i = i / 10;
			}
			return rtr;
		} else
			throw new ErreurFormuleException();

	}

	/**
	 * Teste si la formule de l'instance correspond uniquement à une cellule de type
	 * valeur
	 * 
	 * @return true si elle correspond à une cellule de type valeur sinon false
	 * @see CelluleValeur
	 * 
	 */
	public boolean estCelluleValeur() {
		if (estValeur(this.formule))
			return true;
		else
			return false;

	}

	/**
	 * Renvoie le nombre décimal qui correspond à la formule de l'instance, si cette
	 * formule correspond à une cellule de type valeur.
	 * 
	 * @return le nombre décimal de la formule
	 * @throws ErreurFormuleException est lancé si la formule n'est pas une valeur
	 */
	public float parseEstCelluleValeur() throws ErreurFormuleException {
		if (estCelluleValeur())
			return this.parseValeur(this.formule);
		else
			throw new ErreurFormuleException();
	}

	/**
	 * Teste si la formule de l'instance correspond uniquement à une cellule de type
	 * fonction
	 * 
	 * @return true si elle correspond à une cellule de type fonction sinon false
	 * @see CelluleFonction
	 */
	public boolean estCelluleFonction() {
		if (estFonctionMoyenne(this.formule) || estFonctionSomme(this.formule))
			return true;
		else
			return false;

	}

	/**
	 * Renvoie la fonction associé au bloc donné dans la chaine de caractère
	 * 
	 * @return une fonction associé à un bloc de cellule
	 * @throws ErreurFormuleException est lancé si la formule n'est pas une fonction
	 */
	public Fonction parseEstCelluleFonction() throws ErreurFormuleException {

		if (this.estCelluleFonction()) {
			int pointeur = (estFonctionMoyenne()) ? 8 : 6;
			char[] chaine = this.formule.toCharArray();
			Bloc b = new Bloc(chaine[pointeur] - 48, chaine[pointeur + 2] - 48, chaine[pointeur + 4] - 48,
					chaine[pointeur + 6] - 48);
			if (this.estFonctionMoyenne())
				return new Moyenne(b);
			else if (this.estFonctionSomme())
				return new Somme(b);
			else
				throw new ErreurFormuleException();
		} else
			throw new ErreurFormuleException();

	}
	/**
	 * Teste si la formule de l'instance correspond uniquement à une cellule de type
	 * Operation
	 * 
	 * @return true si elle correspond à une cellule de type fonction sinon false
	 * @see CelluleOp
	 */
	public boolean estCelluleOperation() {
		if (estOperation(this.formule))
			return true;
		else
			return false;

	}

	/**
	 * Teste si la formule est une opération avec deux opérandes qui peuvent être une référence de cellule ou une valeur et un opérateur de {@link Operateur Operateur}
	 * 
	 * 
	 * @return true si c'est une opération sinon false
	 * 
	 */
	static public boolean estOperation(String str) {
		str = str.trim().toLowerCase();
		char operateur = '0';
		String[] operandes = new String[0];
		for (Operateur op : Operateur.values()) {
			if (str.contains(op.toString())) {
				operandes = str.split(op.toRegex());
				operateur = op.toChar();
				break;
			}
		}
		if (operateur != 0 && operandes.length == 2) {
			if (estOperationOperande(operandes[0]) && estOperationOperande(operandes[1]))
				return true;
			else
				return false;
		} else
			return false;

	}

	/**
	 * Teste si une chaine est une possible cellule avec a.b et a et b des entier
	 * positif.
	 * 
	 * @param str la chaine de caractère à tester
	 * @return vrai si c'est une cellule ou faut si ce n'est pas une cellule
	 */
	static public boolean estCellule(String str) {
		str = str.trim().toLowerCase();
		char[] chaine = str.toCharArray();
		if (chaine.length == 3 && chaine[0] > 48 && chaine[0] < 58 && chaine[2] < 58 && chaine[2] > 48
				&& chaine[1] == '.')
			return true;
		else
			return false;
	}

	/**
	 * Teste si le paramettre est uniquement une fonction somme.
	 * 
	 * @param le chaine à tester
	 * @return vrai si c'est une fonction somme, faux sinon
	 */
	static public boolean estFonctionSomme(String str) {
		str = str.trim().toLowerCase();
		char[] cible = "somme(".toCharArray();
		char[] chaine = str.toCharArray();
		if (chaine.length == 14 && chaine[9] == ';' && chaine[13] == ')') {
			for (int i = 0; i < cible.length; i++) {
				if (cible[i] != chaine[i])
					return false;
			}
			if (estCellule(str.substring(6, 9)) && estCellule(str.substring(10, 13)))
				return true;
		}
		return false;

	}

	private boolean estFonctionSomme() {
		return estFonctionSomme(this.formule);
	}

	/**
	 * Teste si le paramettre est uniquement une fonction moyenne
	 * 
	 * @param le chaine à tester
	 * @return vrai si c'est une fonction somme, faux sinon
	 */
	static public boolean estFonctionMoyenne(String str) {
		str = str.trim().toLowerCase();
		char[] cible = "moyenne(".toCharArray();
		char[] chaine = str.toCharArray();
		if (chaine.length == 16 && chaine[11] == ';' && chaine[15] == ')') {
			for (int i = 0; i < cible.length; i++) {
				if (cible[i] != chaine[i])
					return false;
			}
			if (estCellule(str.substring(8, 11)) && estCellule(str.substring(12, 15)))
				return true;
		}
		return false;
	}

	private boolean estFonctionMoyenne() {
		return estFonctionMoyenne(this.formule);
	}

	/**
	 * Teste si le paramettre correspond à un nombre décimal avec une , ou non
	 * 
	 * @param str est la chaine à tester
	 * @return true si c'est un nombre décimal ou faux
	 */
	static public boolean estValeur(String str) {
		str = str.trim().toLowerCase();
		char[] chaine = str.toCharArray();
		int compteurVirgule = 0;
		for (int c : chaine) {
			if (c != 44 && (c < 48 || c > 57))
				return false;
			if (c == 44) {
				compteurVirgule++;
				if (compteurVirgule > 1)
					return false;
			}
		}
		return true;
	}

	static public boolean estOperationOperande(String str) {
		if (estCellule(str) || estValeur(str))
			return true;
		else
			return false;

	}

	static public boolean estOperationOperateur(String str) {
		str = str.trim().toLowerCase();
		for (Operateur op : Operateur.values()) {
			if (str.contains(op.toString())) {
				return true;
			}
		}
		return false;
	}
}
