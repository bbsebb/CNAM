package nfa035.projet2.cellule;

import java.util.Set;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.feuille.Bloc;
import nfa035.projet2.feuille.Cellule;

/**
 * <b>Cette classe r�pr�sente un contenu poss�dant  dans sa formule une somme</b>
 * @author bbseb
 *
 */
public class Somme extends Fonction{
	public Somme(Bloc b,String formule) {
		super(b,formule);
	}
	@Override
	public float getResultat() throws ErreurAffichage {
		Set<Cellule> cellules = this.getBloc().getCellules();
		float rtr = 0;
		for (Cellule c : cellules) {
			rtr += c.getResultat();
		}
		return rtr;
	}
}
