package nfa032.td.td11;



public class ElementListe {
	int valeur;
	ElementListe suivant;

	public ElementListe(int valeur, ElementListe suivant) {
		this.valeur = valeur;
		this.suivant = suivant;
	}

	public ElementListe(int v) {
		this.valeur = v;
		this.suivant = null;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public ElementListe getSuivant() {
		return suivant;
	}

	public void setSuivant(ElementListe suivant) {
		this.suivant = suivant;
	}
}