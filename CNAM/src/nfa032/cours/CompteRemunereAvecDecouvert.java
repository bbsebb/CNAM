package nfa032.cours;

public class CompteRemunereAvecDecouvert extends CompteRemunere {
	double decouvertMax;

	public void fixeDecouvertMaximal(double montant) {
		this.decouvertMax = montant;
	}

	public CompteRemunereAvecDecouvert(String proprio, char[] num, double montant, double taux, double decouvertMax) {

		super(proprio, num, montant, taux);
// ici super designe la classe CompteRemunere
		fixeDecouvertMaximal(decouvertMax);
	}

	public void retrait(double montant) {
		System.out.println("Appel de retrait sur compte remunere avec decouvert");
		if (this.solde - montant < -decouvertMax) {
			throw new provisionInsuffisanteErreur();
		} else {
			solde = solde - montant;
		}
	}
}