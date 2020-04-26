package nfa032.td.td7;

/**
 * Extension de employé représentatant un cadre qui a une équipe d'employé
 * 
 * @author bbsebb
 * @see Employe
 */
public class Cadre extends Employe {

	Employe[] e;

	public Cadre() {
		super();
	}

	/**
	 * Permet de créer un cadre
	 * 
	 * @param nom    du cadre
	 * @param indice du salaire du cadre
	 * @param e      liste d'employé de l'équipe du cadre
	 */
	public Cadre(String nom, int indice, Employe[] e) {
		super(nom, indice);
		this.e = e;
	}

	/**
	 * affiche l'équipe du cadre
	 */
	public void afficherEquipe() {
		System.out.println("L'équipe est composé de " + e.length + " qui sont : ");
		for (Employe employe : e) {
			employe.afficher();
		}
	}

}
