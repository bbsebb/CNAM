package nfa032.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Image {
	private String name, description;
	private int largeur, hauteur, maxCouleur;
	private Point premierPoint, dernierPoint;

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
	private int getLargeur() {
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
	private int getHauteur() {
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
	public void setDernierPoint(Point dernierPoint) {
		this.dernierPoint = dernierPoint;
	}
	public void majDernierPoint() {
		Point p = this.getPremierPoint();
		while(p.getSuivant() != null) {
			p = p.getSuivant();
		}
		this.dernierPoint = p;
	}
	public Point getDernierPoint() {
		return this.dernierPoint;
	}

	public void insererDebut(Point p) {
		p.setSuivant(this.getPremierPoint());
		this.setPremierPoint(p);
		if (this.getPremierPoint() == null)
			this.setDernierPoint(p);
	}

	public void insererFin(Point p) {
		if (this.getPremierPoint() == null) {
			this.setPremierPoint(p);
			this.setDernierPoint(p);
		} else {
			this.getDernierPoint().setSuivant(p);
			this.setDernierPoint(p);
		}
	}

	public void recadrer(int l1,int l2, int c1, int c2) {
		int compteurColonne = 1;
		int compteurLigne = 1;
		Point p = this.getPremierPoint();
		Point pTemp = null;
		if(l1<l2 && l2<= this.getLargeur() && c1<c2 && c2<=this.getHauteur()) {
			while(p != null ) {
				
				for (int i = p.getNbrId(); i >= 1; i--) {
					// Premier point
					if(compteurColonne == c1 && compteurLigne==l1) {
						Point p2 = new Point(p.getRouge(),p.getVert(),p.getBleu());
						p2.setNbrId(i);
						p2.setSuivant(p.getSuivant());
						this.setPremierPoint(p2);
					}
					//Dernier point de chaque ligne sauf la dernière
					if(compteurColonne == c2 && compteurLigne>=l1 && compteurLigne<l2) {
						pTemp =p;
						pTemp.setNbrId(p.getNbrId()-(i-1));
					}					
					//Premier point de chaque ligne sauf la première
					if(compteurColonne == c1 && compteurLigne>l1 && compteurLigne<=l2) {
						Point p1 = new Point(p.getRouge(),p.getVert(),p.getBleu());
						p1.setNbrId(i);
						p1.setSuivant(p.getSuivant());
						pTemp.setSuivant(p1);
					}	
					//Dernier Point
					if(compteurColonne == c2 && compteurLigne==l2) {
						p.setSuivant(null);
						p.setNbrId(1);
					}
					
					compteurColonne++;
					if (compteurColonne == this.getLargeur()+1) {				
						compteurColonne = 1;
						compteurLigne++;
					}
				}
				p = p.getSuivant();
			}

			this.setHauteur(c2-c1);
			this.setLargeur(l2-l1);
		}
		
	}
	
	private void reset() {
		this.setDernierPoint(null);
		this.setPremierPoint(null);
	}
	
	public void mettreEnNB() {
		Point p = this.getPremierPoint();
		while(p != null) {
			p.mettreEnNB();
			p = p.getSuivant();
		}
	}
	
	public void foncerImg(String couleur) {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p.getSuivant() != null) {
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
			}
			p = p.getSuivant();
		}
	}
	public void eclairecirImg(String couleur) {
		Point p = this.getPremierPoint();
		int intensiteMax = this.getMaxCouleur();
		while (p.getSuivant() != null) {
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
			}
			p = p.getSuivant();
		}
	}

	public void chargerImg(BufferedReader lecteur) throws IOException {
		this.reset();
		

			this.setName(lecteur.readLine());
			this.setDescription(lecteur.readLine());
			int[] dimension = stringToInt(lecteur.readLine(), 2);
			this.setLargeur(dimension[1]);
			this.setHauteur(dimension[0]);
			this.setMaxCouleur(stringToInt(lecteur.readLine(), 1)[0]);

			int c = lecteur.read();
			int numCouleur = 0;
			int compteurChiffre = 3;
			int compteurCouleur = 0;
			int[] couleurs = new int[3];
			boolean estNbr = false;
			Point pPrec = null;
			while (c != -1) {
				// System.out.print((char) c);
				if (c > 47 && c < 58) {
					// System.out.print((char)c);
					numCouleur = (int) (factoriel(compteurChiffre) * (c - 48)) + numCouleur;
					compteurChiffre--;
					estNbr = true;
				}
				if (estNbr && (c < 48 || c > 57)) {
					numCouleur = (int) ( numCouleur / factoriel(compteurChiffre+1 ));
					compteurChiffre = 3;
					couleurs[compteurCouleur] = numCouleur;
					numCouleur = 0;
					estNbr = false;
					compteurCouleur++;
				}
				if (compteurCouleur == 3) {

					Point p = new Point(couleurs[0], couleurs[1], couleurs[2]);
					if (pPrec != null && pPrec.egal(p))
						pPrec.setNbrId(pPrec.getNbrId() + 1);
					else {
						this.insererFin(p);
						pPrec = p;
					}
					compteurCouleur = 0;
				}

				

			}

	}

	public void enregistrerImg(String path) {
		Path chemin = Paths.get(path);
		BufferedWriter redacteur = null;
		try {
			redacteur = Files.newBufferedWriter(chemin, StandardCharsets.US_ASCII);
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
					if (compteur == this.getLargeur()) {
						redacteur.write("\n");
						compteur = 0;
					}
				}

				p = p.getSuivant();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (redacteur != null)
				try {
					redacteur.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	static double factoriel(int n) {
		double rtr = 1;
		if (n == 0)
			return rtr;
		else if (n > 0)
			return rtr = factoriel(n - 1) * 10;
		else
			return rtr = factoriel(n + 1) / 10;
	}

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
