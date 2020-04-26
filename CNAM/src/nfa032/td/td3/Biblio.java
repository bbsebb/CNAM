package nfa032.td.td3;

import java.util.ArrayList;
/**
 * Enregistre une collection de livre
 *
 * @author Seb
 *
 */
public class Biblio {
	/**
	 *  Liste des livres
	 */
	private ArrayList<Livre> listLivre = new ArrayList<Livre>();
	private String nom;
	public Biblio () {
		this.nom ="Inconnu";
	}
	/**
	 * 
	 * @param nom de la biblioth�que
	 */
	public Biblio (String nom) {	
		this.nom = nom;
	}	
	
	/**
	 * Ajouter un livre � la biblioth�que
	 * @param livre d'une classe Livre
	 * @see Livre
	 */
	public void ajouter (Livre livre) {
		this.listLivre.add(livre);
	}
	
	/**
	 *  Affiche les livres de la biblioth�que
	 */
	public void afficher() {
		System.out.println("Liste des livres de la biblioth�que "+ this.nom);
		for(Livre livre : this.listLivre) {
			System.out.println("************************");
			livre.afficher();
		}
	}
}
