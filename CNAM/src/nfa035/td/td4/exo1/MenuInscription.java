package nfa035.td.td4.exo1;
/**
 * Interface du menu d'inscription des étudiants au UE
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuInscription {
	/**
	 * Affiche la liste des UE
	 */
	void listeUE();

	/**
	 * Affiche la liste des étudiants et de leurs UE
	 */
	void afficherUEEtudiant();

	/**
	 * Inscrit un étudiant à une UE
	 * @param et
	 * @param codeUE
	 */
	boolean ajouterUEEtudiant(int et, String codeUE);
}
