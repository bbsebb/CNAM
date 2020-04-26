package nfa032.td.td6;

public class Cercle implements AvecSurface, AvecTranslation {
	Point centre;
	double rayon;

	public Cercle(Point ctr, double r) {
		centre = ctr;
		rayon = r;
	}

	public double surface() {
		return Math.PI * rayon * rayon;
	}

	public void translation(double deplHor, double deplVer) {
		centre.translation(deplHor, deplVer);
	}

	@Override
	public void affichage() {
		
		System.out.println("Le Cercle est en position");
		this.centre.affichage();
		System.out.println(" avec un rayon de ce point de " + this.rayon);		
	}
}
