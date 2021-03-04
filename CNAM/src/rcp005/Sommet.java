package rcp005;

public class Sommet<T extends Comparable<T>> extends AbstractSommet<T>{

	public Sommet(T sommet) {
		super(sommet);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Sommet<T> clone() throws CloneNotSupportedException {
		Sommet<T> s = new Sommet<T>(this.getSommet());

		for(AbstractSommet<T> adj : this.getAdjacent()) {
			s.addLien((Sommet<T>) adj.clone());
		}
		return s;
	}



	

	

	
	

}
