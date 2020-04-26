package nfa035.td.td4.exo1;

/**
 * Interface du menu d'inscription des UE
 * 
 * @see CentreReims
 * @see Programme
 */
public interface MenuinscriptionUE {
	

	/**
	 * Affiche la liste des UE
	 */
	void listeUE();
	/**
	 * Ajoute une UE enprésentiel
	 * @param codeUE : Code l'UE à ajouter
	 * @param intituleUE : intitulé de l'UE à ajouter
	 * @param enseignant : Enseignant de l'UE à ajouter
	 * @see #ajouterUEDistance4(String, String, String)
	 * @see #ajouterUEDistance5(String, String, String)
	 */
void ajouterUEPresentiel(String codeUE, String intituleUE,String enseignant);
/**
 * Ajoute une UE à distance de ETC4
 * @param codeUE : Code l'UE à ajouter
 * @param intituleUE : intitulé de l'UE à ajouter
 * @param enseignant : Enseignant de l'UE à ajouter
 * @see #ajouterUEPresentiel(String, String, String)
 * @see #ajouterUEDistance5(String, String, String)
 */
void ajouterUEDistance4(String codeUE, String intituleUE,String enseignant);
/**
 * Ajoute une UE à distance de ETC5
 * @param codeUE : Code l'UE à ajouter
 * @param intituleUE : intitulé de l'UE à ajouter
 * @param enseignant : Enseignant de l'UE à ajouter
 * @see #ajouterUEPresentiel(String, String, String)
 * @see #ajouterUEDistance4(String, String, String)
 */
void ajouterUEDistance5(String codeUE, String intituleUE,String enseignant);
}
