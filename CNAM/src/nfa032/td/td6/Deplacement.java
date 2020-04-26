package nfa032.td.td6;

public class Deplacement {
	
	private AvecTranslation figure;

	public Deplacement(AvecTranslation a) {
		this.figure = a;
	}
	
	public void top(double deplHor, double deplVer) {
		this.figure.translation(deplHor, deplVer);
	}
	
	public void afficher() {
		figure.affichage();;
	}
}
