package nfa032.td.td7;

/**
 * Classe représentant un employé
 * 
 * @author bbsebb
 * @see Cadre
 * @see Commercial
 * @see Employes
 */
public class Employe {
	/**
	 * 
	 */
	private int id, indice;
	private String nom;
	private static double base = 100;
	private static int idBis = 0;

	public Employe() {

	}

	/**
	 * Permet de créer un employé.
	 * 
	 * @param nom    de l'employé
	 * @param indice pour calculer sa paye qui est multiplié par la base.
	 */
	public Employe(String nom, int indice) {
		this.id = idBis;
		idBis++;
		this.setNom(nom);
		this.setIndice(indice);
	}

	/**
	 * Renvoie le nom
	 * 
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Modifie le nom
	 * 
	 * @param nom que le souhaite mettre à la place de l'ancien nom
	 */
	protected void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Renvoie le matricule
	 * 
	 * @return le matricule
	 */
	public int getId() {
		return id;
	}

	/**
	 * Renvoie l'indice
	 * 
	 * @return l'indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * Modifier l'ancien indice par un nouveau
	 * 
	 * @param indice est le nouvelle indice
	 */
	protected void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * Renvoie le salaire mensuel
	 * 
	 * @return le salaire mensuel
	 */
	public double salaire() {
		return this.indice * base;
	}

	/**
	 * Affiche les informations sur l'employé
	 */
	public void afficher() {
		System.out.println(
				this.nom + " est un employé avec le matricule : " + this.id + " qui à un salaire de " + this.salaire());
	}

	/**
	 * Modifie la base de calcule
	 * 
	 * @param b est la nouvelle base de calcule
	 */
	public static void setBase(double b) {
		base = b;
	}

}
