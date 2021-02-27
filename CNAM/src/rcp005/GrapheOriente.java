package rcp005;

public class GrapheOriente<T extends Comparable<T>> extends AbstractGraphe<T> {
	
	
	@Override
	protected void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		if (!this.contenir(s1))
			this.addSommet(s1);

		if (!this.contenir(s2))
			this.addSommet(s2);
		s1.addLien(s2);
	}
	
	public void addArc(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		this.addLien(s1,s2);
this.parcoursEnProfondeur();
	}


	
	public void addArc(T t1, T t2) {
		this.addLien(t1, t2);
		this.parcoursEnProfondeur();
	}
}
