package nfa032.projet.image;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Image ppm representé sous forme d'une liste chainée de {@link Point points}
 * 
 * @author bbsebb
 *
 */
class Image {
	private String name, description, source, FileName;
	private int largeur, hauteur, maxCouleur;
	private Point premierPoint, dernierPoint;

	/**
	 * Constructeur par defaut, il le premier élément de la liste à null
	 */
	Image() {
		this.setPremierPoint(null);
		this.setDernierPoint(null);
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return FileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		FileName = fileName;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	private void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the largeur
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur the largeur to set
	 */
	private void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the hauteur
	 */
	public int getHauteur() {
		return hauteur;
	}

	/**
	 * @param hauteur the hauteur to set
	 */
	private void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	/**
	 * @return the maxCouleur
	 */
	private int getMaxCouleur() {
		return maxCouleur;
	}

	/**
	 * @param maxCouleur the maxCouleur to set
	 */
	private void setMaxCouleur(int maxCouleur) {
		this.maxCouleur = maxCouleur;
	}

	/**
	 * @return le chemin de l'image chargée
	 */
	String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	private void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the premierPoint
	 */
	Point getPremierPoint() {
		return premierPoint;
	}

	/**
	 * @param premierPoint the premierPoint to set
	 */
	private void setPremierPoint(Point premierPoint) {
		this.premierPoint = premierPoint;
	}

	/**
	 * @param dernierPoint the dernierPoint to set
	 */
	private void setDernierPoint(Point dernierPoint) {
		this.dernierPoint = dernierPoint;
	}

	private Point getDernierPoint() {
		return this.dernierPoint;
	}

	/**
	 * Insere un point au début de la liste
	 * 
	 * @param p est le point à inserer
	 */
	void insererDebut(Point p) {
		if (p == null)
			throw new IllegalArgumentException();
		p.setSuivant(this.getPremierPoint());
		this.setPremierPoint(p);
		if (this.getPremierPoint() == null)
			this.setDernierPoint(p);
	}

	/**
	 * Insère un point à la fin de la liste
	 * 
	 * @param p est le point à inserer
	 */
	void insererFin(Point p) {
		if (p == null)
			throw new IllegalArgumentException();
		// Si p n'a pas de suivant, il devient automatiquement le dernier élement
		if (p.getSuivant() == null) {
			if (this.getPremierPoint() == null) {
				this.setPremierPoint(p);
				this.setDernierPoint(p);
			} else {
				this.getDernierPoint().setSuivant(p);
				this.setDernierPoint(p);
			}
		} else {
			this.getDernierPoint().setSuivant(p);
			while (p.getSuivant() != null) {
				p = p.getSuivant();
			}
			this.setDernierPoint(p);
		}
	}

	/**
	 * 
	 * @return vrai si Image est vide faux sinon
	 */
	boolean estVide() {
		boolean estVide;
		if (this.getPremierPoint() == null)
			estVide = true;
		else
			estVide = false;
		return estVide;
	}

	/**
	 * Recadre l'image charger à partir du pixel situé en haut à gauche jusqu'au
	 * pixel en bas à droite
	 * 
	 * @param l1 est l'abscisse du point en haut à gauche
	 * @param l2 est l'abscisse du point en bas à droite
	 * @param c1 est l'ordonnée du point en haut à gauche
	 * @param c2 est l'ordonnée du point en bas à droite
	 */
	void recadrer(int l1, int l2, int c1, int c2) {
		int compteurColonne = 1;
		int compteurLigne = 1;
		Point p = this.getPremierPoint();
		Point pTemp = null;
		if (l1 < l2 && l2 <= this.getLargeur() && c1 < c2 && c2 <= this.getHauteur() && l1 >= 0 && c1 >= 0
				&& !this.estVide()) {
			while (p != null) {
				for (int i = p.getNbrId(); i >= 1; i--) {
					// Premier point
					if (compteurColonne == c1 && compteurLigne == l1) {
						Point p2 = new Point(p.getRouge(), p.getVert(), p.getBleu());
						p2.setNbrId(i);
						p2.setSuivant(p.getSuivant());
						this.setPremierPoint(p2);
						p = p2;
					}
					// Dernier point de chaque ligne sauf la dernière
					if (compteurColonne == c2 && compteurLigne >= l1 && compteurLigne < l2) {
						pTemp = p;
						pTemp.setNbrId(p.getNbrId() - (i - 1));
					}
					// Premier point de chaque ligne sauf la première
					if (compteurColonne == c1 && compteurLigne > l1 && compteurLigne <= l2) {
						Point p1 = new Point(p.getRouge(), p.getVert(), p.getBleu());
						p1.setNbrId(i);
						p1.setSuivant(p.getSuivant());
						p = p1;
						pTemp.setSuivant(p1);
					}
					// Dernier Point
					if (compteurColonne == c2 && compteurLigne == l2) {
						p.setSuivant(null);
						p.setNbrId(p.getNbrId() - (i - 1));
					}

					compteurColonne++;
					if (compteurColonne == this.getLargeur() + 1) {
						compteurColonne = 1;
						compteurLigne++;
					}
				}
				p = p.getSuivant();
			}
			this.setHauteur(c2 - c1 + 1);
			this.setLargeur(l2 - l1 + 1);
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Met chaque pixel de l'image en noir & blanc
	 */
	void mettreEnNB() {
		Point p = this.getPremierPoint();
		while (p != null) {
			p.mettreEnNB();
			p = p.getSuivant();
		}
	}

	/**
	 * Fonce vers une couleur donnée en paramètre
	 * 
	 * @param couleur est la couleur à foncer
	 */
	void foncerImg(String couleur) {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p != null) {
			switch (couleur) {
			case "bleu":
				if (p.estBleu())
					p.foncerPoint(intensiteMax);
				break;
			case "rouge":
				if (p.estRouge())
					p.foncerPoint(intensiteMax);
				break;
			case "vert":
				if (p.estVert())
					p.foncerPoint(intensiteMax);
				break;
			default:
				throw new IllegalArgumentException();
			}
			p = p.getSuivant();
		}
	}

	/**
	 * Eclaircit vers une couleur donnée en paramètre
	 * 
	 * @param couleur est la couleur à eclaircir
	 */
	void eclairecirImg(String couleur) {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p != null) {
			switch (couleur) {
			case "bleu":
				if (p.estBleu())
					p.eclairecirPoint(intensiteMax);
				break;
			case "rouge":
				if (p.estRouge())
					p.eclairecirPoint(intensiteMax);
				break;
			case "vert":
				if (p.estVert())
					p.eclairecirPoint(intensiteMax);
				break;
			default:
				throw new IllegalArgumentException();
			}
			p = p.getSuivant();
		}
	}

	void mettreNegatif() {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p != null) {
			p.mettreNegatif(intensiteMax);
			p = p.getSuivant();
		}
	}

