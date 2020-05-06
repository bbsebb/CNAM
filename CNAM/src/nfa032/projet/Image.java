package nfa032.projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Image {
	private String name, description;
	private int largeur, hauteur, maxCouleur;
	private Point premierPoint, dernierPoint;

	public Image(String path) {
		this.setPremierPoint(null);
		this.setDernierPoint(null);
		this.chargerImg(path);
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
	
	private void reset() {
		this.setDernierPoint(null);
		this.setPremierPoint(null);
	}
	
	public void chargerImg(String path) {
		this.reset();
		Path chemin =  Paths.get(path);
		BufferedReader  lecteur = null;
		try {
			lecteur = 	Files.newBufferedReader(chemin, StandardCharsets.UTF_8);
			
			
			this.setName(lecteur.readLine());
			this.setDescription(lecteur.readLine());
			int[] dimension = stringToInt(lecteur.readLine(),2);
			this.setLargeur(dimension[1]);
			this.setHauteur(dimension[0]);
			this.setMaxCouleur(stringToInt(lecteur.readLine(),1)[0]);
			
			int c = lecteur.read();
			int numCouleur= 0;
			int compteurChiffre = 3;
			int compteurCouleur = 0;
			int[] couleurs = new int[3];
			boolean estNbr = false;
			Point pPrec = null;
			while(c!=-1) {
		//		System.out.print((char) c);
				if(c>47 && c<58) {
				//	System.out.print((char)c);
					numCouleur = (int) (factoriel(compteurChiffre) * (c-48))+numCouleur;
					compteurChiffre --;
					estNbr = true;
				}
				if(estNbr && (c<48 || c>57)) {
					numCouleur = (int) (factoriel(compteurChiffre-3)*numCouleur);
					compteurChiffre = 3;
					couleurs[compteurCouleur] = numCouleur;
					numCouleur = 0;
					estNbr=false;
					compteurCouleur ++;
				}
				if(compteurCouleur == 2) {
					
					Point p = new Point(couleurs[0],couleurs[1],couleurs[2]);
					if(pPrec != null && pPrec.egal(p)) 
						pPrec.setNbrId(pPrec.getNbrId() + 1);
					else
						this.insererFin(p);
					pPrec = p;
					compteurCouleur=0;
				}
				
				c = lecteur.read();
				
			}
				
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(lecteur!=null)
				try {
					lecteur.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public void enregistrerImg(String path) {
		
	}
	
	static double factoriel(int n) {
		double rtr =1;
		if(n==0)
			return rtr;
		else if(n>0)
			return rtr =  factoriel(n-1) * 10;
		else 
			return rtr = factoriel(n+1) / 10;
	}
	
	static int[] stringToInt(String str,int nbrNbr) {
		str = str.trim();
		char[] chaine = str.toCharArray();
		int[] nombre = new int[nbrNbr];
		int compteurNbr = 0;
		int compteur = 0;
		int nbr = 0;
		for(int i =chaine.length-1; i >=0 ;i--) {
			if(chaine[i]>47 && chaine[i]<58) {
				nbr = (int) factoriel(compteur) * (chaine[i]-48)+nbr;
				compteur++;
			} 
			if((chaine[i]<=47 || chaine[i]>=58) || i==0) {
				nombre[compteurNbr] = nbr;
				nbr = 0;
				compteur = 0;
				compteurNbr ++;
			}
		}
		return nombre;
	}
}
