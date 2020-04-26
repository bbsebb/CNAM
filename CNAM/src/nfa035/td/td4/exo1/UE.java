package nfa035.td.td4.exo1;

/**
 * C'est une classe abstraite pour la gestion des UE
 * 
 * @author bbseb
 *
 */
public abstract class UE {
	private String codeUE, nomUE, enseignant;

	/**
	 * Constructeur initiant les variable {@link #codeUE}, {@link #nomUE} et
	 * {@link #enseignant}
	 * 
	 * @param codeUE     : code l'UE de l'instance
	 * @param nomUE      : nom de l'UE de l'instance
	 * @param enseignant : enseignant de l'UE de l'instance
	 */
	public UE(String codeUE, String nomUE, String enseignant) {
		this.setCodeUE(codeUE);
		this.setNomUE(nomUE);
		this.setEnseignant(enseignant);
	}

	/**
	 * @return le codeUE
	 */
	public String getCodeUE() {
		return codeUE;
	}

	/**
	 * @param codeUE le codeUE à éditer
	 */
	public void setCodeUE(String codeUE) {
		this.codeUE = codeUE;
	}

	/**
	 * @return le nomUE
	 */
	public String getNomUE() {
		return nomUE;
	}

	/**
	 * @param nomUE le nomUE à éditer
	 */
	public void setNomUE(String nomUE) {
		this.nomUE = nomUE;
	}

	/**
	 * @return le enseignant
	 */
	public String getEnseignant() {
		return enseignant;
	}

	/**
	 * @param enseignant le enseignant à éditer
	 */
	public void setEnseignant(String enseignant) {
		this.enseignant = enseignant;
	}

	public void afficher() {
		System.out.print("UE " + this.getNomUE() + " (" + this.getCodeUE() + ") est enseigné par : "
				+ this.getEnseignant() + ". ");
	}

	public abstract int getnombreTutorat();

}
