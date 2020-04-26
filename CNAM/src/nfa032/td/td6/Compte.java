package nfa032.td.td6;

public class Compte implements Convertible{
	private int solde;
	private String titulaire;
	private int numero;
	
	public Compte() {
		titulaire = "inconnu";
		numero = -1;
		solde = 0;
	}
	
	public Compte(int num, String tit) {
		titulaire = tit;
		numero = num;
		solde = 0;
	}

	int getNumero() {
		return numero;
	}

	String getTitulaire() {
		return titulaire;
	}

	int getSolde() {
		return solde;
	}

	void afﬁcher() {
		System.out.println("solde" + this.solde);
	}

	void deposer(int montant) {
		this.solde = this.solde + montant;
	}

	void retirer(int montant) {
		this.solde = this.solde - montant;
	}

	@Override
	public int toInt() {
		
		return this.solde;
	}
}