package nfa035.td.td4.exo2;

import nfa032.td.Terminal;

public class Point {
	private int x,y;
	Point() {
		this.x = 0;
		this.y = 0;
	}
	Point(int x,int y) {
		if(x<0 || y<0)
			throw new IllegalArgumentException();
		this.x = x;
		this.y = y;
	}	
	
	
	/**
	 * @return le x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x le x à éditer
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return le y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y le y à éditer
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	void afficher(){
		System.out.println("Coordonnée x : " + this.x + " y "+this.y);
	}
	
	void saisir() {
		int x,y;
		System.out.println("Entrée les coordonnée x : " );
		x = Terminal.lireInt();
		System.out.println("Entrée les coordonnée y: " );
		y = Terminal.lireInt();
		if(x<0 || y<0)
			throw new IllegalArgumentException();
		this.x=x;
		this.y=y;
	}
	
	Point miroir(Point axe) {
		Point symetrique = new Point();
		symetrique.setX(axe.getX()+(this.x-axe.getX()));
		symetrique.setY(axe.getY()+(this.y-axe.getY()));
		return symetrique;
	}
}
