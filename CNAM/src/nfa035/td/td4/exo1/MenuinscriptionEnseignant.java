package nfa035.td.td4.exo1;

/**
 * Interface du menu d'inscription des enseignant
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuinscriptionEnseignant {

	/**
	 * Affiche la liste des UE
	 */
	void listeUE();

	/**
	 * Affiche la liste des enseignants
	 */
	void listeEnseignant();

	/**
	 * Affiche un enseignant
	 * 
	 * @param nom : nom de l'enseignant � afficher
	 */
	void consulterEnseignant(String nom);

	/**
	 * Liste les UE d'un enseignant
	 * 
	 * @param nom : non de l'enseignant
	 */
	void listeUEEnseignant(String nom);

	/**
	 * AJoute un enseignant
	 * 
	 * @param nom     : nom de l'enseignant � ajouter
	 * @param prenom  ; pr�nom de l'enseignant � ajouter
	 * @param adresse : adresse de l'enseignant � ajouter
	 * @param tel     : t�l�phone de l'enseignant � ajouter
	 * @param email   : email de de l'enseignant � ajouter
	 * @see #ajouterEnseignant(String, String)
	 */
	void ajouterEnseignant(String nom, String prenom, String adresse, String tel, String email);

	/**
	 * Ajoute un enseignant
	 * 
	 * @param nom    : nom de l'enseignant � ajouter
	 * @param prenom ; pr�nom de l'enseignant � ajouter
	 * @see #ajouterEnseignant(String, String, String, String, String)
	 */
	void ajouterEnseignant(String nom, String prenom);

	/**
	 * Modifie un enseignant
	 * 
	 * @param nom     : nom de l'enseignant � modifier
	 * @param prenom  ; pr�nom de l'enseignant � modifier
	 * @param adresse : adresse de l'enseignant � modifier
	 * @param tel     : t�l�phone de l'enseignant � modifier
	 * @param email   : email de de l'enseignant � modifier
	 */
	void modifierEnseignant(String nom, String prenom, String adresse, String tel, String email);
}
