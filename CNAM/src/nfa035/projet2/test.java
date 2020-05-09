package nfa035.projet2;

import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.CircuitException;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.Feuille;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Feuille f = null;
		try {
			f = new Feuille(2, 2);
	
		f.setCellule(0, 0, "5/2");
		f.setCellule(0, 1, "6,3");
		f.setCellule(1, 0, "0.0+0.1");
		
		f.affichageCellule();
		System.out.println("------------------");
		f.setCellule(0, 1, "1.0+1.1");
		f.affichageCellule();
		f.setCellule(0, 1, "3");
		System.out.println("------------------");
		f.affichageCellule();
		} catch (HorsFeuilleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
