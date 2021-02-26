package rcp005;

import java.util.NoSuchElementException;
import java.util.TreeSet;

public abstract class AbstractGraphe<T extends Comparable<T>> {
	protected TreeSet<AbstractSommet<T>> sommets;
	protected TreeSet<AbstractLien<T>> liens;
	
	

	public AbstractGraphe () {
		this.sommets = new TreeSet<AbstractSommet<T>>();
		this.liens = new TreeSet<AbstractLien<T>>();
		
	}
	
	
	public AbstractGraphe (AbstractSommet<T> s) {
		this.sommets = new TreeSet<AbstractSommet<T>>();
		this.liens = new TreeSet<AbstractLien<T>>();
		this.addSommet(s);
	}
	
	
	
	
	public  AbstractSommet<T> createSommet(T name) {
		return new Sommet<T>(name);
	}

	public void addSommet(T name) {
		if (!this.sommets.add(new Sommet<T>(name))) {
			throw new IllegalArgumentException("Ce sommet existe deja");
		}
	}

	public void addSommet(AbstractSommet<T> s) {
		if (s == null) {
			throw new NullPointerException("");
		}
		this.sommets.add(s);

	}

	protected abstract  void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2) ;
	protected abstract  void addLien(T t1, T t2) ;
		/*
		 * if (!this.contenir(s1)) this.addSommet(s1);
		 * 
		 * if (!this.contenir(s2)) this.addSommet(s2);
		 * 
		 * s1.addSommetAdj(s2);
		 */

	
	protected AbstractSommet<T> getSommet(T t) {
		for(AbstractSommet<T> s : this.sommets) {
			if(s.getSommet().equals(t))
				return s;
		}
		throw new NoSuchElementException("Sommet introuvable");
	}
	

	
	public  boolean contenir(AbstractSommet<T> s) {
		if (s == null) {
			return false;
		}
		return this.sommets.contains(s);
	}
	
	public boolean contenir(T t) {
		if (t == null) {
			return false;
		}
		return this.sommets.stream().anyMatch((s) -> s.getSommet().equals(t));
	}
	
	@Override 
	public String toString() {
		String rtr = ""; 
		for(AbstractSommet<T> s : this.sommets) {
			rtr += s.toString() + "\n";
		}
		for(AbstractLien<T> l : this.liens) {
			rtr += l.toString() + "\n";
		}
		return rtr;
	
	}
}
