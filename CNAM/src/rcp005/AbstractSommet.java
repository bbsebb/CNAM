package rcp005;

import java.util.LinkedList;

public abstract class AbstractSommet<T> {
	T sommet;
	LinkedList<AbstractSommet<T>> successeurs;
	int dateDebut = 0;
	int dateFin = 0;
	int couleur = 0;
	static final int BLANC = 0;
	static final int GRIS = 1;
	static final int NOIR = 2;
	
	public AbstractSommet(T sommet) {
		this.sommet = sommet;
		successeurs = new LinkedList<AbstractSommet<T>>();
	}

	protected T getSommet() {
		return sommet;
	}

	protected void setSommet(T sommet) {
		this.sommet = sommet;
	}


	protected LinkedList<AbstractSommet<T>> getSuccesseurs() {
		return successeurs;
	}

	protected void setSuccesseurs(LinkedList<AbstractSommet<T>> successeurs) {
		this.successeurs = successeurs;
	}
	
	protected boolean addSuccesseur(AbstractSommet<T> s) {
		return this.getSuccesseurs().add(s);
	}
	
	protected boolean removeSuccesseur(AbstractSommet<T> s) {
		return this.getSuccesseurs().remove(s);
	}
	
	protected boolean removeAllSuccesseur() {
		return this.getSuccesseurs().removeAll(this.getSuccesseurs());
	}

	
	
	protected int getDateDebut() {
		return dateDebut;
	}

	protected void setDateDebut(int dateDebut) {
		this.dateDebut = dateDebut;
	}

	protected int getDateFin() {
		return dateFin;
	}

	protected void setDateFin(int dateFin) {
		this.dateFin = dateFin;
	}

	protected int getCouleur() {
		return couleur;
	}

	protected void setCouleur(int couleur) {
		this.couleur = couleur;
	}

	
	protected void reset() {
		this.setCouleur(BLANC);
		this.setDateDebut(0);
		this.setDateFin(0);
	}
	
	@Override
	public String toString() {
		return sommet + " : -- Couleur : " + couleur + " --date début : " + dateDebut + " --date fin : " + dateFin;
	}
	
	
	
}
