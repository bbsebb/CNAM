package rcp005;

public class Arrete<T extends Comparable<T>> extends AbstractLien<T>{

	public Arrete(AbstractSommet<T> sommet1, AbstractSommet<T> sommet2) {
		super(sommet1, sommet2);
	}

	
}
