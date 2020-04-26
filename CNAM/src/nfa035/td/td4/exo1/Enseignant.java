package nfa035.td.td4.exo1;
/**
 * Cette classe repr�sent un �tudiant identifi� par un {@link Personne#nom nom} et un {@link Personne#email email} 
 * @author bbseb
 * @see Etudiant
 */
public class Enseignant extends Personne {
	private int nbSeance =0;
	/**
	 * Constructeur instanciant un enseignant 
	 * @param nom : nom de l'enseignant
	 * @param email : email de l'enseignant
	 */
	public Enseignant(String nom, String email) {
		super(nom);
		this.setEmail(email);

	}

	/**
	 * 
	 * Constructeur instanciant un enseignant 
	 * @param nom : nom de l'enseignant
	 * @param prenom : prenom de l'enseignant
	 * @param adresse : adresse de l'enseignant
	 * @param tel : t�l�phone de l'enseignant
	 * @param email : email de l'enseignant
	 */
	public Enseignant(String nom, String prenom, String adresse, String tel, String email) {
		super(nom, prenom, adresse, tel, email);
	}
	

	
	/**
	 * @return le nombre de s�ance de tutorat 
	 */
	public int getNbSeance() {
		return nbSeance;
	}

	/**
	 * @param nbSeance : le nombre de s�ance de tutorat 
	 */
	public void setNbSeance(int nbSeance) {
		this.nbSeance = nbSeance;
	}

	/**
	 * Affiche le nom et l'email de l'enseignant, ainsi que son nombre de s�ance de tutorat.
	 */
	public void afficher() {
		System.out.println(this.getNom() + " est un enseignant. Son email est "+ this.getEmail() +". Il/Elle est tuteur(e) pour "+ this.getNbSeance() +" s�ance(s)");
	}
}