	int nbrPoint() { // Pour test
		Point p = this.getPremierPoint();
		int i = 0;
		while (p != null) {
			i = i + p.getNbrId();
			p = p.getSuivant();
		}
		return i;
	}

	void modifierLargeur(int l) {
		if (l <= 0)
			throw new IllegalArgumentException(" La largeur, " + l + " doit être supérieure à 0");
		double ratio = ((double) (l - this.getLargeur())) / this.getLargeur();
		double i = 0;
		this.setLargeur(l);
		Point p = this.getPremierPoint();
		Point pPrec = null;
		while (p != null && ratio != 0) {
			int nbrPoint = p.getNbrId();
			for (int j = 0; j < nbrPoint; j++) {
				if (ratio < 0) { // Diminuation largeur
					if (i <= -1) { // dès que on dépasse 1 en additionnant les ratios, on ajoute un Point
						p.setNbrId(p.getNbrId() - 1);
						if (p.getNbrId() == 0)
							pPrec.setSuivant(p.getSuivant());
						i = 0 + (i + 1); // on remet le reste
					}
				} else {
					if (i >= 1) { // Augmentation largeur
						p.setNbrId(p.getNbrId() + 1);
						i = 0 + (i - 1);
					}
				}
				i = i + ratio;
			}
			pPrec = p;
			p = p.getSuivant();
		}
	}

