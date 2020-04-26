package nfa035.td.compte;

public class Compte {
	private int solde;
	private String titulaire;

	public Compte(int solde, String titulaire) {
		this.solde = solde;
		this.titulaire = titulaire; // initialisation des titulaires
	}

	public void depot(int montant) throws MontantNegatif {
//if (montant < 0) throw new montantnegatif(montant);
		solde = solde + montant;
	}

	public void retrait(int montant) throws MontantNegatif, Decouvert {
		if (montant < 0)
			throw new MontantNegatif(montant);
		if (montant > solde)
			throw new Decouvert();
		solde = solde - montant;
	}

	public void affiche() {
		System.out.println("solde du compte de " + titulaire + " :" + solde);
	}
}
