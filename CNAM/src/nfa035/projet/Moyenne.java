package nfa035.projet;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Cette classe calcule la moyenne d'un bloc
 * @author bbseb
 *
 */
public class Moyenne extends Fonction{

	public Moyenne(Bloc b) {
		super(b);
	}
	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		float rtr=0;
		Set<Entry<Cellule,Contenu>> entry = this.bloc.getCellules().entrySet();
		Iterator<Entry<Cellule,Contenu>> it = entry.iterator();
		int i = 0;
		while(it.hasNext()) {
			i++;
			Entry<Cellule,Contenu> e = it.next();
			if(e.getValue() != null) 
				rtr += e.getValue().getResultat();
		}
		return rtr/i;
	}



}