	void modifierHauteur(int h) {
		if (h <= 0)
			throw new IllegalArgumentException(" La largeur, " + h + " doit être supérieure à 0");
		double ratio = ((double) (h - this.getHauteur())) / this.getHauteur();
		double i = (ratio > 0) ? 0 : ratio * 2; // Pour diminuer on supprimer la ligne avant et pour agrandir on ajoute
												// la ligne après
		Point[] lignePrec = new Point[this.getLargeur()];
		boolean suppLigne = false;
		Point debutSuppLigne = null;
		Point p = this.getPremierPoint();
		int compteurColonne = 0;
		this.setHauteur(h);
		while (p != null && ratio != 0) {
			int nbrId = p.getNbrId();
			for (int j = nbrId; j >= 1; j--) {
				if (compteurColonne == this.getLargeur() - 1) { // Dernier point d'une ligne
					lignePrec[compteurColonne] = p.clone();
					if (suppLigne) { // Suppression de la ligne
						if (j > 1) { // si le dernier point est sur pls lignes
							Point pSuivant = p.clone();
							pSuivant.setSuivant(p.getSuivant());
							p.setNbrId(p.getNbrId() - (j - 1));
							pSuivant.setNbrId((j - 1));
							p.setSuivant(pSuivant);
							j = 1;
						}
						debutSuppLigne.setSuivant(p.getSuivant());
						suppLigne = false;
					}
					if (i >= 1 && ratio > 0) { // Si on doit ajouter une ligne
						if (j > 1) { // si le dernier point est sur pls lignes
							Point pSuivant = p.clone();
							pSuivant.setSuivant(p.getSuivant());
							p.setNbrId(p.getNbrId() - (j - 1));
							pSuivant.setNbrId((j - 1));
							p.setSuivant(pSuivant);
							j = 1;
						}
						// On insère la précédente ligne
						Point pTempSuivant = p.getSuivant();
						if (p.egal(lignePrec[0])) {
							lignePrec[0] = p;
							lignePrec[0].setNbrId(p.getNbrId() + 1);
						} else {
							p.setSuivant(lignePrec[0]);
						}
						for (int k = 1; k < lignePrec.length; k++) {
							if (lignePrec[k - 1].egal(lignePrec[k])) {
								lignePrec[k] = lignePrec[k - 1];
								lignePrec[k].setNbrId(lignePrec[k - 1].getNbrId() + 1);
							} else {
								lignePrec[k - 1].setSuivant(lignePrec[k]);
							}
						}
						lignePrec[lignePrec.length - 1].setSuivant(pTempSuivant);
						i = 0 + (i - 1);
					} else if (i <= -1 && ratio < 0) { // si on doit supprimer une ligne
						suppLigne = true;
						if (j > 1) { // si le dernier point est sur pls lignes
							Point pSuivant = p.clone();
							pSuivant.setSuivant(p.getSuivant());
							p.setNbrId(p.getNbrId() - (j - 1));
							pSuivant.setNbrId((j - 1));
							p.setSuivant(pSuivant);
							j = 1;
						}
						debutSuppLigne = p;
						i = 0 + (i + 1);
					} else {
						i = i + ratio;
					}

					compteurColonne = 0;
				} else { // Autres points d'une lignes
					lignePrec[compteurColonne] = p.clone();
					compteurColonne++;
				}

			}
			p = p.getSuivant();
		}
	}

	void incrusterRectangle(int coinSupGaucheX, int coinSupGaucheY, int largeur, int hauteur, String couleur) {
		couleur = couleur.trim().toLowerCase();
		if (coinSupGaucheX < 1 || coinSupGaucheY < 1 || largeur < 1 || hauteur < 1
				|| (couleur != "rouge" && couleur != "vert" && couleur != "bleu"))
			throw new IllegalArgumentException();
		if (coinSupGaucheX + largeur - 1 > this.getLargeur() || coinSupGaucheY + hauteur - 1 > this.getHauteur()) {
			throw new IllegalArgumentException();
		}
		Point pTemp = null;
		int compteurColonne = 1;
		int compteurLigne = 1;
		int coinInfDroitX = coinSupGaucheX + largeur - 1;
		int coinInfDroitY = coinSupGaucheY + hauteur - 1;
		Point p = this.getPremierPoint();
		while (p != null) {
			int nbrId = p.getNbrId();
			for (int i = nbrId; i >= 1; i--) {

				if (compteurColonne >= coinSupGaucheX && compteurColonne <= coinInfDroitX
						&& compteurLigne >= coinSupGaucheY && compteurLigne <= coinInfDroitY) { // On est dans les
																								// coordonnées du
																								// rectangle
					if (coinSupGaucheX == compteurColonne) { // Premier point d'une ligne dans le rectangle
						if (p.getNbrId() != i) { // Si le point exister déjà avant
							Point pNouveau = p.clone();
							pNouveau.setSuivant(p.getSuivant());
							p.setSuivant(pNouveau);
							p.setNbrId(p.getNbrId() - i);
							pNouveau.setNbrId(i);
							p = pNouveau;
						}
						if (p.getNbrId() > largeur) {
							pTemp = p.clone(); // On sauvegarde la couleur si le point dépasse une ligne entière
						} else {
							pTemp = null;
						}
						p.setCouleur(couleur, this.maxCouleur);
					} else if (coinInfDroitX == compteurColonne) { // Dernier point d'une ligne dans le rectangle
						if (i > 1) { // Si le point existera encore après
							Point pSuivant;
							if (pTemp == null) { // On récupère la couleur précédente si pTemp n'est pas null
								pSuivant = p.clone();
							} else {
								pSuivant = pTemp;
							}
							pSuivant.setSuivant(p.getSuivant());
							p.setSuivant(pSuivant);
							p.setNbrId(p.getNbrId() - (i - 1));
							pSuivant.setNbrId((i - 1));
							i = 1;
						}
						p.setCouleur(couleur, this.maxCouleur);
					} else { // Autres points du rectangle
						if (p.getNbrId() + compteurColonne - 1 > largeur) {
							if (p.getNbrId() == i)
								pTemp = p.clone(); // On sauvegarde la couleur si le point dépasse une ligne entière
													// (uniquement la première occurence du point)
						} else {
							pTemp = null;
						}
						p.setCouleur(couleur, this.maxCouleur);
					}
				}
				if (compteurColonne == this.getLargeur()) {
					compteurLigne++;
					compteurColonne = 0;
				}
				compteurColonne++;
			}

			p = p.getSuivant();
		}
	}

