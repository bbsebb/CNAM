package nfa032.td.td7;

public class Poulet extends Volaille {
	protected static int poidsAbbatage, prix;

	public Poulet( int poids) {
		super( poids);
		this.espece = "poulet";
		
	}

	public static int getPoidsAbbatage() {
		return poidsAbbatage;
	}

	public static void setPoidsAbbatage(int poidsAbbatage) {
		Poulet.poidsAbbatage = poidsAbbatage;
	}

	public static int getPrix() {
		return prix;
	}

	public static void setPrix(int prix) {
		Poulet.prix = prix;
	}

	@Override
	protected int abattre() {
		
		if(this.Aabattre())
			return Poulet.getPrix();
		else
			return 0;
	}

	@Override
	protected boolean Aabattre() {
		
		if (this.poids >= Poulet.poidsAbbatage)
			return true;
		else
			return false;
	}
}
