package nfa035.td.td4.exo1;
/**
 * Interface du menu de gestion des �tudiants
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuEtudiants {
	/**
	 * Affiche la liste des �tudiants
	 */
	void listeEtudiants();
	
	/**
	 * Affiche les d�tails d'un �tudiant
	 * @param et : num�ro de l'�tudiant � afficher
	 */
	void consulterEtudiant(int et);
	
	/**
	 * Ajoute un �tudiant 
	 * @param et : num�ro de l'�tudiant � ajouter
	 * @param nom : nom de l'�tudiant � ajouter
	 * @param prenom ; pr�nom de l'�tudiant � ajouter
	 * @param adresse : adresse de l'�tudiant � ajouter
	 * @param tel : t�l�phone de l'�tudiant � ajouter
	 * @param email : email de de l'�tudiant � ajouter
	 * @see #ajouterEtudiant(int, String)
	 */
	void ajouterEtudiant(int et,String nom,String prenom,String adresse,String tel,String email);
	
	/**
	 * Ajoute un �tudiant 
	 * @param et : num�ro de l'�tudiant � ajouter
	 * @param nom : nom de l'�tudiant � ajouter
	 * @see #ajouterEtudiant(int, String, String, String, String, String)
	 */
	void ajouterEtudiant(int et,String nom);
	
	/**
	 * Modifie un �tudiant
	 * @param et : num�ro de l'�tudiant � modifier
	 * @param nom : nom de l'�tudiant � modifier
	 * @param prenom ; pr�nom de l'�tudiant � modifier
	 * @param adresse : adresse de l'�tudiant � modifier
	 * @param tel : t�l�phone de l'�tudiant � modifier
	 * @param email : email de de l'�tudiant � modifier
	 * 
	 */
	void modifierEtudiant(int et,String nom,String prenom,String adresse,String tel,String email);
}
