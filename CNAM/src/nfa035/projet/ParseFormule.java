package nfa035.projet;

/**
 * <p>
 * Permet de tester si la formule entrer par l'uilisateur est correcte et � quel
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
	 * Constructeur qui enl�ve les espaces et met en minuscule le paramettre
	 * 
	 * @param formule
	 */
	public ParseFormule(String formule) {
		this.formule = formule;
		this.formule = this.formule.toLowerCase().trim();

	}

	/**
	 * Renvoie le nombre d�cimal de la chaine. La chaine doit �tre compos� que d'un
	 * nombre decimal valide avec une , ou non
	 * 
	 * @param str est la chaine � tester
	 * @return le nombre d�cimal de la chaine
	 * @throws ErreurFormuleException est lanc� si str n'est pas une valeur
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
	 * Teste si la formule de l'instance correspond uniquement � une cellule de type
	 * valeur
	 * 
	 * @return true si elle correspond � une cellule de type valeur sinon false
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
	 * Renvoie le nombre d�cimal qui correspond � la formule de l'instance, si cette
	 * formule correspond � une cellule de type valeur.
	 * 
	 * @return le nombre d�cimal de la formule
	 * @throws ErreurFormuleException est lanc� si la formule n'est pas une valeur
	 */
	public float parseEstCelluleValeur() throws ErreurFormuleException {
		if (estCelluleValeur())
			return this.parseValeur(this.formule);
		else
			throw new ErreurFormuleException();
	}

	/**
	 * Teste si la formule de l'instance correspond uniquement � une cellule de type
	 * fonction
	 * 
	 * @return true si elle correspond � une cellule de type fonction sinon false
	 * @see CelluleFonction
	 */
	public boolean estCelluleFonction() {
		if (estFonctionMoyenne(this.formule) || estFonctionSomme(this.formule))
			return true;
		else
			return false;

	}

	/**
	 * Renvoie la fonction associ� au bloc donn� dans la chaine de caract�re
	 * 
	 * @return une fonction associ� � un bloc de cellule
	 * @throws ErreurFormuleException est lanc� si la formule n'est pas une fonction
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
	 * Teste si la formule de l'instance correspond uniquement � une cellule de type
	 * Operation
	 * 
	 * @return true si elle correspond � une cellule de type fonction sinon false
	 * @see CelluleOp
	 */
	public boolean estCelluleOperation() {
		if (estOperation(this.formule))
			return true;
		else
			return false;

	}

	/**
	 * Teste si la formule est une op�ration avec deux op�randes qui peuvent �tre une r�f�rence de cellule ou une valeur et un op�rateur de {@link Operateur Operateur}
	 * 
	 * 
	 * @return true si c'est une op�ration sinon false
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
	 * @param str la chaine de caract�re � tester
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
	 * @param le chaine � tester
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
	 * @param le chaine � tester
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
	 * Teste si le paramettre correspond � un nombre d�cimal avec une , ou non
	 * 
	 * @param str est la chaine � tester
	 * @return true si c'est un nombre d�cimal ou faux
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
