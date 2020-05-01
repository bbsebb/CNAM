package nfa035.projet;
/**
 * Classe abstraite d'une cellule dans une {@link Feuille feuille} 
 * @author bbseb
 *
 */
 public class Cellule implements Comparable{
	protected int x,y;
	protected String formule;
	
	/**
	 * Constructeur par defaut, il instancie une cellule � une place ind�termin� (0,0)
	 */
	public Cellule() {
		this.setX(0);
		this.setY(0);
		this.setFormule("Inconnu");
	}

	/**
	 * Constructeur instanciant le placement absolu d'une cellule. La formule est vide.
	 * @param x est le num�ro de ligne
	 * @param y est le num�ro de colonne
	 */
	public Cellule(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setFormule("Inconnu");
	}
	

	@Override
	public int compareTo(Object o) {
		Cellule c = (Cellule)o;
		int indiceComparaison = 0;
		if(this.getX() > c.getX())
			indiceComparaison = 1;
		else if (this.getX() < c.getX())
			indiceComparaison = -1;
		else {
			if(this.getY() > c.getY())
				indiceComparaison = 1;
			else if (this.getY() < c.getY())
				indiceComparaison = -1;
			else 
				indiceComparaison = 0;
		}
		return indiceComparaison;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cellule))
			return false;
		Cellule other = (Cellule) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	


	/**
	 * @return le num�ro de la ligne
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param modifie le num�ro de ma ligne
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return le num�ro de colonne 
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param modifie le num�ro de la colonne
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @param modifie la formule de la cellule
	 */
	public void setFormule(String formule) {
		this.formule = formule;
	}


	/**
	 * Renvoie la formule du conteneur
	 * @return la formule du conteneur
	 */
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}


}
