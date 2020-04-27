package nfa035.projet;

import java.util.HashSet;
import java.util.Set;

/**
 * Cette classe est une feuille d'un tableur contenant des {@link Cellule cellules}
 * @author bbseb
 *
 */
public class Feuille {
	private Set<Cellule> cellules = new HashSet<Cellule>();
	
	
	
	
	
	
	/**
	 * Renvoie la formule d'une {@link Cellule cellule} sp�cifi� en param�tre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la formule de la cellule sp�cifi� en param�tre
	 */
	public String getCelluleFormule(int x, int y) {
		return "";
	}
	
	/**
	 * Renvoie la valeur d'une {@link Cellule cellule} sp�cifi� en param�tre
	 * @param x est la ligne de cellule
	 * @param y est la colonne de la cellule
	 * @return la valeur d'une cellule sp�cifi� en param�tre
	 */
	public float getCelluleResultat(int x, int y) {
		return 1;
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
	
	
	
	
}
