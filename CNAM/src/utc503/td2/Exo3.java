package utc503.td2;

public class Exo3 {

	public static void main(String[] args) {
		

	}
	
	String[][] init() {
		String[][] echiquier = new String[8][8];
		String[] couleur = {"noir","blanc"};
		echiquier[0][0] = 
		
		
		return echiquier;
	}
	
	void deplacerPiece(String[][] echiquier,int caseDepartx,int caseDeparty, int caseArrivex,int caseArrivey) {
		
	}
	
	void afficherEquiquier(String[][] echiquier ) {
		
		for(int i = 0;i < echiquier.length;i++) {
			System.out.println();
			for(int j = 0; j<echiquier[i].length;j++) {
				System.out.print(" ");
				System.out.print(echiquier[i][j]);
				System.out.print(" ");
			}
		}
		
	}
	
	

}
