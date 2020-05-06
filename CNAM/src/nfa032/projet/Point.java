package nfa032.projet;

public class Point {
	private int rouge,vert,bleu;
	private int nbrId;
	private Point PointSuivant;
	
	Point(int rouge,int vert,int bleu) {
		this.setRouge(rouge);
		this.setVert(vert);
		this.setBleu(bleu);
		this.setNbrId(1);
		this.setSuivant(null);
	}
	/**
	 * @return the rouge
	 */
	public int getRouge() {
		return rouge;
	}
	/**
	 * @param rouge the rouge to set
	 */
	public void setRouge(int rouge) {
		this.rouge = rouge;
	}
	/**
	 * @return the nbrSuivant
	 */
	public int getNbrId() {
		return nbrId;
	}
	/**
	 * @param nbrSuivant the nbrSuivant to set
	 */
	public void setNbrId(int nbrId) {
		this.nbrId = nbrId;
	}
	/**
	 * @return the bleu
	 */
	public int getBleu() {
		return bleu;
	}
	/**
	 * @param bleu the bleu to set
	 */
	public void setBleu(int bleu) {
		this.bleu = bleu;
	}
	/**
	 * @return the bleu
	 */
	public int getVert() {
		return vert;
	}
	/**
	 * @param bleu the bleu to set
	 */
	public void setVert(int bleu) {
		this.vert = bleu;
	}
	/**
	 * @return the pointSuivant
	 */
	public Point getSuivant() {
		return PointSuivant;
	}
	/**
	 * @param pointSuivant the pointSuivant to set
	 */
	public void setSuivant(Point pointSuivant) {
		PointSuivant = pointSuivant;
	}
	
	public boolean egal(Point p) {
		if(this.getRouge() == p.getRouge() && this.getVert() == p.getVert() && this.getBleu() == p.getBleu())
			return true;
		else
			return false;
	}
}
