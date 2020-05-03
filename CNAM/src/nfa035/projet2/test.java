package nfa035.projet2;

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
			f.setCellule(0, 0, "2,5");
			f.setCellule(0, 1, "0.0+0,5");
			f.setCellule(1, 1, "Somme(0.0;0.1)");
		} catch (HorsFeuilleException | FormuleErroneeException | CelluleVideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		f.affichageCellule();
	}

}
