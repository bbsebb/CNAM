package nfa035.td.compte;

public class MontantNegatif extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MontantNegatif(int montant) {
		System.out.println("Le montant " + montant + " est négatif ");
	}
}