	void incrusterImg(int coinSupGaucheX, int coinSupGaucheY, Image img) {
		if (img == null || img.estVide())
			throw new NullPointerException("Aucune image à inscruster ou image à inscruster vide");
		if (coinSupGaucheX < 1 || coinSupGaucheY < 1)
			throw new IllegalArgumentException("Coordonnée incorrecte");
		if (coinSupGaucheX + img.getLargeur() - 1 > this.getLargeur()
				|| coinSupGaucheY + img.getHauteur() - 1 > this.getHauteur())
			throw new IllegalArgumentException("L'image à inscruster dépasse l'image de fond");
		int compteurColonne = 1;
		int compteurLigne = 1;
		int coinInfDroitX = coinSupGaucheX + img.getLargeur() - 1;
		int coinInfDroitY = coinSupGaucheY + img.getHauteur() - 1;
		Point pPrec = null;
		Point p = this.getPremierPoint();
		Point p2 = img.getPremierPoint();
		Point couleurFontP2 = p2.clone(); // On récupère la couleur du premier point comme couleur "fond vert"
		int j = p2.getNbrId();
		while (p != null) {
			int nbrId = p.getNbrId();
			for (int i = nbrId; i >= 1; i--) {

				if (compteurColonne >= coinSupGaucheX && compteurColonne <= coinInfDroitX
						&& compteurLigne >= coinSupGaucheY && compteurLigne <= coinInfDroitY) { // Si on est sur les 2
																								// images
					if (!couleurFontP2.egal(p2)) { // Si on n'est plus sur le fond vert, on inscruste les points
						if (p.getNbrId() != i) { // Si un pixel précédent correspond au point actuel
							Point pNouveau = p.clone();
							pNouveau.setSuivant(p.getSuivant());
							p.setSuivant(pNouveau);
							p.setNbrId(p.getNbrId() - i);
							pNouveau.setNbrId(i);
							p = pNouveau;
						} else if (i > 1) { // si un pixel suivant correspond au point actuel
							Point pSuivant = p.clone();
							pSuivant.setSuivant(p.getSuivant());
							p.setSuivant(pSuivant);
							p.setNbrId(p.getNbrId() - (i - 1));
							pSuivant.setNbrId((i - 1));
							i = 1;
						}
						p.setBleu(p2.getBleu());
						p.setVert(p2.getVert());
						p.setRouge(p2.getRouge());
						if(pPrec.egal(p)) { // Si identique, on rattache les pixels en un seul point
							pPrec.setNbrId(pPrec.getNbrId() + p.getNbrId());
							pPrec.setSuivant(p.getSuivant());
						}
					}
					if (j == 1 && p2.getSuivant() != null) { // Si on a fini avec un point on passe au suivant
						p2 = p2.getSuivant();
						j = p2.getNbrId();
					} else { // Sinon on décrémente d'un pixel
						j--;
					}
				}
				if (compteurColonne == this.getLargeur()) {
					compteurLigne++;
					compteurColonne = 0;
				}
				compteurColonne++;
			}
			pPrec = p;
			p = p.getSuivant();
		}
	}

	/**
	 * Charge l'image en transformant chaque pixel en {@link Point point}
	 * 
	 * @param lecteur est le flux de donné vers le fichier à charger
	 * @param source  est l'adresse d'ou vient le flux de données
	 * @throws IOException si l'image n'est pas chargeable.
	 */
	void chargerImg(BufferedReader lecteur, String source, String fileName) throws IOException {
		this.setFileName(fileName);
		this.setSource(source);
		this.chargerImg(lecteur);
	}

