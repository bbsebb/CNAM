package nfa035.projet2.feuille;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.exceptions.CircuitException;
import nfa035.projet2.exceptions.ErreurAffichage;

public class Cellule implements Contenu, Comparable<Cellule> {
	private int x, y;
	private Contenu contenu;
	private String formule;
	private LinkedList<Cellule> cellulesLie = new LinkedList<Cellule>();

	Cellule(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setContenu(null);
		this.setFormule(null);

	}

	Cellule(int x, int y, Contenu c, String formule) {
		this.setX(x);
		this.setY(y);
		this.setContenu(c);
		this.setFormule(formule);

	}

	/**
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @param x the x to set
	 */
	private void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * @param y the y to set
	 */
	private void setY(int y) {
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
	public LinkedList<Cellule> getCellulesLie() {
		return cellulesLie;
	}

	/**
	 * @param cellulesLie the cellulesLie to set
	 * @throws CircuitException
	 */
	public void setCellulesLie(LinkedList<Cellule> cellulesLie) throws CircuitException {
		if (cellulesLie != null) {
			this.cellulesLie = cellulesLie;
			if (!this.parcoursArbre(new LinkedHashSet<Cellule>())) {
				throw new CircuitException();
			}
		} else {
			this.cellulesLie.clear();
		}
	}

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
		// TODO Auto-generated method stub
		if (this.getContenu() == null)
			throw new ErreurAffichage();
		else
			return this.getContenu().getResultat();
	}

	private boolean parcoursArbre(LinkedHashSet<Cellule> marquage) {

		LinkedList<Cellule> listCellule = this.getCellulesLie();
		boolean rtr = true;
		if (listCellule.isEmpty()) {
			marquage.add(this);
			rtr = true;
		} else if (marquage.contains(this))
			rtr = false;
		else {
			marquage.add(this);
			rtr = true;
			for (Cellule c : listCellule) {
				rtr = rtr && c.parcoursArbre(marquage);
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
