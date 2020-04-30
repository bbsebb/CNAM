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
	private Feuille f;

	public ParseFormule(Feuille f) {
		this.formule = null;
		this.f = f;
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
			return parseValeur(this.formule);
		else
			throw new ErreurFormuleException();
	}

	/**
	 * Teste si la formule de l'instance correspond uniquement � une cellule de type
	 * fonction (somme ou moyenne)
	 * 
	 * @return true si elle correspond � une cellule de type fonction sinon false
	 * @see CelluleFonction
	 */
	public boolean estCelluleFonction() {
		if (estFonction(this.formule))
			return true;
		else
			return false;

	}
	private boolean estFonctionSomme() {
		return estFonctionSomme(this.formule);
	}
	private boolean estFonctionMoyenne() {
		return estFonctionMoyenne(this.formule);
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
	 * Retourne l'op�rande 1 qui peut �tre une op�rande(valeur float) ou une cellule
	 * 
	 * @return l'op�rande 1 qui peut �tre une op�rande(valeur float) ou une cellule
	 * @throws ErreurFormuleException si la formule ne comporte pas d'op�rande
	 */
	public Contenu parseCelluleOperationGetOperande1() throws ErreurFormuleException {
		if (estOperation(this.formule)) {
			String str = this.formule;
			Operateur op = this.parseCelluleOperationGetOperateur();
			String[] operandes = str.split(op.toRegex());
			if (estCellule(operandes[0])) {
				return this.f.getCellule(parseCellule(operandes[0])[0], parseCellule(operandes[0])[1]);
			} else if (estValeur(operandes[0])) {
				Contenu operande = new Operande(parseValeur(operandes[0]));
				return operande;
			} else {
				throw new ErreurFormuleException();
			}

		}
		throw new ErreurFormuleException();
	}

	/**
	 * Retourne l'op�rande 2 qui peut �tre une op�rande(valeur float) ou une cellule
	 * 
	 * @return l'op�rande 2 qui peut �tre une op�rande(valeur float) ou une cellule
	 * @throws ErreurFormuleException si la formule ne comporte pas d'op�rande
	 */
	public Contenu parseCelluleOperationGetOperande2() throws ErreurFormuleException {
		if (estOperation(this.formule)) {
			String str = this.formule;
			Operateur op = this.parseCelluleOperationGetOperateur();
			String[] operandes = str.split(op.toRegex());
			if (estCellule(operandes[1])) {
				return this.f.getCellule(parseCellule(operandes[1])[0], parseCellule(operandes[1])[1]);
			} else if (estValeur(operandes[1])) {
				Contenu operande = new Operande(parseValeur(operandes[1]));
				return operande;
			} else {
				throw new ErreurFormuleException();
			}

		}
		throw new ErreurFormuleException();
	}

	/**
	 * Retourne l'op�rateur de l'op�ration
	 * 
	 * @return l'op�rateur de l'op�ration
	 * @throws ErreurFormuleException
	 */
	public Operateur parseCelluleOperationGetOperateur() throws ErreurFormuleException {
		if (estOperation(this.formule)) {
			String str = this.formule;
			for (Operateur op : Operateur.values()) {
				if (str.contains(op.toString())) {
					return op;
				}
			}
		}
		throw new ErreurFormuleException();
	}

	/**
	 * Teste si la formule est une op�ration avec deux op�randes qui peuvent �tre
	 * une r�f�rence de cellule ou une valeur et un op�rateur de {@link Operateur
	 * Operateur}
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
	 * transforme le paramettre qui est une chaine de caract�re qui r�f�rence une
	 * cellule en les coordonn�s x,y de cette cellule.
	 * 
	 * @param str une chaine de caract�re qui repr�sente une cellule
	 * @return un tableau avec x en position 0 et y en position 1
	 * @throws ErreurFormuleException si la chaine n'est pas une cellule
	 */
	static public int[] parseCellule(String str) throws ErreurFormuleException {
		if (estCellule(str)) {
			int[] rtr = new int[2];
			str = str.trim().toLowerCase();
			char[] chaine = str.toCharArray();
			rtr[0] = chaine[0] - 48;
			rtr[1] = chaine[2] - 48;
			return rtr;
		} else
			throw new ErreurFormuleException();
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
	
	/**
	 * Teste si le paramettre est uniquement une fonction 
	 * 
	 * @param le chaine � tester
	 * @return vrai si c'est une fonction, faux sinon
	 */
	static public boolean estFonction(String str) {
		if (estFonctionMoyenne(str) || estFonctionSomme(str))
			return true;
		else
			return false;

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
		int compteur = 0;
		for (Operateur op : Operateur.values()) {
			if (str.contains(op.toString()) && str.indexOf(op.toString()) == str.lastIndexOf(op.toString())) {
				compteur++;
				
			}
		}
		if (compteur == 1)
			return true;
		else
			return false;
	}
	
	/**
	 * Renvoie le nombre d�cimal de la chaine. La chaine doit �tre compos� que d'un
	 * nombre decimal valide avec une , ou non
	 * 
	 * @param str est la chaine � tester
	 * @return le nombre d�cimal de la chaine
	 * @throws ErreurFormuleException est lanc� si str n'est pas une valeur
	 */
	static private float parseValeur(String str) throws ErreurFormuleException {
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
}
