package nfa035.td.td4.exo1;

public class UEDistance4 extends UE {
	/**
	 * Nombre de séance de tutorat de cette classe d'UE
	 */
	private static int nombreTutorat = 10;

	/**
	 * Constructeur initiant les variable {@link UE#codeUE codeUE}, {@link UE#nomUE nomUE} et
	 * {@link UE#enseignant enseignant}
	 * 
	 * @param codeUE     : code l'UE de l'instance
	 * @param nomUE      : nom de l'UE de l'instance
	 * @param enseignant : enseignant de l'UE de l'instance
	 */
	public UEDistance4(String codeUE, String nomUE, String enseignant) {
		super(codeUE, nomUE, enseignant);

	}

	/**
	 * Affiche l'UE et le nombre de séance de tutorat de cette UE
	 */
	public void afficher() {
		super.afficher();
		System.out.println("Elle se fait à distance (ECTS 4) et aura " + nombreTutorat + " séances de tutorat");
	}

	/**
	 * @return le nombre de tutorat de cette UE
	 */
	public int getnombreTutorat() {
		return nombreTutorat;
	}
}
