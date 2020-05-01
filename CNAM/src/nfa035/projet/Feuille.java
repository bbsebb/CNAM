package nfa035.projet;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Cette classe est une feuille d'un tableur contenant des {@link Cellule
 * cellules}
 * 
 * @author bbseb
 *
 */
public class Feuille {
	/**
	 * Chaque valeur correspond à l'ensemble des descendants de la clé par fermeture
	 * transitive. Une valeur ne peut aparaitre 2 fois, on enlève donc la
	 * possibilité d'un cycle.
	 */
	private TreeMap<Cellule, LinkedHashSet<Cellule>> graphe = new TreeMap<Cellule, LinkedHashSet<Cellule>>();
	protected TreeMap<Cellule, Contenu> cellules = new TreeMap<Cellule, Contenu>();
	private ParseFormule pf;

	/**
	 * Constructeur par defaut qui crée une feuille de 11 lignes et 11 colonnes
	 */
	public Feuille() {
		for (Cellule c : creeFeuille(0, 0,11,11)) {
			this.cellules.put(c, null);
			this.graphe.put(c, null);
		}

		pf = new ParseFormule(this);
	}

	/**
	 * Constructeur qui crée une feuille du nombre de ligne et nombre de colonne en
	 * paramettre, la première cellule commencera à 0.0
	 * 
	 * @param nbrLigne   est le nombre de ligne de la feuille crée
	 * @param nbrColonne est le nombre de colonne de la feuille crée
	 */
	public Feuille(int nbrLigne, int nbrColonne) {
		for (Cellule c : creeFeuille(0,nbrLigne,0, nbrColonne)) {
			this.cellules.put(c, null);
			this.graphe.put(c, null);
		}
		pf = new ParseFormule(this);
	}
	
	/**
	 * Constructeur qui crée une feuille du nombre de ligne et nombre de colonne en
	 * paramettre, la première cellule commencera à 0.0
	 * @param xDebut est la ligne de la première cellule
	 * @param yDebut est la colonne de la première cellule
	 * @param xFin est la ligne de la dernière cellule
	 * @param yFin est la colonne de la dernière cellule
	 */
	public Feuille(int xDebut,int yDebut,int xFin,int yFin) {
		for (Cellule c : creeFeuille(xDebut, yDebut,xFin,yFin)) {
			this.cellules.put(c, null);
			this.graphe.put(c, null);
		}

		pf = new ParseFormule(this);
	}

	/**
	 * Renvoie un bloc de cellule du nombre de ligne et du nombre de colonne en
	 * paramettre. La cellule commence à 0,0;
	 * 
	 * @param nbrLigne   est le nombre de ligne du bloc crée
	 * @param nbrColonne est le nombre de colonne du bloc crée
	 * @return une liste de cellule unique
	 */
	private TreeSet<Cellule> creeFeuille(int xDebut,int yDebut,int xFin,int yFin) {
		TreeSet<Cellule> bloc = new TreeSet<Cellule>();
		for (int i = xDebut; i <= xFin; i++) {
			for (int j = yDebut; j <= yFin; j++) {
				bloc.add(new Cellule(i, j));
			}
		}
		return bloc;
	}
	
	/**
	 * Renvoie un bloc de cellule qui est une partie de la feuille
	 * @param x1 est la ligne de la première cellule du bloc
	 * @param y1 est la colonne de la première cellule du bloc
	 * @param x2 est la ligne de la deuxième cellule du bloc
	 * @param y2 est la colonne de la deuxième cellule du bl
	 * @return un object bloc
	 */
	public  Bloc creeBloc(int x1, int y1,int x2,int y2) {
		return creeBloc(x1,y1,x2,y2,this);
	}
	
