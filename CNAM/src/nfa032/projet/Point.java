package nfa032.projet;

public class Point {
	private byte rouge,jaune,bleu;
	private int nbrSuivant;
	private Point PointSuivant;
	/**
	 * @return the rouge
	 */
	public byte getRouge() {
		return rouge;
	}
	/**
	 * @param rouge the rouge to set
	 */
	public void setRouge(byte rouge) {
		this.rouge = rouge;
	}
	/**
	 * @return the nbrSuivant
	 */
	public int getNbrSuivant() {
		return nbrSuivant;
	}
	/**
	 * @param nbrSuivant the nbrSuivant to set
	 */
	public void setNbrSuivant(int nbrSuivant) {
		this.nbrSuivant = nbrSuivant;
	}
	/**
	 * @return the jaune
	 */
	public byte getJaune() {
		return jaune;
	}
	/**
	 * @param jaune the jaune to set
	 */
	public void setJaune(byte jaune) {
		this.jaune = jaune;
	}
	/**
	 * @return the bleu
	 */
	public byte getBleu() {
		return bleu;
	}
	/**
	 * @param bleu the bleu to set
	 */
	public void setBleu(byte bleu) {
		this.bleu = bleu;
	}
	/**
	 * @return the pointSuivant
	 */
	public Point getPointSuivant() {
		return PointSuivant;
	}
	/**
	 * @param pointSuivant the pointSuivant to set
	 */
	public void setPointSuivant(Point pointSuivant) {
		PointSuivant = pointSuivant;
	}
}
