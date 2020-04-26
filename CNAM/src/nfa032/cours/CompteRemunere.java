package nfa032.cours;

public class CompteRemunere extends CompteBancaire {
	double taux;
	double interets;

	public void fixerTaux(double montant) {
		this.taux = montant;
	}

	public CompteRemunere(String proprio, char[] num, double montant,

			double taux) {
		super(proprio, num, montant);
		fixerTaux(montant);
		interets = 0.0;
	}

	public void retirer(double montant) {
// Terminal.ecrireStringln("Appel de retrait sur compte remunere");
		if (this.solde < montant) {
			throw new provisionInsuffisanteErreur();

		} else {
			solde = solde - montant;
		}
	}

	public void calculerInteret() {
		interets = interets + 1.0; // bien sur, le code reel est plus complexe
	}
}
