package rcp005;

public abstract class AbstractSommet<T> {
	T sommet;

	
	public AbstractSommet(T sommet) {
		super();
		this.sommet = sommet;
	}

	protected T getSommet() {
		return sommet;
	}

	protected void setSommet(T sommet) {
		this.sommet = sommet;
	}
	
	
}
