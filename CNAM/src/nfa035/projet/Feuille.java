package nfa035.projet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Cette classe est une feuille d'un tableur contenant des {@link Cellule cellules}
 * @author bbseb
 *
 */
public class Feuille {
	/**
	 * Chaque valeur correspond à l'ensemble des descendants de la clé par fermeture transitive. Une valeur ne peut aparaitre 2 fois, on enlève donc la possibilité d'un cycle.
	 */
	private TreeMap<Cellule,TreeSet<Cellule>> cellules = new TreeMap<Cellule,TreeSet<Cellule>>();
	private ParseFormule pf;
	
	/**
	 * Constructeur qui crée une feuille de 11 lignes et 11 colonnes
	 */
	public Feuille() {
		for(Cellule c : creerBloc(11,11)) {
			this.cellules.put(c, null);
		}
		pf = new ParseFormule(this);
	}
	
	/**
	 * Constructeur qui crée une feuille du nombre de ligne et nombre de colonne en paramettre
	 * @param nbrLigne est le nombre de ligne de la feuille crée
	 * @param nbrColonne est le nombre de colonne de la feuille crée
	 */
	public Feuille(int nbrLigne,int nbrColonne) {
		for(Cellule c : creerBloc(nbrLigne,nbrColonne)) {
			this.cellules.put(c, null);
		}
		pf = new ParseFormule(this);
	}
	
	/**
	 * Renvoie un bloc de cellule du nombre de ligne et du nombre de colonne en paramettre. La cellule commence à 0,0;
	 * @param nbrLigne est le nombre de ligne du bloc crée
	 * @param nbrColonne est le nombre de colonne du bloc crée
	 * @return une liste de cellule unique
	 */
	private TreeSet<Cellule> creerBloc(int nbrLigne,int nbrColonne) {
		TreeSet<Cellule> bloc = new TreeSet<Cellule>();
		for(int i = 0; i<nbrLigne-1;i++) {
			for(int j = 0; j<nbrColonne-1;j++) {
				bloc.add(new Cellule(i,j));
			}
		}
		return bloc;
	}
	
	public Cellule getCellule(int x, int y) {
		Iterator<Cellule> it = this.cellules.keySet().iterator();
		while(it.hasNext()) {
			Cellule c = it.next();
			if(c.getX() == x && c.getY() == y) {
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Renvoie la formule d'une {@link Cellule cellule} spécifié en paramètre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la formule de la cellule spécifié en paramètre
	 */
	public String getCelluleFormule(int x, int y) {
		
		return this.getCellule(x, y).getFormule();
	}
	
	/**
	 * Renvoie la valeur d'une {@link Cellule cellule} spécifié en paramètre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la valeur d'une cellule spécifié en paramètre
	 */
	public float getCelluleResultat(int x, int y) {
		return this.getCellule(x, y).getResultat();
	}
	
	/**
	 * Modifie la cellule en paramettre en decomposant la formule puis en instanciant la {@link Cellule cellule} approprié
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @param formule
	 * @see CelluleFonction
	 * @see CelluleOp
	 * @see CelluleValeur
	 */
	public void setCellule(int x, int y, String formule) {
		Cellule c = this.getCellule(x, y);
		this.parseFormule(formule);
	}
	
	/**
	 * 
	 * @param formule
	 */
	private void parseFormule(String formule) {
		
	}
	
	
	private void fermetureTransitive() {
		
	}
	
	private Set<Cellule> getListeCellule() {
		
		return cellules.keySet();
		
	}
	
	public void affichageCellule() {
		Set<Cellule> listCellule = this.getListeCellule();
		int x,y;
		x=0;
		y=x;
		for(Cellule c : listCellule) {
			System.out.println(c.getX() + " " + c.getY()  + " -> Formule : " +c.getFormule()+" Resultat : " + c.getResultat());
		}
	}
	
}
