package nfa035.projet2;

import nfa035.projet2.cellule.CelluleVideException;
import nfa035.projet2.cellule.Operateur;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.Feuille;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1,5**26";
		for(String strTest : str.split(Operateur.MULTIPLICATION.toRegex(),2)) {
			System.out.println(strTest);
		}
		
		Feuille f = null;
		try {
			f = new Feuille(2, 2);
		} catch (HorsFeuilleException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			f.setCellule(0, 0, "5/2");
			f.setCellule(0, 1, "-1*-5,2");
			f.setCellule(1, 1, "moyenne(0.0;0.1)");
			f.setCellule(1, 0, "0.0+1.1");
		} catch (HorsFeuilleException | FormuleErroneeException | CelluleVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.affichageCellule();
		
		
	}

}
