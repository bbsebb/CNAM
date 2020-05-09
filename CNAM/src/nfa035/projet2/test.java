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
		} catch (HorsFeuilleException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			f.setCellule(0, 0, "5/2");
			f.setCellule(0, 1, "6,3");
			f.setCellule(1, 0, "0.0+0.1");
			f.setCellule(1, 1, "5,2");
			
			
		} catch (HorsFeuilleException | FormuleErroneeException | CelluleVideException | CircuitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.affichageCellule();
		System.out.println("------------------");
		try {
			f.setCellule(0, 1, "1.0+1.1");
		} catch (HorsFeuilleException | FormuleErroneeException | CelluleVideException | CircuitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.affichageCellule();
		
		try {
			f.setCellule(0, 1, "3");
		} catch (HorsFeuilleException | FormuleErroneeException | CelluleVideException | CircuitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("------------------");
		f.affichageCellule();
	}

}
