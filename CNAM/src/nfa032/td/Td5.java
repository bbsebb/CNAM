package nfa032.td;

public class Td5 {
	public static void main(String[] args) {
		// Exercice 3.1.2
		Banque b = new Banque("test");
		Titulaire tPaul, tPierre, tFatima;
		tPaul = new Titulaire("Paul");
		tPierre = new Titulaire("Pierre");
		tFatima = new Titulaire("Fatima");
		Titulaire[] tab1 = { tPaul, tFatima };
		Titulaire[] tab2 = { tFatima };
		Titulaire[] tab3 = { tPierre };
		try {
			b.creationCompte(tab1);
			b.creationCompte(tab2);
			b.creationCompte(tab3);

			tFatima.recevoirProcuration(tPierre.donnerProcuration(2));
		} catch (NonInitialise | MauvaisNumeroCompte e) {
			e.printStackTrace();
		}

		tPaul.afficherComptes();
		tPierre.afficherComptes();
		tFatima.afficherComptes();

	}
}

class TableauCompte {
	Compte4[] tab;
	int longueur;

	TableauCompte(int n) {
		tab = new Compte4[n];
	}

	void ajouter(Compte4 c) throws NonInitialise {
		if (c == null) {
			throw new NonInitialise();
		}
		if (longueur < tab.length) {
			tab[longueur] = c;
			longueur++;
		}
	}

	void afficher() {

		for (Compte4 c : tab) {
			if (c != null) {
				c.afficher();
			}
		}
	}

}

class Banque {
	String nom;
	TableauCompte tous = new TableauCompte(50);

	Banque(String n) {
		nom = n;
	}

	public void creationCompte(Titulaire[] t) throws NonInitialise {
		Compte4 c = new Compte4();
		for (Titulaire titulaire : t) {
			titulaire.ajouterCompte(c);
			tous.ajouter(c);
		}
	}
}

class Titulaire {
	String nom;
	short nbr = 0;
	TableauCompte mesComptes = new TableauCompte(10);
	TableauCompte autresComptes = new TableauCompte(100);

	Titulaire(String n) {
		nom = n;
	}

	void ajouterCompte(Compte4 c) throws NonInitialise {
		this.mesComptes.ajouter(c);
	}

	void afficherComptes() {
		System.out.println("Titulaire : " + this.nom);
		this.mesComptes.afficher();
		System.out.println("Procuration : ");
		this.autresComptes.afficher();
	}

	void recevoirProcuration(Compte4 c) throws NonInitialise {
		this.autresComptes.ajouter(c);
	}

	Compte4 donnerProcuration(int n) throws MauvaisNumeroCompte {
		Compte4[] tabComptes = this.mesComptes.tab;

		Compte4 rtr = null;
		for (Compte4 tabCompte : tabComptes) {
			if (tabCompte != null) {
				if (tabCompte.numero == n) {
					rtr = tabCompte;
				} else {
					throw new MauvaisNumeroCompte();
				}
			}
		}
		return rtr;
	}

	boolean virement() {

		return false;
	}

}

class Compte4 {
	static int numeroBis = 0;
	int numero = 0;
	int solde = 0;

	Compte4() {
		this.numero = numeroBis;
		numeroBis++;
	}

	void depot(int n) {
		solde = solde + n;

	}

	void retrait(int n) {
		solde = solde - n;
	}

	void afficher() {
		System.out.println("solde du compte numero " + numero + ": ");
		System.out.println(solde);
	}
}

class NonInitialise extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

class MauvaisNumeroCompte extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}