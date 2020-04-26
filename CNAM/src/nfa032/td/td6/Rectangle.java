package nfa032.td.td6;

public class Rectangle implements AvecSurface, AvecTranslation {
	Point basGauche;
	double dimHor, dimVer;

	public Rectangle(Point bg, double dh, double dv) {
		basGauche = bg;
		dimHor = dh;
		dimVer = dv;
	}

	public double surface() {
		return dimHor * dimVer;
	}

	public void translation(double deplHor, double deplVer) {
		basGauche.translation(deplHor, deplVer);
	}

	@Override
	public void affichage() {
		System.out.println("Le rectangle est en position");
		this.basGauche.affichage();
		System.out.println(" avec un hauteur de ce point de " + this.dimVer + " et une longueur de " + this.dimVer);
	}

}
