package rcp005;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public abstract class AbstractGraphe<T extends Comparable<T> & Cloneable> implements Cloneable {
	protected TreeSet<AbstractSommet<T>> sommets;
	boolean connexe;
	boolean trie;

	public AbstractGraphe() {
		this.sommets = new TreeSet<AbstractSommet<T>>();
	}

	protected AbstractGraphe(AbstractSommet<T> s) {
		this.sommets = new TreeSet<AbstractSommet<T>>();
		this.addSommet(s);
	}

	protected void setSommet(T t1, T t2) {
		this.sommets.stream().filter((s) -> s.getSommet().equals(t1)).limit(1).forEach((s) -> s.setSommet(t2));
		;
	}

	protected AbstractSommet<T> getSommet(T t) {
		for (AbstractSommet<T> s : this.sommets) {
			if (s.getSommet().equals(t))
				return s;
		}
		throw new NoSuchElementException("Sommet introuvable");
	}

	protected AbstractSommet<T> createSommet(T name) {
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

	public int getDegre(AbstractSommet<T> s) {
		if (s == null) {
			throw new NullPointerException("");
		}
		if (!this.contenir(s))
			throw new IllegalArgumentException("");

		return s.getDegre();
	}

	public int getDegre(T t) {
		return this.getDegre(this.getSommet(t));
	}

	public boolean contenir(AbstractSommet<T> s) {
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

	public void parcoursEnProfondeur() {
		this.sommets.forEach((s) -> s.resetCouleur());
		LinkedList<AbstractSommet<T>> pile = new LinkedList<AbstractSommet<T>>();
		int date = 0;
		int classe = 0;
		for (AbstractSommet<T> s : this.sommets) {
			if (s.getCouleur() == Couleur.BLANC) {
				pile.push(s);
				this.DFSpreTraitement(s, ++date);
				while (!pile.isEmpty()) {

					boolean blancPile;
					AbstractSommet<T> tete = pile.peek();
					do {
						tete = pile.peek();
						blancPile = false;
						for (AbstractSommet<T> adj : tete.getAdjacent()) {
							if (adj.getCouleur() == Couleur.BLANC) {
								pile.push(adj);
								this.DFSpreTraitement(adj, ++date);
								blancPile = true;
								break;
							} else {
								blancPile = false;
							}

						}
					} while (blancPile);

					this.DFSpostTraitement(pile.pop(), ++date);
				}
			}
		}

		this.updateSort();

	}

	public void parcoursEnProfondeurRec() {
		this.sommets.forEach((s) -> s.resetCouleur());
		int date = 0;
		int classe = 0;
		Iterator<AbstractSommet<T>> it = this.sommets.iterator();
		while (it.hasNext()) {
			AbstractSommet<T> s = (AbstractSommet<T>) it.next();
			if (s.getCouleur() == Couleur.BLANC)
				date = this.parcoursEnProfondeurRec_(s, date);
			classe++;
		}
		this.updateSort();
	}

	private int parcoursEnProfondeurRec_(AbstractSommet<T> s, int date) {
		this.DFSpreTraitement(s, ++date);
		for (AbstractSommet<T> adj : s.getAdjacent()) {
			if (adj.getCouleur() == Couleur.BLANC)
				date = this.parcoursEnProfondeurRec_(adj, date);
		}
		this.DFSpostTraitement(s, ++date);
		return date;
	}

	protected int parcoursEnProfondeurRec(AbstractSommet<T> s, int date) {
		this.DFSpreTraitement(s, ++date);
		for (AbstractSommet<T> adj : s.getAdjacent()) {
			if (adj.getCouleur() == Couleur.BLANC)
				date = this.parcoursEnProfondeurRec_(adj, date);
		}
		this.DFSpostTraitement(s, ++date);
		this.updateSort();
		return date;
	}

	public AbstractGraphe<T> reverse() throws CloneNotSupportedException {

		@SuppressWarnings("unchecked")
		AbstractGraphe<T> g = (AbstractGraphe<T>) this.clone();
		g.sommets.forEach((s) -> s.inverse());
		return g;
	}
	
	private void DFSpreTraitement(AbstractSommet<T> s, int date) {
		s.setCouleur(Couleur.GRIS);
		s.setDateDebut(date);
	}

	private void DFSpostTraitement(AbstractSommet<T> s, int date) {
		s.setCouleur(Couleur.NOIR);
		s.setDateFin(date);
	}

	private void updateSort() {
		TreeSet<AbstractSommet<T>> sommets = new TreeSet<AbstractSommet<T>>(this.sommets);
		this.sommets.clear();
		sommets.forEach((s) -> this.sommets.add(s));
	}

	@Override
	public String toString() {
		String rtr = "";
		for (AbstractSommet<T> s : this.sommets) {
			rtr += s.toString() + "\n";
			for (AbstractSommet<T> adj : s.getAdjacent()) {
				rtr += "\t" + adj.toString() + "\n";
			}
			rtr += "\n";
		}
		return rtr;
	}

	public String toStringSommet() {
		String rtr = "";
		for (AbstractSommet<T> s : this.sommets) {
			rtr += s.toString() + "\n";
			rtr += "\n";
		}
		return rtr;
	}

	public String toStringLien() {
		String rtr = "";
		for (AbstractSommet<T> s : this.sommets) {

			for (AbstractSommet<T> adj : s.getAdjacent()) {
				rtr += s.toString() + " ----- " + adj.toString() + "\n";
			}
		}
		return rtr;
	}

	protected abstract void addLien(AbstractSommet<T> s1, AbstractSommet<T> s2);

	protected void addLien(T t1, T t2) {
		this.addLien(this.getSommet(t1), this.getSommet(t2));
	}


	protected abstract Object clone() throws CloneNotSupportedException ;
	
	
}
