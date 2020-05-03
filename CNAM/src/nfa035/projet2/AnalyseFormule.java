package nfa035.projet2;

public class AnalyseFormule {
	private String formule;
	private Feuille feuille;

	public AnalyseFormule(Feuille feuille, String formule) {
		this.setFeuille(feuille);
		this.setFormule(formule);
	}

	public Contenu formuleToContenu() throws FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		String f = this.getFormule();
		if (this.estValeur(f))
			return this.formuleToValeur(f);
		else if (this.estCellule(f))
			return this.formuleToCellule(f);
		else if (this.estOperation(f))
			return this.formuleToOperation(f);
		else if (this.estFonction(f))
			return this.formuleToFonction(f);
		else if (this.getFormule() == null || this.getFormule().isEmpty())
			return (Contenu) null;
		else
			throw new FormuleErroneeException();
	}

	private String getFormule() {
		return formule;
	}

	private void setFormule(String formule) {
		this.formule = formule.trim().toLowerCase();
	}

	private Feuille getFeuille() {
		return feuille;
	}

	private void setFeuille(Feuille feuille) {
		this.feuille = feuille;
	}

	private boolean estValeur(String str) {
		str = str.trim().toLowerCase();
		if (str.isEmpty())
			return false;
		char[] chaine = str.toCharArray();
		int compteurVirgule = 0;
		int compteurNegatif = 0;
		for (int c : chaine) {
			if (c != 44 && c != 45 && (c < 47 || c > 57))
				return false;
			if (c == 44) {
				compteurVirgule++;
				if (compteurVirgule > 1)
					return false;
			}
			if (c == 45) {
				compteurNegatif++;
				if (compteurNegatif > 1)
					return false;
			}
		}
		return true;
	}

	private boolean estCellule(String str) {
		str = str.trim().toLowerCase();
		String[] coordonnee = str.split("\\.");
		if (coordonnee.length != 2)
			return false;
		for (String c : coordonnee) {
			char[] chaine = c.toCharArray();
			for (char car : chaine) {
				if (car < 48 || car > 57)
					return false;
			}
		}
		return true;

	}

	private boolean estOperation(String str)  {

		str = str.trim().toLowerCase();
		String[] operandes = new String[0];
		Operateur operateur;
		try {
			operateur = this.stringToOperateur(str);
		} catch (FormuleErroneeException e) {
			// TODO Auto-generated catch block
			return false;
		}
		if(str.charAt(0) == '-') {
			operandes = str.substring(1).split(operateur.toRegex());
			operandes[0] = str.charAt(0) + operandes[0];
		} else 
			operandes = str.split(operateur.toRegex());
		if (operateur != null && str.indexOf(operateur.toString()) == str.lastIndexOf(operateur.toString())
				&& operandes.length == 2) {
			if ((estCellule(operandes[0]) || estValeur(operandes[0]))
					&& (estCellule(operandes[1]) || estValeur(operandes[1])))
				return true;
			else
				return false;
		} else
			return false;

	}

	private boolean estFonction(String str) {
		if (this.estSomme(str) || this.estMoyenne(str))
			return true;
		else
			return false;
	}

	private boolean estSomme(String str) {
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

	private boolean estMoyenne(String str) {
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

	private Contenu formuleToValeur(String str)  {
		return (Contenu) new Valeur(this.stringToValeur(str), this.getFormule());
	}

	private Contenu formuleToCellule(String str) throws HorsFeuilleException, FormuleErroneeException {
		int x, y;
		str = str.trim().toLowerCase();
		x = this.stringToCoordonneeCellule(str)[0];
		y = this.stringToCoordonneeCellule(str)[1];
		if (this.getFeuille().estCelluleVide(x, y))
			throw new FormuleErroneeException();
		else
			return (Contenu) this.getFeuille().getCellule(x, y);
	}

	private Contenu formuleToOperation(String str) throws FormuleErroneeException, HorsFeuilleException {
		str = str.trim().toLowerCase();
		Operateur operateur = this.stringToOperateur(str);
		Contenu operande1, operande2;
		String[] operandes;
		if(str.charAt(0) == '-') {
			operandes = str.substring(1).split(operateur.toRegex());
			operandes[0] = str.charAt(0) + operandes[0];
		} else 
			operandes = str.split(operateur.toRegex());
		if (this.estCellule(operandes[0]))
			operande1 = (Contenu) this.getFeuille().getCellule(this.stringToCoordonneeCellule(operandes[0])[0],
					this.stringToCoordonneeCellule(operandes[0])[1]);
		else if (this.estValeur(operandes[0]))
			operande1 = this.formuleToValeur(operandes[0]);
		else
			throw new FormuleErroneeException();
		if (this.estCellule(operandes[1]))
			operande2 = (Contenu) this.getFeuille().getCellule(this.stringToCoordonneeCellule(operandes[1])[0],
					this.stringToCoordonneeCellule(operandes[1])[1]);
		else if (this.estValeur(operandes[1]))
			operande2 = this.formuleToValeur(operandes[1]);
		else
			throw new FormuleErroneeException();
		return (Contenu) new Operation(operande1, operande2, operateur, this.getFormule());
	}

	private Contenu formuleToFonction(String str) throws HorsFeuilleException, CelluleVideException {
		str = str.trim().toLowerCase();
		int pointeur;
		if (this.estMoyenne(str))
			pointeur = 8;
		else
			pointeur = 6;
		char[] chaine = this.formule.toCharArray();
		Bloc b = new Bloc(chaine[pointeur] - 48, chaine[pointeur + 2] - 48, chaine[pointeur + 4] - 48,
				chaine[pointeur + 6] - 48, this.getFeuille());
		if(b.estSansCelluleVide()) {
		if (this.estMoyenne(str))
			return (Contenu) new Moyenne(b, this.getFormule());
		else
			return (Contenu) new Somme(b, this.getFormule());
		} else
			throw new CelluleVideException();

	}

	private float stringToValeur(String str) {
		str = str.trim().toLowerCase();
		float signe = 1f;
		if ('-' == str.charAt(0)) {
			signe = -1f;
			str = str.substring(1);
		}
		char[] chaine = str.toCharArray();
		double i = 1;
		int j = 0;
		if (str.indexOf(',') >= 0)
			j = chaine.length - str.indexOf(',');
		for (; j < chaine.length - 1; j++) {
			i = i * 10;
		}
		double rtr = 0;
		for (int c : chaine) {
			if (c == 44)
				continue;
			rtr = rtr + (c - 48) * i;
			i = i / 10;
		}
		return (float) rtr * signe;

	}

	private Operateur stringToOperateur(String str) throws FormuleErroneeException {
		char[] chaine = str.toCharArray();
		for(int i =(str.charAt(0)=='-')? 1:0;i<chaine.length;i++) {
			for (Operateur op : Operateur.values()) {
				if (chaine[i] == op.toChar()) {
					return op;
				}
			}
		}
		throw new FormuleErroneeException();
	}

	private int[] stringToCoordonneeCellule(String str) {
		int[] rtr = new int[2];
		str = str.trim().toLowerCase();
		String[] coordonnee = str.split("\\.");
		rtr[0] = (int) this.stringToValeur(coordonnee[0]);
		rtr[1] = (int) this.stringToValeur(coordonnee[1]);
		return rtr;
	}

}
