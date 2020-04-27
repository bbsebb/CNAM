package nfa035.projet;
/**
 * Classe abstraite d'une cellule dans une {@link Feuille feuille} 
 * @author bbseb
 *
 */
 public class Cellule implements Contenu{
	protected int x,y;
	protected String formule;
	
	/**
	 * Constructeur par defaut, il instancie une cellule à une place indéterminé (0,0)
	 */
	public Cellule() {
		this.setX(0);
		this.setY(0);

	}

	/**
	 * Constructeur instanciant le placement absolu d'une cellule. La formule est vide.
	 * @param x est le numéro de ligne
	 * @param y est le numéro de colonne
	 */
	public Cellule(int x, int y) {
		this.setX(x);
		this.setY(y);
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
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}


	/**
	 * Renvoie le resultat sous forme de chaine
	 * @return le resultat
	 */
	public  String getResultatToString() {
		return String.valueOf(this.getResultat());
	}
	


	/**
	 * @return le numéro de la ligne
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param modifie le numéro de ma ligne
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return le numéro de colonne 
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param modifie le numéro de la colonne
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

	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFormule() {
		// TODO Auto-generated method stub
		return null;
	}
}
