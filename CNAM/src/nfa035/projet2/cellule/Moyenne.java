package nfa035.projet2.cellule;

import java.util.Set;

import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.feuille.Bloc;
import nfa035.projet2.feuille.Cellule;

public class Moyenne extends Fonction {
	public Moyenne(Bloc b, String formule) {
		super(b, formule);
	}

	@Override
	public float getResultat() throws ErreurAffichage {
		Set<Cellule> cellules = this.getBloc().getCellules();
		float rtr = 0;
		int compteur = 0;
		for (Cellule c : cellules) {
			rtr += c.getResultat();
			compteur++;
		}
		return (float)(rtr/compteur);
	}
}
