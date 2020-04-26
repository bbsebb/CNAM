package nfa032.td.td6;

public class Date implements Convertible{
	// ---Les variables d’instances ---
	int jour;
	int mois;
	int annee;

	// ---Les constructeurs ---
	public Date() {
		this.jour = 1;
		this.mois = 1;
		this.annee = 1;
	}

	public Date(int j, int m, int a) {
		if (m > 0 && m < 13 && j <= longueur(m, a)) {
			this.jour = j;
			this.mois = m;
			this.annee = a;
		} else {
			throw new ErreurDate();
		}
	}

	// ---Les methodes ---
	public void afﬁcherDate() {
		System.out.println(this.jour + " , " + this.mois + " , " + this.annee);
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int aa) {
		this.annee = aa;
	}

	public void passerAuLendemain() {
		if (this.jour < longueur(this.mois, this.annee)) {
			this.jour = this.jour + 1;
		} else if (this.mois == 12) {
			this.jour = 1;
			this.annee = this.annee + 1;
			this.mois = 1;
		} else {
			this.jour = 1;
			this.mois = this.mois + 1;
		}
	}

	public static boolean bissextile(int annee) {
		return ((annee % 4 == 0) && (!(annee % 100 == 0) || annee % 400 == 0));
	}

	public static int longueur(int m, int a) {
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			return 31;
		}

		else if (m == 2) {
			if (bissextile(a)) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 30;
		}

	}

	@Override
	public int toInt() {
		
		return this.jour*this.mois*this.annee;
	}

}

class ErreurDate extends Error {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
