package nfa032.td.td7;

public class LaDate {

	int jour;
	int mois;
	int annee;
	// ===================================================
	// l’année en cours ...
	static int CETTE_ANNE = 2005;

	public LaDate(int j, int m, int a) {
		this.jour = j;
		this.mois = m;
		this.annee = a;
	}

	public void ecrire() {
		System.out.println(jour + "/" + mois + "/" + annee);
	}
}
