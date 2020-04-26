package nfa032.cours;

public class CompteAvecDecouvert extends CompteBancaire {
	double decouvertMax;

	public void fixerDecouvertMaximal(double montant) {
		this.decouvertMax = montant;
	}

	public CompteAvecDecouvert(String proprio, char[] num, double montant, double decouvertMax) {

		super(proprio, num, montant);
		this.decouvertMax = decouvertMax;
	}

	public void retirer(double montant) {
// Terminal.ecrireStringln("Appel de retrait sur compte avec decouvert");
		if (this.solde - montant < -decouvertMax) {
			throw new provisionInsuffisanteErreur();
		} else {
			solde = solde - montant;
		}
	}
}