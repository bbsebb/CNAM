package rcp005;

import java.util.LinkedList;

public abstract class AbstractSommet<T> {
	T sommet;
	LinkedList<AbstractSommet<T>> successeurs;
	
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

	@Override
	public String toString() {
		return "AbstractSommet [sommet=" + sommet + "]";
	}
	
	
	
}
