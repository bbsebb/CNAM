package rcp005;

import java.util.Objects;

public abstract class AbstractLien<T extends Comparable<T> & Cloneable> implements Comparable<AbstractLien<T>>{
	private AbstractSommet<T> sommet1;
	private AbstractSommet<T> sommet2;
	
	public AbstractLien(AbstractSommet<T> sommet1,AbstractSommet<T> sommet2) {
		this.sommet1 = sommet1;
		this.sommet2 = sommet2;
	}

	public void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2) {
		if(s1 == null && s2 == null)
			throw new NullPointerException("un sommet n'est pas instancié");
		this.setSommet1(s1);
		this.setSommet2(s2);
	}
	
	/**
	 * @return the sommet1
	 */
	protected AbstractSommet<T> getSommet1() {
		return sommet1;
	}

	/**
	 * @param sommet1 the sommet1 to set
	 */
	protected void setSommet1(AbstractSommet<T> sommet1) {
		this.sommet1 = sommet1;
	}

	/**
	 * @return the sommet2
	 */
	protected AbstractSommet<T> getSommet2() {
		return sommet2;
	}

	/**
	 * @param sommet2 the sommet2 to set
	 */
	protected void setSommet2(AbstractSommet<T> sommet2) {
		this.sommet2 = sommet2;
	}

	@Override
	public String toString() {
		return "AbstractLien [sommet1=" + sommet1 + ", sommet2=" + sommet2 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(sommet1, sommet2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractLien)) {
			return false;
		}
		AbstractLien<?> other = (AbstractLien<?>) obj;
		return Objects.equals(sommet1, other.sommet1) && Objects.equals(sommet2, other.sommet2);
	}

	@Override
	public int compareTo(AbstractLien<T> o) {
		// TODO Auto-generated method stub
		 if(this.getSommet1().compareTo(o.getSommet1())==0) 
			 return this.getSommet2().compareTo(o.getSommet2());
		 else
			 return this.getSommet1().compareTo(o.getSommet1());	 
	}
	
	
	
	
	
	
}
