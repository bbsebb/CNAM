package nfa035.projet2;

public class Bloc extends Feuille{
	private Feuille feuille;

	
	public Bloc(int xCellule1,int yCellule1,int xCellule2,int yCellule2) {
		super(xCellule1,yCellule1,xCellule2,yCellule2);
		
	}
	
	public Bloc(int xCellule1,int yCellule1,int xCellule2,int yCellule2,Feuille feuille) throws HorsFeuilleException {
		super(xCellule1,yCellule1,xCellule2,yCellule2);
		this.setFeuille(feuille);
		
	}


	/**
	 * @return the feuille
	 */
	private Feuille getFeuille() {
		return feuille;
	}


	/**
	 * @param feuille the feuille to set
	 * @throws HorsFeuilleException 
	 */
	public void setFeuille(Feuille feuille) throws HorsFeuilleException {
		if(feuille.getxMax()>this.getxMax() && feuille.getyMax()>this.getyMax())
			this.feuille = feuille;
		else
			throw new HorsFeuilleException();
	}

}
