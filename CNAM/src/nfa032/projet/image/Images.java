package nfa032.projet.image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Ce classe permet la gestion de plusieurs images chargées dans le programme
 * 
 * @author bbseb
 *
 */
public class Images implements MenuChargementImg, MenuEnregistrementImg, MenuModificationImg, MenuChoixImg {
	private int nbrImg = 0;
	private int idImgFocus;
	private int maxImg;
	private Image secondImg = null;
	private Image[] imgs = new Image[10];

	public Images(int maxImg) {
		this.maxImg = maxImg;
		setIdImgFocus(-1);
	}

	private Image getImgFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		return this.getImgs()[this.getIdImgFocus()];
	}

	/**
	 * @return the imgFocus
	 */
	public int getIdImgFocus() {
		return this.idImgFocus;
	}

	/**
	 * @param imgFocus the imgFocus to set
	 */
	@Override
	public void setIdImgFocus(int idImgFocus) throws ArrayIndexOutOfBoundsException {
		if (idImgFocus >= nbrImg)
			throw new ArrayIndexOutOfBoundsException();
		if (this.getNbrImg() == 0)
			this.idImgFocus = -1;
		else if (this.getNbrImg() == 1)
			this.idImgFocus = 0;
		else
			this.idImgFocus = idImgFocus;
	}
	
	@Override
	public void setSecondImg(int idSecondImg) throws ArrayIndexOutOfBoundsException {
		if (idSecondImg >= nbrImg)
			throw new ArrayIndexOutOfBoundsException();
		this.secondImg = this.getImgs()[idSecondImg];
	}
	
	private Image getSecondImg() {
		return this.secondImg;
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

	@Override
	public int getLargeurFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		return this.getImgFocus().getLargeur();
	}

	@Override
	public int getHauteurFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		return this.getImgFocus().getHauteur();
	}

	@Override
	public String getSourceFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		return this.getImgFocus().getSource();
	}

	@Override
	public boolean estVide() {
		boolean rtr;
		if (this.getNbrImg() == 0)
			rtr = true;
		else
			rtr = false;
		return rtr;
	}

	@Override
	public void ajoutImg(BufferedReader lecteur, String source, String fileName) throws IOException {
		if (this.getNbrImg() == maxImg - 1)
			throw new ArrayIndexOutOfBoundsException("limité à 10 images chargées");
		Image img = new Image();
		img.chargerImg(lecteur, source, fileName);
		imgs[this.getNbrImg()] = img;
		this.setNbrImg(this.getNbrImg() + 1);
	}

	@Override
	public void mettreEnNBFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().mettreEnNB();
	}

	@Override
	public void recadrerFocus(int l1, int l2, int c1, int c2) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().recadrer(l1, l2, c1, c2);
		;
	}

	@Override
	public void mettreNegatifFocus() {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().mettreNegatif();
	}

	@Override
	public void foncerImgFocus(String couleur) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().foncerImg(couleur);
	}

	@Override
	public void eclairecirImgFocus(String couleur) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().eclairecirImg(couleur);
	}

	@Override
	public void modifierLargeurFocus(int l) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().modifierLargeur(l);
	}

	@Override
	public void modifierHauteurFocus(int h) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().modifierHauteur(h);
	}

	@Override
	public void inscrusterRectangleFocus(int coinSupGaucheX, int coinSupGaucheY, int largeur, int hauteur,
			String couleur) {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().incrusterRectangle(coinSupGaucheX, coinSupGaucheY, largeur, hauteur, couleur);
	}
	
	@Override
	public void incrusterImgFocus(int coinSupGaucheX, int coinSupGaucheY) {
		if (this.getIdImgFocus() < 0 || this.getSecondImg() == null)
			throw new NullPointerException();
		this.getImgFocus().incrusterImg(coinSupGaucheX, coinSupGaucheY, this.getSecondImg());
	}
	
	@Override
	public void enregistrerImgFocus(BufferedWriter redacteur) throws IOException {
		if (this.getIdImgFocus() < 0)
			throw new NullPointerException();
		this.getImgFocus().enregistrerImg(redacteur);
	}

	@Override
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
