package nfa032.td.td3;

public class Produit {
	private String nom;
	private int ref,prix;
	static private int numRef = 0;
	
	public Produit () {
		this.setNom("Inconnu");
		numRef ++;
		this.setRef(numRef);
		this.setPrix(0);
	}
	
	public Produit(String nom, int prix) {
		this.setNom(nom);
		numRef ++;
		this.setRef(numRef);
		this.setPrix(prix);		
	}
	
	public void afficher () {
		System.out.println("Nom : " + this.nom);
		System.out.println("Réfenrence : " + this.ref);
		System.out.println("prix : " + this.prix);
	}
	
	/**
	 * @return the prix
	 */
	public int getPrix() {
		return this.prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the ref
	 */
	public int getRef() {
		return ref;
	}

	/**
	 * @param ref the ref to set
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}
	
}
