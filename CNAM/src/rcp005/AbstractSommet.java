package rcp005;

import java.util.Objects;



public abstract class AbstractSommet<T extends Comparable<T>> implements Comparable<AbstractSommet<T>>{
	T sommet;
	
	
	
	
	protected AbstractSommet() {
		this.sommet = null;
	}



	protected AbstractSommet(T sommet) {
		this.sommet = sommet;

	}



	/**
	 * @return the sommet
	 */
	protected T getSommet() {
		return sommet;
	}



	/**
	 * @param sommet the sommet to set
	 */
	protected void setSommet(T sommet) {
		this.sommet = sommet;
	}








	




	@Override
	public int hashCode() {
		return Objects.hash(sommet);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AbstractSommet)) {
			return false;
		}
		AbstractSommet<?> other = (AbstractSommet<?>) obj;
		return Objects.equals(sommet, other.sommet);
	}


	@Override
	public String toString() {
		return "AbstractSommet [sommet=" + sommet.toString() + "]";
	}



	@Override
	public int compareTo(AbstractSommet<T> o) {
		
		return this.getSommet().compareTo(o.getSommet());
	}

	


	
	
	
	
	
	

}
