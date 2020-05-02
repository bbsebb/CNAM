package nfa035.projet2;

public class Cellule implements Contenu{
	private int x,y;
	private Contenu contenu;
	
	public Cellule(int x,int y) {
		this.setX(x);
		this.setY(y);
		this.setContenu(null);
	}
	
	public Cellule(int x,int y,Contenu c) {
		this.setX(x);
		this.setY(y);
		this.setContenu(c);
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
	 * @return the contenu
	 */
	private Contenu getContenu() {
		return this.contenu;
	}

	/**
	 * @param contenu the contenu to set
	 */
	private void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		return this.getContenu().getResultat();
	}
	
	
}
