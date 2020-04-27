package nfa10;

import java.util.TreeSet;

/**
 * Permet de cr�er un graphe de sommet et d'arc
 * 
 * @see Sommet
 * @see Arc
 * @author bbsebb
 *
 */
public class Graphe<T> {
	TreeSet<Sommet<T>> graphe;
	TreeSet<Arc<T>> arcs;
	

	/**
	 * Cr�e un graphe
	 * 
	 * 
	 */
	public Graphe() {
		this.graphe = new TreeSet<Sommet<T>>();
		this.arcs = new TreeSet<Arc<T>>();
	}

	/**
	 * Cr�e et ajoute le premier sommet du graphe
	 * 
	 * @param s est un Sommet de T, ou T est g�n�rique
	 */
	public Graphe(Sommet<T> s) {
		this.graphe = new TreeSet<Sommet<T>>();
		this.arcs = new TreeSet<Arc<T>>();
		this.addSommet(s);
	}

	/**
	 * <p>
	 * Ajoute un sommet au graphe
	 * </p>
	 * <p>
	 * Construit autant d'arc que le sommet � d'adjacent dans le graphe
	 * </p>
	 * <p>
	 * Si un sommet � un adjacent qui n'est pas dans le graphe, il est ajout� au
	 * graphe automatiquement par la m�me methode.
	 * </p>
	 * 
	 * @param s est un Sommet de T, ou T est g�n�rique
	 */
	public void addSommet(Sommet<T> s) {
		this.graphe.add(s);
		for (Sommet<T> adjacent : s.getAdj()) {
			if (!this.estSommet(adjacent))
				this.addSommet(adjacent);

			arcs.add(new Arc<T>(s, adjacent));
		}
	}

	/**
	 * Cr�e un sommet de la classe Sommet
	 * 
	 * @param name est le nom du sommet
	 * @return l'instance de sommet
	 * @see Sommet
	 */
	public Sommet<T> creeSommet(T name) {
		Sommet<T> s = new Sommet<T>(name);
		this.addSommet(s);
		return s;
	}

	/**
	 * Cr�e un arc � partir d'un sommet source vers un sommet adjacent. Si les
	 * sommets en param�tre sont absents, ils seront ajout� ainsi que tous les
	 * adjacents de mani�re recursives.
	 * 
	 * @param s   est le sommet source
	 * @param adj est le sommet adjacent
	 * @return vrai si l'arc a �t� ajout� et faux si il est d�j� pr�sent.
	 * @see #addArcValue(Sommet, Sommet, int)
	 */
	public boolean addArc(Sommet<T> s, Sommet<T> adj) {
		Arc<T> nArc = new Arc<T>(s, adj);
		if (this.arcs.contains(nArc)) {
			return false;
		} else {
			if (!this.graphe.contains(s))
				this.addSommet(s);
			if (!this.graphe.contains(adj))
				this.addSommet(adj);
			this.arcs.add(nArc);
			return true;
		}
	}

	/**
	 * Cr�e un arc � partir d'un sommet source vers un sommet adjacent et de lui
	 * donn� un poids
	 * 
	 * @param s     est le sommet source
	 * @param adj   est le sommet adjacent
	 * @param poids est le poids de l'arc
	 * @return vrai si l'arc a �t� ajout� et faux si il est d�j� pr�sent.
	 * @see #addArcValue(Sommet, Sommet)
	 */
	public boolean addArcValue(Sommet<T> s, Sommet<T> adj, int poids) {
		Arc<T> nArc = new Arc<T>(s, adj, poids);
		if (this.arcs.contains(nArc)) {
			return false;
		} else {
			if (!this.graphe.contains(s))
				this.addSommet(s);
			if (!this.graphe.contains(adj))
				this.addSommet(adj);
			this.arcs.add(nArc);
			return true;
		}
	}

	/**
	 * teste si un sommet appartient � l'instance graphe.
	 * 
	 * @param s
	 * @return
	 */
	public boolean estSommet(Sommet<T> s) {
		if (this.graphe.contains(s))
			return true;
		else
			return false;
	}

	/**
	 * tri
	 */
	public void triTopologique() {

	}

	/**
	 * affiche les sommets du graphe et leurs adjacents
	 */
	public void afficheSommetsGraphe() {
		for (Sommet<T> s : this.graphe) {
			System.out.print("Sommet numero  ?? ");
			s.afficherAdj();
			System.out.println(" ");
		}
	}

	/**
	 * affiche les arcs du graphe
	 */
	public void afficheArcsGraphe() {
		for (Arc<T> arc : this.arcs) {
			arc.afficheArc();
			System.out.println(" ");
		}
	}
}
