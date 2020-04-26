package nfa035.td.td4.exo1;

/**
 * Cette classe repr�sent un �tudiant identifi� par un {@link #et num�ro unique}
 * @author bbseb
 * @see Enseignant
 */
public class Etudiant extends Personne{
	/**
	 * Num�ro unique de l'�tudiant
	 */
	private int et;
	private int nbUE=0;
	/**
	 * Cette variable est le nombre total de s�ances de tutorats de l'�tudiant
	 */
	private int nbSeance = 0;
	/**
	 * Ce tableau contient la liste des UE de l'�tudiant
	 */
	UE[] UE = new UE[10];
	
	/**
	 * Constructeur instanciant un �tudiant avec un nom et num�ro d'identification
	 * @param nom : nom de l'�tudiant
	 * @param et : identifiant de l'�tudiant
	 */
	public Etudiant(String nom,int et) {
		super(nom);
		this.setEt(et);	
	}
	/**
	 * Constructeur instanciant un �tudiant avec plusieurs param�tres
	 * @param nom : nom de l'�tudiant
	 * @param et : identifiant de l'�tudiant
	 * @param prenom : prenom de l'�tudiant
	 * @param adresse : adresse de l'�tudiant
	 * @param tel : t�l�phone de l'�tudiant
	 * @param email : email de l'�tudiant
	 */
	public Etudiant(String nom,String prenom,String adresse,String tel,String email,int et) {
		super(nom,prenom,adresse,tel,email);
		this.setEt(et);
	}
	/**
	 * Modifie un �tudiant identifier par sont  {@link #et num�ro d'identification}
	 * @param nom : nom de l'�tudiant � modifier
	 * @param et : identifiant � modifier de l'�tudiant � modifier
	 * @param prenom : prenom de l'�tudiant � modifier
	 * @param adresse : adresse de l'�tudiant � modifier
	 * @param tel : t�l�phone de l'�tudiant � modifier
	 * @param email : email de l'�tudiant � modifier
	 */
	//Override
	public void modifier(String nom,String prenom,String adresse,String tel,String email,int et) {
		super.modifier(nom,prenom,adresse,tel,email);
		this.setEt(et);
	}
	/**
	 * @return le num�ro d'�tudiant
	 */
	public int getEt() {
		return et;
	}
	/**
	 * @param et : numero d'�tudiant � modifier
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
	 * @param UE : Tableau d'UE � modifier
	 */
	public void setUE(UE[] UE) {
		this.UE = UE;
	}

	/**
	 * @return le nombre de s�ances tuteur�es
	 */
	public int getNbSeance() {
		return nbSeance;
	}

	/**
	 * @param nbSeance : modifie le nombre de s�ances tuteur�es
	 */
	public void setNbSeance(int nbSeance) {
		this.nbSeance = nbSeance;
	}

	/**
	 * Ajoute une UE � l'instance de l'�tudiant
	 * @param UE : instance UE � ajouter
	 * @see UE
	 */
	public void ajouterUE(UE UE) {
		this.UE[this.nbUE] = UE;
		this.nbUE ++;
		this.setNbSeance(this.getNbSeance() + UE.getnombreTutorat() );
	}
	
	/**
	 * Affiche le nom, num�ro d'identification de l'�tudiant et le nombre de s�ances tuteur�es auxquelles il/elle participe
	 */
	public void afficher() {
		System.out.println(this.getNom() + " est un �tudiant inscrit au num�ro "+ this.getEt() +". Il/Elle a "+ this.getNbSeance() +" de s�ance inscrite");

	}
	
	/**
	 * Test si l'�tudiant est d�j� inscrit dans une UE
	 * @param codeUE : code de l'UE � tester
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
	 * Affiche les UE de l'�tudiant
	 */
	public void afficherUE() {
		System.out.println("L'�tudiant participe au UE :  ");
		for(int i = 0; i<nbUE;i++) {
			 this.UE[i].afficher() ;
		}
	}	
	
}
