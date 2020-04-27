package nfa035.projet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Cette classe est une feuille d'un tableur contenant des {@link Cellule cellules}
 * @author bbseb
 *
 */
public class Feuille {
	/**
	 * Chaque valeur correspond � l'ensemble des descendants de la cl� par fermeture transitive. Une valeur ne peut aparaitre 2 fois, on enl�ve donc la possibilit� d'un cycle.
	 */
	private HashMap<Cellule,HashSet<Cellule>> cellules = new HashMap<Cellule,HashSet<Cellule>>();
	
	/**
	 * Constructeur qui cr�e une feuille de 11 lignes et 11 colonnes
	 */
	public Feuille() {
		for(Cellule c : creerBloc(11,11)) {
			this.cellules.put(c, null);
		}
	}
	
	/**
	 * Constructeur qui cr�e une feuille du nombre de ligne et nombre de colonne en paramettre
	 * @param nbrLigne est le nombre de ligne de la feuille cr�e
	 * @param nbrColonne est le nombre de colonne de la feuille cr�e
	 */
	public Feuille(int nbrLigne,int nbrColonne) {
		for(Cellule c : creerBloc(nbrLigne,nbrColonne)) {
			this.cellules.put(c, null);
		}
	}
	
	/**
	 * Renvoie un bloc de cellule du nombre de ligne et du nombre de colonne en paramettre. La cellule commence � 0,0;
	 * @param nbrLigne est le nombre de ligne du bloc cr�e
	 * @param nbrColonne est le nombre de colonne du bloc cr�e
	 * @return une liste de cellule unique
	 */
	private HashSet<Cellule> creerBloc(int nbrLigne,int nbrColonne) {
		HashSet<Cellule> bloc = new HashSet<Cellule>();
		for(int i = 0; i<nbrLigne-1;i++) {
			for(int j = 0; j<nbrColonne-1;j++) {
				bloc.add(new Cellule(i,j));
			}
		}
		return bloc;
	}
	
	private Cellule getCellule(int x, int y) {
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
	 * Renvoie la formule d'une {@link Cellule cellule} sp�cifi� en param�tre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la formule de la cellule sp�cifi� en param�tre
	 */
	public String getCelluleFormule(int x, int y) {
		
		return this.getCellule(x, y).getFormule();
	}
	
	/**
	 * Renvoie la valeur d'une {@link Cellule cellule} sp�cifi� en param�tre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la valeur d'une cellule sp�cifi� en param�tre
	 */
	public float getCelluleResultat(int x, int y) {
		return this.getCellule(x, y).getResultat();
	}
	
	/**
	 * Modifie la cellule en paramettre en decomposant la formule puis en instanciant la {@link Cellule cellule} appropri�
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @param formule
	 * @see CelluleFonction
	 * @see CelluleOp
	 * @see CelluleValeur
	 */
	public void setCellule(int x, int y, String formule) {
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
	
	private HashSet<Cellule> getListeCellule() {
		return (HashSet<Cellule>)cellules.keySet();
	}
	
	
	
}
