package rcp005;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public abstract class AbstractGraphe {
	LinkedHashSet<AbstractSommet<?>> sommets;

	public AbstractGraphe() {
		super();
		this.sommets = new LinkedHashSet<AbstractSommet<?>>();
	}

	public AbstractGraphe(LinkedHashSet<AbstractSommet<?>> sommets) {
		super();
		this.sommets = sommets;
	}

	protected LinkedHashSet<AbstractSommet<?>> getSommets() {
		return sommets;
	}

	protected void setSommets(LinkedHashSet<AbstractSommet<?>> sommets) {
		this.sommets = sommets;
	}

	protected boolean addSommet(AbstractSommet<?> s) {
		boolean rtr = false;
		for (AbstractSommet<?> sommet : s.getSuccesseurs()) {
			if (!this.getSommets().contains(sommet))
				rtr = addSommet(sommet);
		}
		this.getSommets().add(s);
		return rtr;
	}

	protected void parcoursEnProfondeur(AbstractSommet<?> sommetDebut) {
		LinkedList<AbstractSommet<?>> pile = new LinkedList<AbstractSommet<?>>();
		LinkedList<AbstractSommet<?>> marquage = new LinkedList<AbstractSommet<?>>(sommets);
		AbstractSommet<?> tetePile;
		int compteur = 0;
		pile.addFirst(sommetDebut);
		marquage.remove(sommetDebut);
		while (!marquage.isEmpty()) {
			pile.add(marquage.remove());
			while (!pile.isEmpty()) {			
				tetePile = pile.remove();
				System.out.println(tetePile.toString());
				marquage.remove(tetePile);
				for (AbstractSommet<?> successeur : tetePile.getSuccesseurs()) {
					if(marquage.contains(successeur)) {
						pile.addFirst(successeur);	
					}
							
				}
			
				
			}
			
			
			

			
			
		}

	}

	protected abstract void parcoursEnLargeur();

	protected abstract ArrayList<AbstractGraphe> composanteConnexe();

	protected abstract ArrayList<AbstractGraphe> composanteFortementConnexe();

}
