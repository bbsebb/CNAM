package nfa032.projet;

/**
 * Ce classe permet la gestion de plusieurs images chargées dans le programme
 * 
 * @author bbseb
 *
 */
public class Images {
	private int nbrImg = 0;
	private int imgFocus;
	private int maxImg;
	private Image[] imgs = new Image[10];

	Images(int maxImg) {
		this.maxImg = maxImg;
	}

	/**
	 * @return the imgFocus
	 */
	public int getImgFocus() {
		return imgFocus;
	}

	/**
	 * @param imgFocus the imgFocus to set
	 */
	public void setImgFocus(int imgFocus) throws ArrayIndexOutOfBoundsException {
		if (imgFocus >= maxImg)
			throw new ArrayIndexOutOfBoundsException();
		if (this.getNbrImg() == 0)
			this.imgFocus = -1;
		else if (this.getNbrImg() == 1)
			this.imgFocus = 0;
		else
			this.imgFocus = imgFocus;
	}

	/**
	 * @return the nbrImg
	 */
	public int getNbrImg() {
		return nbrImg;
	}

	/**
	 * @param nbrImg the nbrImg to set
	 */
	public void setNbrImg(int nbrImg) {
		this.nbrImg = nbrImg;
	}

	/**
	 * @return the img
	 */
	public Image[] getImgs() {
		return imgs;
	}

	public void ajoutImg(Image img) {
		if (this.getNbrImg() == maxImg - 1)
			throw new ArrayIndexOutOfBoundsException("limité à 10 images chargées");
		imgs[this.getNbrImg()] = img;
		this.setNbrImg(this.getNbrImg() + 1);
	}

	public boolean estVide() {
		boolean rtr;
		if (this.getNbrImg() == 0)
			rtr = true;
		else
			rtr = false;
		return rtr;
	}

	public void affichageListeImgs() {
		for (int i = 0; i < this.getNbrImg(); i++) {
			System.out.println((i + 1) + " " + this.getImgs()[i].getName() + " " + this.getImgs()[i].getSource());
		}
	}

	public void affichageDetailsListeImgs() {
		if (estVide())
			System.out.println("Aucune image chargée");
		else {
			for (int i = 0; i < this.getNbrImg(); i++) {
				System.out.println("Nom : " + this.getImgs()[i].getName() + " Taille : "
						+ this.getImgs()[i].getLargeur() + "x" + this.getImgs()[i].getHauteur() + " Description : "
						+ this.getImgs()[i].getDescription() + " Source : " + this.getImgs()[i].getSource());
				
			}
			System.out.println("--------------------FIN-------------------");
		}
	}

}
