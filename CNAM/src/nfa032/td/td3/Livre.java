package nfa032.td.td3;
/**
 * Créer un instance de livre
 * @author Seb
 *
 */
public class Livre {
	private String nom,auteur,editeur;
	public Livre () {
		this.nom = "inconnue";
		this.auteur="inconnue";
		this.editeur="inconnue";
	}
	/**
	 * 
	 * @param nom du livre
	 * @param auteur du libre
	 * @param editeur du livre
	 */
	public Livre(String nom,String auteur,String editeur) {
		this.nom = nom;
		this.auteur=auteur;
		this.editeur=editeur;
	}
	
	/**
	 * Affiche un livre
	 */
	public void afficher() {
		System.out.println("Nom du livre : "+ this.nom);
		System.out.println("Auteur : "+ this.auteur);
		System.out.println("Editeur : "+ this.editeur);
	}
}
