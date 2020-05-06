package nfa032.projet;

public class Point {
	private int rouge, vert, bleu;
	private int nbrId;
	private Point PointSuivant;

	Point(int rouge, int vert, int bleu) {
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

	public boolean estRouge() {
		if(this.getRouge() >= this.getBleu() && this.getRouge() >= this.getVert() )
			return true;
		else
			return false;
	}
	public boolean estVert() {
		if(this.getVert() >= this.getBleu() && this.getVert() >= this.getRouge() )
			return true;
		else
			return false;
	}
	public boolean estBleu() {
		if(this.getBleu() >= this.getVert() && this.getBleu() >= this.getRouge() )
			return true;
		else
			return false;
	}
	
	public void eclairecirPoint(int intensiteMax) {
		int augmentation = (int) (intensiteMax / 20);
		if (this.getBleu() + augmentation > intensiteMax)
			this.setBleu(intensiteMax);
		else
			this.setBleu(this.getBleu() + augmentation);
		if (this.getVert() + augmentation > intensiteMax)
			this.setVert(intensiteMax);
		else
			this.setVert(this.getVert() + augmentation);
		if (this.getRouge() + augmentation > intensiteMax)
			this.setRouge(intensiteMax);
		else
			this.setRouge(this.getRouge() + augmentation);
	}
	public void foncerPoint(int intensiteMax) {
		int diminution = (int) (intensiteMax / 20);
		if (this.getBleu() - diminution < 0)
			this.setBleu(0);
		else
			this.setBleu(this.getBleu() - diminution);
		if (this.getVert() - diminution < 0)
			this.setVert(0);
		else
			this.setVert(this.getVert() - diminution);
		if (this.getRouge() - diminution < 0)
			this.setRouge(0);
		else
			this.setRouge(this.getRouge() - diminution);
	}

	public void mettreEnNB() {
		int nb = (this.getBleu()+this.getRouge()+this.getVert())/3;
		this.setBleu(nb);
		this.setRouge(nb);
		this.setVert(nb);
	}
	
	public boolean egal(Point p) {
		if (this.getRouge() == p.getRouge() && this.getVert() == p.getVert() && this.getBleu() == p.getBleu())
			return true;
		else
			return false;
	}
}
