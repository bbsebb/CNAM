package nfa035.td.td4.exo1;
/**
 * Interface du menu de gestion des étudiants
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuEtudiants {
	/**
	 * Affiche la liste des étudiants
	 */
	void listeEtudiants();
	
	/**
	 * Affiche les détails d'un étudiant
	 * @param et : numéro de l'étudiant à afficher
	 */
	void consulterEtudiant(int et);
	
	/**
	 * Ajoute un étudiant 
	 * @param et : numéro de l'étudiant à ajouter
	 * @param nom : nom de l'étudiant à ajouter
	 * @param prenom ; prénom de l'étudiant à ajouter
	 * @param adresse : adresse de l'étudiant à ajouter
	 * @param tel : téléphone de l'étudiant à ajouter
	 * @param email : email de de l'étudiant à ajouter
	 * @see #ajouterEtudiant(int, String)
	 */
	void ajouterEtudiant(int et,String nom,String prenom,String adresse,String tel,String email);
	
	/**
	 * Ajoute un étudiant 
	 * @param et : numéro de l'étudiant à ajouter
	 * @param nom : nom de l'étudiant à ajouter
	 * @see #ajouterEtudiant(int, String, String, String, String, String)
	 */
	void ajouterEtudiant(int et,String nom);
	
	/**
	 * Modifie un étudiant
	 * @param et : numéro de l'étudiant à modifier
	 * @param nom : nom de l'étudiant à modifier
	 * @param prenom ; prénom de l'étudiant à modifier
	 * @param adresse : adresse de l'étudiant à modifier
	 * @param tel : téléphone de l'étudiant à modifier
	 * @param email : email de de l'étudiant à modifier
	 * 
	 */
	void modifierEtudiant(int et,String nom,String prenom,String adresse,String tel,String email);
}
