package nfa032.td.td7;
/**
 * Extension de employé représentatant un commercial qui a un salaire différent
 * @author bbsebb
 * @see Employe
 */
public class Commercial extends Employe{
	
	int venteMois = 0;
	public Commercial() {
		super();
	}
	/**
	 * Permet de créer un commercial
	 * @param nom du commercial
	 * @param indice de salaire du commercial
	 */
	public Commercial(String nom, int indice) {
		super(nom,indice);
	}
	
	/**
	 * Renvoie le nombre de vente dans le mois
	 * @return le nombre de vente du mois en CA
	 */
	public int getVenteMois() {
		return venteMois;
	}
	/**
	 * Affecte le nombre de vente dans le mois
	 * @param venteMois est la CA d'un mois
	 */
	public void setVenteMois(int venteMois) {
		this.venteMois = venteMois;
	}
	/**
	 * Calcule et renvoie le salaire en tenant compte d'un intéressement sur les ventes
	 * @see #getVenteMois()
	 */
	public double salaire() {
		return ((int)((super.salaire() + (this.getVenteMois()*5/100))*10))/10;
	}
	
	public void afficher() {

		System.out.println("Commercial");
	}
	
	public void test() {

		System.out.println("Commercial");
	}
}
