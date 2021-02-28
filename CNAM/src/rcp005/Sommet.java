package rcp005;

public class Sommet<T extends Comparable<T> & Cloneable> extends AbstractSommet<T>{

	public Sommet(T sommet) {
		super(sommet);
		
	}

	@Override
	protected Sommet<T> clone() throws CloneNotSupportedException {
		Sommet<T> s = new Sommet<T>(this.getSommet());
		
		return s;
	}


	

	

	
	

}
