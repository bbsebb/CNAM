package rcp005;

import java.util.LinkedHashSet;
import java.util.Objects;

public abstract class AbstractSommet<T extends Comparable<T>> implements Comparable<AbstractSommet<T>> {
	private T sommet;
	private LinkedHashSet<AbstractSommet<T>> adjacent;
	private int dateDebut;
	private int dateFin;
	private Couleur couleur;

	public AbstractSommet() {
		super();
		this.sommet = null;
		this.adjacent = new LinkedHashSet<AbstractSommet<T>>();

	}

	protected AbstractSommet(T sommet) {
		this.sommet = sommet;
		this.sommet = sommet;
		this.dateDebut = 0;
		this.dateFin = 0;
		this.adjacent = new LinkedHashSet<AbstractSommet<T>>();
		this.couleur = Couleur.BLANC;
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

	/**
	 * @return the adjacent
	 */
	protected LinkedHashSet<AbstractSommet<T>> getAdjacent() {
		return adjacent;
	}

	/**
	 * @param adjacent the adjacent to set
	 */
	protected void setAdjacent(LinkedHashSet<AbstractSommet<T>> adjacent) {
		this.adjacent = adjacent;
	}

	/**
	 * @return the dateDebut
	 */
	protected int getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	protected void setDateDebut(int dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	protected int getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	protected void setDateFin(int dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the couleur
	 */
	protected Couleur getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	protected void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	protected void resetCouleur() {
		this.setCouleur(Couleur.BLANC);
	}

	protected void addLien(AbstractSommet<T> s) {
		if (s != null)
			this.adjacent.add(s);
	}

	protected void removeLien(AbstractSommet<T> s) {
		if (s != null)
			this.adjacent.remove(s);
	}

	protected void removeAllLien() {
		this.adjacent.forEach(this::removeLien);
	}
	
	protected int getDegre() {
		return this.getAdjacent().size();
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
	public int compareTo(AbstractSommet<T> o) {
		if (this.dateFin < o.dateFin) {
			return 1;
		} else if (this.dateFin > o.dateFin) {
			return -1;
		} else {
			return this.getSommet().compareTo(o.getSommet());
		}
	}

	@Override
	public String toString() {
		return "Sommet " + sommet.toString() + " (Couleur : " + this.getCouleur() + " date début : "
				+ this.getDateDebut() + " date fin : " + this.getDateFin() + ")";
	}

}
