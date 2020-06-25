package nfa035.projet2.feuille;

import java.util.LinkedList;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.exceptions.CircuitException;
import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.HorsFeuilleException;

/**
 * <b> Cette classe représente une cellule contenu dans une {@link Feuille une feuille} .</b>
 * <p> Une cellule est réprésenté par ses coordonnées et elle contient un contenu qui peut être de plusieurs forme et qui correspond toujours à sa formule. Le contenu peut des formes suivantes :</p>
 * <ul>
 * <li> Une cellule </li>
 * <li> Une valeur </li>
 * <li> Une fonction </li>
 * <li> Une opération</li>
 * <li> Une erreur</li>
 * </ul>
 * <p> Une cellule est lié ou non à d'autre cellule qu'elle référence dans sa formule</p>
 * @see Contenu
 * @see Erreur
 * @see Moyenne
 * @see Somme
 * @see Operation
 * @see Valeur
 * @author bbseb
 *
 */
public class Cellule implements Contenu, Comparable<Cellule> {
	private int x, y;
	private Contenu contenu;
	private String formule;
	private LinkedList<Cellule> cellulesLie = new LinkedList<Cellule>();

	/**
	 * Constructeur par defaut
	 * @param x est la première coordonnée de la cellule
	 * @param y est la deuxieme coordonnée de la cellule
	 * @throws HorsFeuilleException 
	 */
	Cellule(int x, int y) throws HorsFeuilleException {
		this.setX(x);
		this.setY(y);
		this.setContenu(null);
		this.setFormule(null);

	}

	/**
	 * Constructeur avec un contenu et sa formule 
	 * @param est la première coordonnée de la cellule
	 * @param y est la deuxieme coordonnée de la cellule
	 * @param c est le contenu de la cellule
	 * @param formule est la formulle de cellule
	 * @throws HorsFeuilleException 
	 */
	Cellule(int x, int y, Contenu c, String formule) throws HorsFeuilleException {
		this.setX(x);
		this.setY(y);
		this.setContenu(c);
		this.setFormule(formule);

	}

	/**
	 * @return the x
	 */
	int getX() {
		return this.x;
	}

	/**
	 * @param x the x to set
	 * @throws HorsFeuilleException si la coordonnée est inférieur à 0
	 */
	private void setX(int x) throws HorsFeuilleException {
		if(x<0)
			throw new HorsFeuilleException();
		this.x = x;
	}

	/**
	 * @return the y
	 */
	int getY() {
		return this.y;
	}

	/**
	 * @param y the y to set
	 * @throws HorsFeuilleException si la coordonnée est inférieur à 0
	 */
	private void setY(int y) throws HorsFeuilleException {
		if(y<0)
			throw new HorsFeuilleException();
		this.y = y;
	}

	/**
	 * @return the formule
	 */
	@Override
	public String getFormule() {
		return formule;
	}

	/**
	 * @param formule the formule to set
	 */
	void setFormule(String formule) {
		if (formule == null)
			this.formule = "";
		else
			this.formule = formule;
	}

	/**
	 * @return the contenu
	 */
	Contenu getContenu() {
		return this.contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	/**
	 * @return the cellulesLie
	 */
	LinkedList<Cellule> getCellulesLie() {
		return cellulesLie;
	}

	/**
	 * @param cellulesLie the cellulesLie to set
	 * @throws CircuitException
	 */
	void setCellulesLie(LinkedList<Cellule> cellulesLie) throws CircuitException {
		if (cellulesLie != null) {
			this.cellulesLie = cellulesLie;
			if (!this.parcoursArbre()) {
				throw new CircuitException();
			}
		} else {
			this.clearCellulesLie();
		}
	}

	/**
	 * Supprime la liste des cellules liés
	 */
	 public void clearCellulesLie() {
		this.cellulesLie.clear();
	}

	boolean estVide() {
		if (this.getContenu() == null)
			return true;
		else
			return false;
	}

	@Override
	public float getResultat() throws ErreurAffichage {
		if (this.getContenu() == null)
			throw new ErreurAffichage();
		else
			return this.getContenu().getResultat();
	}

	/**
	 * Permet de savoir si une cellule est dans une boucle. 
	 * @return vrai si il y a une boucle, faux sinon.
	 */
	private boolean parcoursArbre() {
		LinkedList<Cellule> listCellule = this.getCellulesLie();
		boolean rtr;
		if (listCellule.isEmpty()) {
			rtr = true;
		} else if (listCellule.contains(this)) {
			rtr = false;
		} else {
			rtr = true;
			for (Cellule c : listCellule) {
				rtr = rtr && c.parcoursArbre();
			}
		}
		return rtr;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public int compareTo(Cellule o) { 
		Cellule c = (Cellule) o;
		int indiceComparaison = 0;
		if (this.getX() > c.getX())
			indiceComparaison = 1;
		else if (this.getX() < c.getX())
			indiceComparaison = -1;
		else {
			if (this.getY() > c.getY())
				indiceComparaison = 1;
			else if (this.getY() < c.getY())
				indiceComparaison = -1;
			else
				indiceComparaison = 0;
		}
		return indiceComparaison;
	}

}
