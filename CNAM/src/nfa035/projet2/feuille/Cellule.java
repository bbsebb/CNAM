package nfa035.projet2.feuille;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.exceptions.FormuleErroneeException;

public class Cellule implements Contenu, Comparable<Cellule> {
	private int x, y;
	private Contenu contenu;
	private String formule;

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

	boolean estVide() {
		if (this.getContenu() == null)
			return true;
		else
			return false;
	}

	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		if (this.getContenu() == null)
			return 0f;
		else
			return this.getContenu().getResultat();
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
