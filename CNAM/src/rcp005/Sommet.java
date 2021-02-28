package rcp005;

public class Sommet<T extends Comparable<T>> extends AbstractSommet<T>{

	public Sommet(T sommet) {
		super(sommet);
		
	}

	@Override
	protected Sommet<T> clone() throws CloneNotSupportedException {
		T t = this.getSommet();
		Class<T> cl = (Class<T>) t.getClass();
		Class<T> [] clInt = cl.getInterfaces();
 		Sommet<T> s = new Sommet<T>(this.getSommet());
		
		return s;
	}


	

	

	
	

}
