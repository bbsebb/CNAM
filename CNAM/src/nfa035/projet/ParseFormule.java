package nfa035.projet;

import java.awt.datatransfer.StringSelection;

public class ParseFormule {

	private String formule;

	public ParseFormule() {
		this.formule = null;
	}

	public ParseFormule(String formule) {
		this.formule = formule;
		this.formule=this.formule.toUpperCase().trim();

	}

	private boolean estValeur(String str) {
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

	private float parseValeur(String str) {
		if (this.estValeur(str)) {
			char[] chaine = str.toCharArray();
			float i = 1;
			int j = 0;
			if (str.indexOf(',') >= 0)
				j = chaine.length   - str.indexOf(',');
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
			throw new IllegalArgumentException();

	}

	public boolean estCellule() {

return false;
	}

	public boolean estCelluleValeur() {
		if (this.estValeur(this.formule))
			return true;
		else
			return false;

	}
	
	public float parseEstCelluleValeur() {
		if(estCelluleValeur())
			return this.parseValeur(this.formule);
		else
			throw new IllegalArgumentException();
	}
	
	public boolean estCelluleFonction() {
		return false;

	}

	public boolean estCelluleOperation() {
		return false;

	}

	public boolean estFonctionSomme() {
		return false;

	}

	public boolean estFonctionMoyenne() {
		return false;

	}

	public boolean estOperationOperande() {
		return false;

	}

	public boolean estOperationOperateur() {
		return false;

	}
}
