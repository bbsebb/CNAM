package nfa035.td.td4.exo1;
/**
 * Interface du menu d'affectation des enseignants
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuAffectationEnseignant {
	
	

	/**
	 * Affiche la liste des UE
	 */
	  void listeUE();
	 /**
	  * Affiche la liste des enseignants
	  */
	  void listeEnseignant();
	 /**
	  * Affecte un enseignant � un UE
	  * @param codeUE : code l'ue � affecter
	  * @param nom : nom de l'enseignant � affecter
	  */
	  void affecterEnseignant(String codeUE,String nom);
	  /**
		 * Affiche la liste des �tudiants
		 */
}