	private void chargerImg(BufferedReader lecteur) throws IOException {
		if (lecteur == null)
			throw new IllegalArgumentException();
		// 1er ligne
		this.setName(lecteur.readLine());
		// 2e ligne
		this.setDescription(lecteur.readLine());
		// 3e ligne
		int[] dimension = stringToInt(lecteur.readLine(), 2);
		this.setLargeur(dimension[1]);
		this.setHauteur(dimension[0]);
		// 4e ligne
		this.setMaxCouleur(stringToInt(lecteur.readLine(), 1)[0]);
		// image
		int c = lecteur.read();
		int numCouleur = 0;
		int compteurChiffre = 3;
		int compteurCouleur = 0;
		int[] couleurs = new int[3];
		boolean estNbr = false;
		Point pPrec = null;
		while (c != -1) {
			if (c > 47 && c < 58) { // si c est un chiffre
				numCouleur = (int) (factoriel(compteurChiffre) * (c - 48)) + numCouleur;
				compteurChiffre--;
				estNbr = true;
			}
			if (estNbr && (c < 48 || c > 57)) { // si c est un espace et la lecture du nombre est fini
				numCouleur = (int) (numCouleur / factoriel(compteurChiffre + 1));
				compteurChiffre = 3;
				couleurs[compteurCouleur] = numCouleur;
				numCouleur = 0;
				estNbr = false;
				compteurCouleur++;
			}
			if (compteurCouleur == 3) { // une fois que l'on a les 3 nombres des couleurs du points
				Point p = new Point(couleurs[0], couleurs[1], couleurs[2]);
				if (pPrec != null && pPrec.egal(p))
					pPrec.setNbrId(pPrec.getNbrId() + 1);
				else {
					this.insererFin(p);
					pPrec = p;
				}
				compteurCouleur = 0;
			}

			c = lecteur.read();

		}

	}

	/**
	 * Transforme la liste de point en image de pixel
	 * 
	 * @param redacteur est le flux de donnée ou sera enregistrer l'image
	 * @throws IOException si l'image n'est pas enregistrable
	 */
	void enregistrerImg(BufferedWriter redacteur) throws IOException {
		if (redacteur == null)
			throw new IllegalArgumentException();
		redacteur.write(this.getName() + "\n");
		redacteur.write(this.getDescription() + "\n");
		redacteur.write(this.getLargeur() + " " + this.getHauteur() + "\n");
		redacteur.write(this.getMaxCouleur() + "\n");
		int compteur = 0;
		Point p = this.getPremierPoint();
		while (p != null) {
			for (int i = p.getNbrId(); i >= 1; i--) {
				redacteur.write(p.getRouge() + "  " + p.getVert() + "  " + p.getBleu() + "  ");
				compteur++;
				// Permet d'avoir un fichier facilement lisible avec un lecteur de texte
				if (compteur == this.getLargeur()) {
					redacteur.write("\n");
					compteur = 0;
				}
			}

			p = p.getSuivant();
		}

	}

	/**
	 * Renvoie la puissance de 10 du paramètre
	 * 
	 * @param n est la puissance
	 * @return
	 */
	static double factoriel(int n) {
		double rtr = 1;
		if (n == 0)
			return rtr;
		else if (n > 0)
			return rtr = factoriel(n - 1) * 10;
		else
			return rtr = factoriel(n + 1) / 10;
	}

	/**
	 * Renvoie un tableau d'entier positif contenu dans une chaine de caractère dans
	 * la limite du deuxieme paramètre
	 * 
	 * @param str    est l'entier positif en format String
	 * @param nbrNbr est le nombre d'entier à renvoyé dans le chaine
	 * @return
	 */
	static int[] stringToInt(String str, int nbrNbr) {
		str = str.trim();
		boolean finChiffre = true;
		char[] chaine = str.toCharArray();
		int[] nombre = new int[nbrNbr];
		int compteurNbr = 0;
		int compteur = 0;
		int nbr = 0;
		for (int i = chaine.length - 1; i >= 0; i--) {
			if (chaine[i] > 47 && chaine[i] < 58) {
				nbr = (int) factoriel(compteur) * (chaine[i] - 48) + nbr;
				compteur++;
				finChiffre = true;
			}
			if (((chaine[i] <= 47 || chaine[i] >= 58) || i == 0) && finChiffre) {
				nombre[compteurNbr] = nbr;
				nbr = 0;
				compteur = 0;
				compteurNbr++;
				finChiffre = false;
			}
		}
		return nombre;
	}
}
