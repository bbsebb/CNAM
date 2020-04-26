package nfa032.cours;

public class CompteBancaire {
	String nomProprietaire;
	char[] numero;
	double solde;

	public CompteBancaire() {
	}

	public CompteBancaire(String proprio, char[] num, double montant) {
		this.nomProprietaire = proprio;
		this.numero = num;
		this.solde = montant;
	}

	public double getSoldeCourant() {
		return this.solde;
	}

	public void deposer(double montant) {
		this.solde = solde + montant;
	}

	public void retirer(double montant) {
		System.out.println("Appel de retrait sur compte simple");
		if (this.solde < montant) {
			throw new provisionInsuffisanteErreur();
		} else {
			solde = solde - montant;
		}
	}

	public void virerVers(CompteBancaire c, double montant) {
		c.retirer(montant);
		this.deposer(montant);
	}
}

class provisionInsuffisanteErreur extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}