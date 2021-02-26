package rcp005;

public class GrapheTest<T extends Comparable<T>> extends AbstractGraphe<T> {

	@Override
	protected void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		if (!this.contenir(s1))
			this.addSommet(s1);

		if (!this.contenir(s2))
			this.addSommet(s2);

		this.liens.add(new Arrete<T>(s1,s2));

	}

	@Override
	protected void addLien(T t1, T t2) {
		this.addLien(this.getSommet(t1), this.getSommet(t2));
		
	}

}
