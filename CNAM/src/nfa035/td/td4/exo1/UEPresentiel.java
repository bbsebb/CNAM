package nfa035.td.td4.exo1;

public class UEPresentiel extends UE {

	String salle;

	/**
	 * Constructeur initiant les variable {@link UE#codeUE}, {@link UE#nomUE} et
	 * {@link UE#enseignant}
	 * 
	 * @param codeUE     : code l'UE de l'instance
	 * @param nomUE      : nom de l'UE de l'instance
	 * @param enseignant : enseignant de l'UE de l'instance
	 */
	public UEPresentiel(String codeUE, String nomUE, String enseignant) {
		super(codeUE, nomUE, enseignant);
		this.setSalle("inconnu");

	}

	/**
	 * Constructeur initiant les variable {@link UE#codeUE}, {@link UE#nomUE},
	 * {@link UE#enseignant} et{@link #salle}
	 * 
	 * @param codeUE     : code l'UE de l'instance
	 * @param nomUE      : nom de l'UE de l'instance
	 * @param enseignant : enseignant de l'UE de l'instance
	 * @param salle      : salle de l'UE de l'instance
	 */
	public UEPresentiel(String codeUE, String nomUE, String enseignant, String salle) {
		super(codeUE, nomUE, enseignant);
		this.setSalle(salle);

	}

	/**
	 * @return le salle
	 */
	public String getSalle() {
		return salle;
	}

	/**
	 * @param salle le salle à éditer
	 */
	public void setSalle(String salle) {
		this.salle = salle;
	}

	/**
	 * Affiche l'UE et la salle de cette UE
	 */
	public void afficher() {
		super.afficher();
		System.out.println("Elle se déroule dans la salle : " + this.getSalle() + ". ");
	}

	public int getnombreTutorat() {
		return 0;
	}

}
