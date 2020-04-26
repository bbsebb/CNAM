package nfa032.td.td6;

public class Point implements AvecTranslation {
	double x, y;

	public Point(double xi, double yi) {
		x = xi;
		y = yi;
	}

	public static double distance(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	public void translation(double deplHor, double deplVer) {
		x = x + deplHor;
		y = y + deplHor;
	}

	@Override
	public void affichage() {
		System.out.println("Le point est en position : " + "x : " + this.x + "y : " + this.y);
	}
	
	
}
