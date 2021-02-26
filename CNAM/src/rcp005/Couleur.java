package rcp005;

public enum Couleur {
	BLANC(0),GRIS(1),NOIR(2);
	
	private int value;
	
	Couleur(int value) {
		this.value = value;
	}
	
	public int toInt() {
		return this.value;
	}
	
	public static Couleur fromInt(int value) {
		switch(value) {
		case 0 : return BLANC;
		case 1 : return GRIS;
		default : return NOIR;
		}
	}
}
