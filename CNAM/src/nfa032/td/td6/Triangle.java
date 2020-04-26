package nfa032.td.td6;

public class Triangle implements AvecSurface, AvecTranslation {
	Point p1, p2, p3;

	public Triangle(Point p1i, Point p2i, Point p3i) {
		p1 = p1i;
		p2 = p2i;
		p3 = p3i;
	}

	public double surface() {
		double a = Point.distance(p1, p2);
		double b = Point.distance(p1, p3);
		double c = Point.distance(p2, p3);
		double demiper = (a + b + c) / 2;
		return Math.sqrt(demiper * (demiper - a) * (demiper - b) * (demiper - c));
	}
	@Override
	public void translation(double deplHor, double deplVer) {
		p1.translation(deplHor, deplVer);
		p2.translation(deplHor, deplVer);
		p3.translation(deplHor, deplVer);
	}

	@Override
	public void affichage() {
		System.out.println("Le triangle est en position");
		this.p1.affichage();
		this.p2.affichage();
		this.p3.affichage();
	}
}
