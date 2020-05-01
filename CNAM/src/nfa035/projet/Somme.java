package nfa035.projet;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Cette classe calcule la somme d'un bloc
 * @author bbseb
 *
 */
public class Somme extends Fonction {

	public Somme(Bloc b) {
		super(b);
	}


	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		float rtr=0;
		Set<Entry<Cellule,Contenu>> entry = this.bloc.getCellules().entrySet();
		Iterator<Entry<Cellule,Contenu>> it = entry.iterator();
		
		while(it.hasNext()) {
			Entry<Cellule,Contenu> e = it.next();
			if(e.getValue() != null) 
				rtr += e.getValue().getResultat();
		}
		return rtr;
	}


}
