package nfa032.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Image ppm represent� sous forme d'une liste chain�e de {@link Point points}
 * 
 * @author bbsebb
 *
 */
public class Image {
	private String name, description, source;
	private int largeur, hauteur, maxCouleur;
	private Point premierPoint, dernierPoint;

	/**
	 * Constructeur par defaut, il le premier �l�ment de la liste � null
	 */
	public Image() {
		this.setPremierPoint(null);
		this.setDernierPoint(null);
	}

	/**
	 * @return the name
	 */
	private String getName() {
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
	private String getDescription() {
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
	 * @return le chemin de l'image charg�e
	 */
	public String getSource() {
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
	public Point getPremierPoint() {
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
	 * Insere un point au d�but de la liste
	 * @param p est le point � inserer
	 */
	public void insererDebut(Point p) {
		if(p == null)
			throw new IllegalArgumentException();
		p.setSuivant(this.getPremierPoint());
		this.setPremierPoint(p);
		if (this.getPremierPoint() == null)
			this.setDernierPoint(p);
	}

	/**
	 * Ins�re un point � la fin de la liste
	 * @param p est le point � inserer
	 */
	public void insererFin(Point p) {
		if(p == null)
			throw new IllegalArgumentException();
		//Si p n'a pas de suivant, il devient automatiquement le dernier �lement
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
	public boolean estVide() {
		boolean estVide;
		if (this.getPremierPoint() == null)
			estVide = true;
		else
			estVide = false;
		return estVide;
	}

	/**
	 * Recadre l'image charger � partir du pixel situ� en haut � gauche jusqu'au pixel en bas � droite
	 * @param l1 est l'abscisse du point en haut � gauche
	 * @param l2 est l'abscisse du point en bas � droite
	 * @param c1 est l'ordonn�e du point en haut � gauche
	 * @param c2 est l'ordonn�e du point en bas � droite
	 */
	public void recadrer(int l1, int l2, int c1, int c2) {
		int compteurColonne = 1;
		int compteurLigne = 1;
		Point p = this.getPremierPoint();
		Point pTemp = null;
		if (l1 < l2 && l2 <= this.getLargeur() && c1 < c2 && c2 <= this.getHauteur() && l1 >= 0 && c1 >= 0 && !this.estVide()) {
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
					// Dernier point de chaque ligne sauf la derni�re
					if (compteurColonne == c2 && compteurLigne >= l1 && compteurLigne < l2) {
						pTemp = p;
						pTemp.setNbrId(p.getNbrId() - (i - 1));
					}
					// Premier point de chaque ligne sauf la premi�re
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

	//vide l'image
	private void reset() {
		this.setDernierPoint(null);
		this.setPremierPoint(null);
		this.setDescription("Inconnu");
		this.setName("Inconnu");
		this.setHauteur(-1);
		this.setSource("Inconnu");
		this.setLargeur(-1);
		this.setMaxCouleur(-1);
	}

	/**
	 * Met chaque pixel de l'image en noir & blanc
	 */
	public void mettreEnNB() {
		Point p = this.getPremierPoint();
		while (p != null) {
			p.mettreEnNB();
			p = p.getSuivant();
		}
	}

	/**
	 * Fonce vers une couleur donn�e en param�tre 
	 * @param couleur est la couleur � foncer
	 */
	public void foncerImg(String couleur) {
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
	 * Eclaircit vers une couleur donn�e en param�tre 
	 * @param couleur est la couleur � eclaircir
	 */
	public void eclairecirImg(String couleur) {
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
	
	public void mettreNegatif() {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p != null) {
			p.mettreNegatif(intensiteMax);
			p = p.getSuivant();
		}
	}

	/**
	 * Charge l'image en transformant chaque pixel en {@link Point point}
	 * @param lecteur est le flux de donn� vers le fichier � charger
	 * @param source est l'adresse d'ou vient le flux de donn�es
	 * @throws IOException si l'image n'est pas chargeable.
	 */
	public void chargerImg(BufferedReader lecteur, String source) throws IOException {
		this.setSource(source);
		this.chargerImg(lecteur);
	}

	private void chargerImg(BufferedReader lecteur) throws IOException {
		if(lecteur == null)
			throw new IllegalArgumentException();
		this.reset();
		//1er ligne
		this.setName(lecteur.readLine());
		//2e ligne
		this.setDescription(lecteur.readLine());
		//3e ligne
		int[] dimension = stringToInt(lecteur.readLine(), 2);
		this.setLargeur(dimension[1]);
		this.setHauteur(dimension[0]);
		//4e ligne
		this.setMaxCouleur(stringToInt(lecteur.readLine(), 1)[0]);	
		//image
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
			if (estNbr && (c < 48 || c > 57)) { //si c est un espace et la lecture du nombre est fini
				numCouleur = (int) (numCouleur / factoriel(compteurChiffre + 1));
				compteurChiffre = 3;
				couleurs[compteurCouleur] = numCouleur;
				numCouleur = 0;
				estNbr = false;
				compteurCouleur++;
			}
			if (compteurCouleur == 3) { //une fois que l'on a les 3 nombres des couleurs du points
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
	 * @param redacteur est le flux de donn�e ou sera enregistrer l'image
	 * @throws IOException si l'image n'est pas enregistrable
	 */
	public void enregistrerImg(BufferedWriter redacteur) throws IOException {
		if(redacteur == null) 
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
	 * Renvoie la puissance de 10 du param�tre 
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
	 * Renvoie un tableau d'entier positif contenu dans une chaine de caract�re dans la limite du deuxieme param�tre
	 * @param str est l'entier positif en format String
	 * @param nbrNbr est le nombre d'entier � renvoy� dans le chaine
	 * @return
	 */
	static int[] stringToInt(String str, int nbrNbr) {
		str = str.trim();
		char[] chaine = str.toCharArray();
		int[] nombre = new int[nbrNbr];
		int compteurNbr = 0;
		int compteur = 0;
		int nbr = 0;
		for (int i = chaine.length - 1; i >= 0; i--) {
			if (chaine[i] > 47 && chaine[i] < 58) {
				nbr = (int) factoriel(compteur) * (chaine[i] - 48) + nbr;
				compteur++;
			}
			if ((chaine[i] <= 47 || chaine[i] >= 58) || i == 0) {
				nombre[compteurNbr] = nbr;
				nbr = 0;
				compteur = 0;
				compteurNbr++;
			}
		}
		return nombre;
	}
}
