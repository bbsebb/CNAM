package rcp005;

public class GrapheNonOriente<T extends Comparable<T>> extends AbstractGraphe<T> {

	@Override
	protected void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		if (!this.contenir(s1))
			this.addSommet(s1);

		if (!this.contenir(s2))
			this.addSommet(s2);

		s1.addLien(s2);
		s2.addLien(s1);
		
	}
	
	public void addArrete(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		this.addLien(s1, s2);
	}


	
	public void addArrete(T t1, T t2) {
		this.addLien(t1, t2);
	}

	@Override
	public AbstractGraphe<T> reverse() {
		// TODO Auto-generated method stub
		return null;
	}
}
