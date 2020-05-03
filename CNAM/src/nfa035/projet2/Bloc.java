package nfa035.projet2;

import java.util.LinkedHashSet;
import java.util.TreeMap;

public class Bloc extends Feuille{
	private Feuille feuille;

	

	public Bloc(int xCellule1,int yCellule1,int xCellule2,int yCellule2,Feuille feuille) throws HorsFeuilleException {
		super();
		this.setFeuille(feuille);
		if(xCellule1>xCellule2 || yCellule1>yCellule2) {
			int temp = xCellule1;
			xCellule1=xCellule2;
			xCellule2=temp;
			temp = yCellule1;
			yCellule1=yCellule2;
			yCellule2=temp;
		}
		this.setCellules(this.creeBloc(xCellule1, yCellule1, xCellule2, yCellule2));
		
	}


	/**
	 * @return the feuille
	 */
	private Feuille getFeuille() {
		return feuille;
	}

	public boolean estSansCelluleVide() {
		for(Cellule c : this.getCellules()) {
			if(c.estVide())
				return false;
		}
		return true;
	}
	
	/**
	 * @param feuille the feuille to set
	 * @throws HorsFeuilleException 
	 */
	public void setFeuille(Feuille feuille) throws HorsFeuilleException {
		if(feuille.getxMax()>=this.getxMax() && feuille.getyMax()>=this.getyMax())
			this.feuille = feuille;
		else
			throw new HorsFeuilleException();
	}

	protected TreeMap<Cellule, LinkedHashSet<Cellule>> creeBloc(int xCellule1,int yCellule1,int xCellule2,int yCellule2) throws HorsFeuilleException {
		if(xCellule1<0 || xCellule2<0 || yCellule1<0 || yCellule2<0)
			throw new HorsFeuilleException();
		TreeMap<Cellule, LinkedHashSet<Cellule>> cellules = new TreeMap<Cellule, LinkedHashSet<Cellule>>();
		for (int i = xCellule1; i <= xCellule2; i++) {
			for (int j = yCellule1; j <= yCellule2; j++) {
				cellules.put(this.getFeuille().getCellule(i, j),null);
			}
		}
		return cellules;
	}
}
