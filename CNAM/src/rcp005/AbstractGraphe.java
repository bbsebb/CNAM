package rcp005;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public abstract class AbstractGraphe {
	LinkedHashSet<AbstractSommet<?>> sommets;
	static int dateDebut =0;
	static int dateFin = 0;

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

	protected void parcoursEnProfondeur() {
		boolean contienBlanc = true;
		while (contienBlanc) {
			for (var s : this.getSommets()) {
				contienBlanc = false;
				if (s.getCouleur() == AbstractSommet.BLANC) {
					this.parcoursEnProfondeur(s);
					contienBlanc = true;
				}
			}

		}
	}

	protected void parcoursEnProfondeur(AbstractSommet<?> sommetDebut) {
		LinkedList<AbstractSommet<?>> pile = new LinkedList<AbstractSommet<?>>();
		pile.offer(sommetDebut);
		sommetDebut.setCouleur(AbstractSommet.GRIS);
		while (!pile.isEmpty()) {
			AbstractSommet<?> tetePile = pile.peek();
			for (var s : tetePile.getSuccesseurs()) {
				if (s.getCouleur() == AbstractSommet.BLANC) {
					pile.offer(s);
					s.setCouleur(AbstractSommet.GRIS);
				}
			}
			pile.pop().setCouleur(AbstractSommet.NOIR);
		}

	}
	
	protected void parcoursEnProfondeurRec(AbstractSommet<?> sommetDebut) {
		
		
		sommetDebut.setDateDebut(this.dateDebut++);
		sommetDebut.setCouleur(AbstractSommet.GRIS);
		sommetDebut.getSuccesseurs().stream().filter((s) -> s.getCouleur()==AbstractSommet.BLANC).forEach((s) -> parcoursEnProfondeurRec(s));
		
		sommetDebut.setDateFin(this.dateFin++);
		sommetDebut.setCouleur(AbstractSommet.NOIR);
	}
	
	protected void parcoursEnProfondeurRec() {
		
		
		if(isParcouru()) {
			this.resetParcours();
		}
		this.getSommets().stream().filter((s) -> s.getCouleur()==AbstractSommet.BLANC).forEach((s) -> parcoursEnProfondeurRec(s));
	}
	
	protected boolean isParcouru() {
		return this.getSommets().stream().noneMatch((s) -> s.getCouleur()==AbstractSommet.BLANC);
	}
	
	protected void resetParcours() {
		this.getSommets().forEach(AbstractSommet<?>::reset);
	}

	protected abstract void parcoursEnLargeur();

	protected abstract ArrayList<AbstractGraphe> composanteConnexe();

	protected abstract ArrayList<AbstractGraphe> composanteFortementConnexe();

}