	/**
	 * Renvoie un bloc de cellule qui est une partie de la feuille en paramètre
	 * @param x1 est la ligne de la première cellule du bloc
	 * @param y1 est la colonne de la première cellule du bloc
	 * @param x2 est la ligne de la deuxième cellule du bloc
	 * @param y2 est la colonne de la deuxième cellule du bl
	 * @param f est la feuille de référence de bloc
	 * @return un object bloc
	 */
	public static Bloc creeBloc(int x1, int y1,int x2,int y2,Feuille f) {
		Bloc b = new Bloc(x1,y1,x2,y2,f);
		return b;
	}

	public TreeMap<Cellule, Contenu> getCellules() {
		return this.cellules;
	}
	
	public Cellule getCellule(int x, int y) throws ErreurCelluleException {
		Iterator<Cellule> it = this.cellules.keySet().iterator();
		while (it.hasNext()) {
			Cellule c = it.next();
			if (c.getX() == x && c.getY() == y) {
				return c;
			}
		}
		throw new ErreurCelluleException();
	}

	public Contenu getContenu(Cellule c) throws ErreurCelluleException {
		Contenu rtr = cellules.get(c);
		if (rtr == null)
			throw new ErreurCelluleException();
		else
			return rtr;
	}

	/**
	 * Renvoie la formule d'une {@link Cellule cellule} spécifié en paramètre
	 * 
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la formule de la cellule spécifié en paramètre
	 * @throws ErreurCelluleException
	 */
	public String getCelluleFormule(int x, int y) throws ErreurCelluleException {

		return this.getCellule(x, y).getFormule();
	}

	/**
	 * Renvoie la valeur d'une {@link Cellule cellule} spécifié en paramètre
	 * 
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la valeur d'une cellule spécifié en paramètre
	 * @throws ErreurCelluleException
	 */
	public float getCelluleResultat(int x, int y) throws ErreurCelluleException {
		return this.getContenu(this.getCellule(x, y)).getResultat();
	}

	/**
	 * Modifie la cellule en paramettre en decomposant la formule avec
	 * {@link ParseFormule ParseFormule} puis en instanciant la {@link Cellule
	 * cellule} approprié
	 * 
	 * @param x       est la ligne de cellule
	 * @param y       est la colonne de la cellule
	 * @param formule
	 * @throws ErreurFormuleException
	 * @throws ErreurCelluleException
	 * @see CelluleFonction
	 * @see CelluleOp
	 * @see CelluleValeur
	 */
	public void setCellule(int x, int y, String formule) throws ErreurFormuleException, ErreurCelluleException {
		Cellule c = this.getCellule(x, y);
		Contenu ct = null;
		this.pf.setFormule(formule);
		if (this.pf.estCelluleValeur()) {
			ct = new CelluleValeur(x, y, this.pf.parseCelluleValeur());
		} else if (this.pf.estCelluleOperation()) {
			ct = new CelluleOp(x, y, this.pf.parseCelluleOperationGetOperande1(),
					this.pf.parseCelluleOperationGetOperande2(), this.pf.parseCelluleOperationGetOperateur());
		} else if (this.pf.estCelluleFonction()) {
			ct = new CelluleFonction(x, y, this.pf.parseCelluleFonction());
		} else
			throw new ErreurFormuleException();
		this.cellules.put(c, ct);
	}

	public void setCellule(int x, int y, Contenu ct) throws ErreurFormuleException, ErreurCelluleException {
		Cellule c = this.getCellule(x, y);
		this.cellules.put(c, ct);
	}

	private void fermetureTransitive() {

	}

	private Set<Cellule> getListeCellule() {

		return cellules.keySet();

	}

	public void affichageCellule() {
		Set<Cellule> listCellule = this.getListeCellule();
		int x, y;
		x = 0;
		y = x;

		for (Cellule c : listCellule) {
			float resultat = 0;
			if (this.cellules.get(c) != null)
				resultat = this.cellules.get(c).getResultat();
			System.out.println(c.getX() + " " + c.getY() + " -> Formule : " + c.getFormule() + " Resultat : "
					+ resultat);
		}
	}

}
