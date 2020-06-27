package nfa032.projet;

/**
 * Point represente un ou plusieurs pixel identique d'une image ppm.
 * @author bbsebb
 *
 */
public class Point {
	private int rouge, vert, bleu;
	private int nbrId;
	private Point PointSuivant;


	/**
	 * Constructeur par défaut
	 * @param rouge est l'intensité du rouge
	 * @param vert est l'intensité du vert
	 * @param bleu est l'intensité du bleu 
	 */
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
	 int getRouge() {
		return rouge;
	}

	/**
	 * @param rouge the rouge to set
	 */
	 void setRouge(int rouge) {
		this.rouge = rouge;
	}

	/**
	 * @return le nombre de pixel identique que représent cette instance.
	 */
	 int getNbrId() {
		return nbrId;
	}

	/**
	 * @param nbrSuivant est le nombre de pixel identique que représent cette instance.
	 */
	 void setNbrId(int nbrId) {
		this.nbrId = nbrId;
	}

	/**
	 * @return the bleu
	 */
	 int getBleu() {
		return bleu;
	}

	/**
	 * @param bleu the bleu to set
	 */
	 void setBleu(int bleu) {
		this.bleu = bleu;
	}

	/**
	 * @return the bleu
	 */
	 int getVert() {
		return vert;
	}

	/**
	 * @param bleu the bleu to set
	 */
	 void setVert(int bleu) {
		this.vert = bleu;
	}

	/**
	 * @return the pointSuivant
	 */
	 Point getSuivant() {
		return PointSuivant;
	}

	/**
	 * @param pointSuivant the pointSuivant to set
	 */
	 void setSuivant(Point pointSuivant) {
		PointSuivant = pointSuivant;
	}

	 /**
	  * 
	  * @return vrai si le point est à dominante rouge
	  */
	 boolean estRouge() {
		if(this.getRouge() >= this.getBleu() && this.getRouge() >= this.getVert() )
			return true;
		else
			return false;
	}
	 /**
	  * 
	  * @return vrai si le point est à dominante vert
	  */
	 boolean estVert() {
		if(this.getVert() >= this.getBleu() && this.getVert() >= this.getRouge() )
			return true;
		else
			return false;
	}
	 /**
	  * 
	  * @return vrai si le point est à dominante bleu
	  */
	 boolean estBleu() {
		if(this.getBleu() >= this.getVert() && this.getBleu() >= this.getRouge() )
			return true;
		else
			return false;
	}
	
	 /**
	  * Eclairci le point vers sa dominante de 20% de son intensité maximale
	  * @param intensiteMax est l'intensité maximale de la couleur
	  */
	 void eclairecirPoint(int intensiteMax) {
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
	 
	 /**
	  * Fonce le point vers sa dominante de 20% de son intensité maximale
	  * @param intensiteMax est l'intensité maximale de la couleur
	  */ 
	 void foncerPoint(int intensiteMax) {
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

	 /**
	  * Met le point en noir & blanc
	  */
	 void mettreEnNB() {
		int nb = (this.getBleu()+this.getRouge()+this.getVert())/3;
		this.setBleu(nb);
		this.setRouge(nb);
		this.setVert(nb);
	}
	 
	 void mettreNegatif(int intensiteMax) {
		 	this.setBleu(intensiteMax-this.getBleu());
			this.setRouge(intensiteMax-this.getRouge());
			this.setVert(intensiteMax-this.getVert());
	 }
	
	 /**
	  * <p>Verifie si deux point sont égaux</p>
	  * <p>Ils sont égaux si : </p>
	  * <ul>
	  * <li>Leur composante rouge est égale</li>
	  * <li>Leur composante verte est égale</li>
	  * <li>Leur composante bleu est égale</li>
	  * </il>
	  * @param p est le point à comparer
	  * @return vrai si les points sont égaux, faux sinon.
	  */
	 boolean egal(Point p) {
		if (this.getRouge() == p.getRouge() && this.getVert() == p.getVert() && this.getBleu() == p.getBleu())
			return true;
		else
			return false;
	}
	 
	public Point clone() {
		Point p =  new Point(this.getRouge(),this.getVert(),this.getBleu());
		p.setNbrId(this.getNbrId());
		p.setSuivant(this.getSuivant());
		return p ;
	}
}
