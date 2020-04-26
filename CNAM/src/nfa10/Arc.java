package nfa10;
/**
 *  Cr�e un arc orient�
 * @author bbseb
 *
 * @param <T> est le type du nom du sommet
 * @see Sommet
 * @see Arc
 */
public class Arc<T> {
	protected Sommet<T> source,adjacent;
	protected int poids;
	protected boolean valuee = false;
	
	/**
	 * Cr�e un arc
	 * @param s1 est le sommet source de l'arc
	 * @param s2 est le sommet adjacent
	 * @see #Arc(Sommet, Sommet,int)
	 */
	public Arc(Sommet<T> s1,Sommet<T> s2) {
		this.setSource(s1);
		this.setAdjacent(s2);
		s1.addAdj(s2);
	}
	
	/**
	 * Cr�e un arc valu� et met � jour automatique les adjacents de sources et les pr�decesseurs de sommet
	 * @param s1 est le sommet source de l'arc
	 * @param s2 est le sommet adjacent
	 * @param poids est le poids de l'arc
	 */
	public Arc(Sommet<T> s1,Sommet<T> s2,int poids) {
		this.setSource(s1);
		this.setAdjacent(s2);
		this.setPoids(poids);
		this.valuee = true;
	}
	
	/**
	 * Renvoie la source de l'arc
	 * @return une instance de Sommet
	 */
	public Sommet<T> getSource() {
		return source;
	}

	/**
	 * Modifie la source de l'arc
	 * 
	 */
	protected void setSource(Sommet<T> source) {
		this.source = source;
	}
	/**
	 * Renvoie l'extr�mit� finale de l'arc
	 * @return une instance de Sommet 
	 */
	public Sommet<T> getAdjacent() {
		return adjacent;
	}
	/**
	 * Modifie la l'extr�mit� finale de l'arc
	 * 
	 */
	protected void setAdjacent(Sommet<T> adjacent) {
		this.adjacent = adjacent;
	}
/**
 * Renvoie le poids de l'arc. L'arc peut ne peut �tre valu�
 * @return un int repr�sentant le poids de l'arc
 */
	public int getPoids() {
		return poids;
	}
/**
 * Modifie le poids de l'arc
 * @param poids est le nouveau poids de l'arc
 */
	protected void setPoids(int poids) {
		this.poids = poids;
	}
	
	/**
	 * affiche l'arc
	 */
	public void afficheArc() {
		System.out.print(" Arc de la source :  ");
		this.source.afficheNom();
		System.out.print(" au sommet adjacent  ");
		this.adjacent.afficheNom();
		if(this.valuee) 
			System.out.print(" - Son poids est de " + this.getPoids());
	}


}
