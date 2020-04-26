package nfa035.td.td4.exo1;

/**
 * Cette classe représent un étudiant identifié par un {@link #et numéro unique}
 * @author bbseb
 * @see Enseignant
 */
public class Etudiant extends Personne{
	/**
	 * Numéro unique de l'étudiant
	 */
	private int et;
	private int nbUE=0;
	/**
	 * Cette variable est le nombre total de séances de tutorats de l'étudiant
	 */
	private int nbSeance = 0;
	/**
	 * Ce tableau contient la liste des UE de l'étudiant
	 */
	UE[] UE = new UE[10];
	
	/**
	 * Constructeur instanciant un étudiant avec un nom et numéro d'identification
	 * @param nom : nom de l'étudiant
	 * @param et : identifiant de l'étudiant
	 */
	public Etudiant(String nom,int et) {
		super(nom);
		this.setEt(et);	
	}
	/**
	 * Constructeur instanciant un étudiant avec plusieurs paramètres
	 * @param nom : nom de l'étudiant
	 * @param et : identifiant de l'étudiant
	 * @param prenom : prenom de l'étudiant
	 * @param adresse : adresse de l'étudiant
	 * @param tel : téléphone de l'étudiant
	 * @param email : email de l'étudiant
	 */
	public Etudiant(String nom,String prenom,String adresse,String tel,String email,int et) {
		super(nom,prenom,adresse,tel,email);
		this.setEt(et);
	}
	/**
	 * Modifie un étudiant identifier par sont  {@link #et numéro d'identification}
	 * @param nom : nom de l'étudiant à modifier
	 * @param et : identifiant à modifier de l'étudiant à modifier
	 * @param prenom : prenom de l'étudiant à modifier
	 * @param adresse : adresse de l'étudiant à modifier
	 * @param tel : téléphone de l'étudiant à modifier
	 * @param email : email de l'étudiant à modifier
	 */
	//Override
	public void modifier(String nom,String prenom,String adresse,String tel,String email,int et) {
		super.modifier(nom,prenom,adresse,tel,email);
		this.setEt(et);
	}
	/**
	 * @return le numéro d'étudiant
	 */
	public int getEt() {
		return et;
	}
	/**
	 * @param et : numero d'étudiant à modifier
	 */
	public void setEt(int et) {
		this.et = et;
	}
	
	/**
	 * @return les uE
	 */
	public UE[] getUE() {
		return UE;
	}

	/**
	 * @param UE : Tableau d'UE à modifier
	 */
	public void setUE(UE[] UE) {
		this.UE = UE;
	}

	/**
	 * @return le nombre de séances tuteurées
	 */
	public int getNbSeance() {
		return nbSeance;
	}

	/**
	 * @param nbSeance : modifie le nombre de séances tuteurées
	 */
	public void setNbSeance(int nbSeance) {
		this.nbSeance = nbSeance;
	}

	/**
	 * Ajoute une UE à l'instance de l'étudiant
	 * @param UE : instance UE à ajouter
	 * @see UE
	 */
	public void ajouterUE(UE UE) {
		this.UE[this.nbUE] = UE;
		this.nbUE ++;
		this.setNbSeance(this.getNbSeance() + UE.getnombreTutorat() );
	}
	
	/**
	 * Affiche le nom, numéro d'identification de l'étudiant et le nombre de séances tuteurées auxquelles il/elle participe
	 */
	public void afficher() {
		System.out.println(this.getNom() + " est un étudiant inscrit au numéro "+ this.getEt() +". Il/Elle a "+ this.getNbSeance() +" de séance inscrite");

	}
	
	/**
	 * Test si l'étudiant est déjà inscrit dans une UE
	 * @param codeUE : code de l'UE à tester
	 * @return vrai si il est dans l'UE ou faux si il n'est pas dedant
	 */
	public boolean estDAnsUE(String codeUE) {
		for(int i = 0; i<nbUE;i++) {
			 if (this.UE[i].getCodeUE().equals(codeUE)) 
					 return true;
		}
		return false;
	}
	
	/**
	 * Affiche les UE de l'étudiant
	 */
	public void afficherUE() {
		System.out.println("L'étudiant participe au UE :  ");
		for(int i = 0; i<nbUE;i++) {
			 this.UE[i].afficher() ;
		}
	}	
	
}
