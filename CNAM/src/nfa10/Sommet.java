package nfa10;

import java.util.TreeSet;

/**
 * Crée un sommet
 * 
 * @author bbseb
 *
 * @param <T> est le type du nom du sommet
 * @see Graphe
 * @see Arc
 */
public class Sommet<T> {
	protected T s;
	protected TreeSet<Sommet<T>> adjacents,predecesseurs;

	/**
	 * Crée un sommet avec un nom générique
	 * 
	 * @param name est le nom du sommet
	 */
	public Sommet(T name) {
		adjacents = new TreeSet<Sommet<T>>();
		predecesseurs = new TreeSet<Sommet<T>>();
		this.setS(name);
	}

	/**
	 * Ajoute un sommet adjacent
	 * 
	 * @param adj est le sommet adjacent à ajouter
	 * @return vrai si un sommet adjacent a été ajouter, et faux si le sommet contient deja cette ajacent
	 * @see #addPredecesseurs(Sommet)
	 */
	public boolean addAdj(Sommet<T> adj) {
		if(!this.adjacents.contains(adj)) {
			this.adjacents.add(adj);
			adj.addPredecesseurs(this);
			return true;
		} else
			return false;
	}

	/**
	 * Renvoie la liste des adjacents
	 * 
	 * @return la liste des adjacents
	 */
	public TreeSet<Sommet<T>> getAdj() {
		return this.adjacents;
	}

	/**
	 * @return the predecesseurs
	 */
	protected TreeSet<Sommet<T>> getPredecesseurs() {
		return predecesseurs;
	}

	/**
	 * Ajoute un sommet predecesseur (et le sommet adjacent au predecesseurs)
	 * @param vrai si un sommet predecesseur a été ajouter, et faux si le sommet contient deja ce predecesseur
	 * @see #addAdj(Sommet)
	 */
	protected boolean addPredecesseurs(Sommet<T> predecesseur) {
		if(!this.predecesseurs.contains(predecesseur)) {
			this.predecesseurs.add(predecesseur);
			predecesseur.addAdj(this);
			return true;
		} else
			return false;
	}

	/**
	 * Renvoie le nom du sommet
	 * 
	 * @return
	 */
	protected T getS() {
		return s;
	}

	/**
	 * Modifie le nom du sommet
	 * 
	 * @param s est le nouveau nom du sommet
	 */
	public void setS(T s) {
		this.s = s;
	}

	/**
	 * affiche le nom du sommet
	 */
	public void afficheNom() {
		System.out.print("Sommet nommé : " + this.getS() + " ");
	}

	/**
	 * Affiche le nom du sommet et ses adjacents
	 */
	public void afficherAdj() {
		this.afficheNom();
		System.out.print(" Adjacent(s) :  ");
		for (Sommet<T> adjacent : adjacents) {
			adjacent.afficheNom();
			System.out.print(" ");
		}
	}
}
