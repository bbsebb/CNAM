package nfa035.projet2;

import java.util.Set;

public class Moyenne extends Fonction {
	public Moyenne(Bloc b, String formule) {
		super(b, formule);
	}

	@Override
	public float getResultat() {
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
