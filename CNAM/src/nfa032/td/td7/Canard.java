package nfa032.td.td7;

public class Canard  extends Volaille{
	protected static int poidsAbbatage, prix;
	public Canard( int poids) {
		super( poids);
		this.espece="canard";
		
	}
	public static int getPoidsAbbatage() {
		return poidsAbbatage;
	}
	public static void setPoidsAbbatage(int poidsAbbatage) {
		Canard.poidsAbbatage = poidsAbbatage;
	}
	public static int getPrix() {
		return prix;
	}
	public static void setPrix(int prix) {
		Canard.prix = prix;
	}
	@Override
	protected int abattre() {
		
		if(this.Aabattre())
			return Canard.getPrix();
		else
			return 0;
	}
	@Override
	protected boolean Aabattre() {
		
		
		if (this.poids >= Canard.poidsAbbatage)
			return true;
		else
			return false;
	}

	
}
