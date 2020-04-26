package nfa032.td.td11;

import nfa032.td.Terminal;

public class ListeTriee {
	public ElementListe premier;
	int nbrElements = 0;

	public ElementListe getPremier() {
		return premier;
	}

	public boolean estVide() {
		return premier == null;
	}

	public boolean contientTriee(int v) {

		ElementListe elt = getPremier();
		while (elt != null && elt.getValeur() < v) {
			elt = elt.getSuivant();
		}
		return (elt != null && elt.getValeur() == v);

	}

	public void ajouterTriee(int v) {
		if (estVide()) {
			premier = new ElementListe(v);
		} else if (getPremier().getValeur() >= v) {
// Insertion au début de la liste.
			premier = new ElementListe(v, premier);
		} else {
// On veut chercher l’élément qui précède notre valeur
// Le problème est que nous ne savons que nous avons
// l’élément ‘‘précédent’’ que parce que le ‘‘suivant’’
// est strictement plus grand que v.
			ElementListe precedent = getPremier(); // Initialisation correcte car
// getPremier().getValeur() < v.
			ElementListe elt = getPremier().getSuivant();
			while (elt != null && elt.getValeur() < v) {
				precedent = elt;
				elt = elt.getSuivant();
			}
			precedent.setSuivant(new ElementListe(v, elt));
		}
		this.nbrElements++;
	}

	public void retirerPremiereOccurrence(int v) {
// On élimine le problème de la liste vide
		if (estVide())
			return;
// Le but est de trouver l’élément qui précède v...
// qui n’existe pas si v est la première valeur=>
		if (premier.getValeur() == v) {
			premier = premier.getSuivant();
		} else {
			ElementListe precedent = null;
			ElementListe elt = premier;
			while (elt != null && elt.getValeur() < v) {
				precedent = elt;
				elt = elt.getSuivant();
			}
			if (elt != null && elt.getValeur() == v) {
// L’élément a été trouvé
// Plomberie:
				precedent.setSuivant(elt.getSuivant());
			}
		}
		this.nbrElements--;
	}

	public void afﬁcher() {
		ElementListe p = premier;
		while (p != null) {
			Terminal.ecrireString(" " + p.getValeur());

			p = p.getSuivant();

		}
		Terminal.sautDeLigne();

	}

	public int somme() {
		ElementListe el = this.getPremier();
	 int rtr = 0;
		while(el.getSuivant() != null) {
			rtr = rtr + el.getValeur();
		}
		return rtr;
	}
	 public boolean estTriee() {
		return estTrieeRec(this.getPremier());
	}
	
	private boolean estTrieeRec(ElementListe el) {
		if(el.getSuivant() == null)
			return true;
		if(el.getSuivant().getValeur() >= el.getValeur())
			return estTrieeRec(el.getSuivant());
		else
			return false;
	}
	
	public int suppressionToutesOccurrences(int n) {
		
		int nbrOccurence = 0;
		return supprimerRec(n, this.getPremier(),null,nbrOccurence);

	}

	private int supprimerRec(int n, ElementListe el,ElementListe elAvant,int nbrOccurence) {
		

		if (n < el.getValeur() || el == null) {
			elAvant.setSuivant(el);
			return  nbrOccurence;
		}
		if (n == el.getValeur()) {
			return supprimerRec(n,el.getSuivant(),elAvant,nbrOccurence) + 1;
			
		} else {
			
			return supprimerRec(n,el.getSuivant(),el,nbrOccurence);
			
		}
		

	}
	
	public boolean estEgal(ListeTriee l) {
		ElementListe l1 = this.getPremier();
		ElementListe l2 = l.getPremier();
		boolean rtr = false;
		while(l1.getSuivant()!=null && l2.getSuivant()!=null) {
			if(l1.getValeur() == l2.getValeur())
				rtr = true;
			else {
				rtr = false;
				break;
			}
			l1 = l1.getSuivant();
			l2 = l2.getSuivant();
		}
		if((l1.getSuivant()==null && l2.getSuivant()!=null) ||(l1.getSuivant()!=null && l2.getSuivant()==null) )
			rtr = false;
		return rtr;
	}
	
	public void supprimerDoublon() {
		ElementListe el = this.getPremier();
		ElementListe temp = el;
		while(el.getSuivant() != null) {
			if(el.getValeur() == el.getSuivant().getValeur()) {
				temp = el;
				while(el.getValeur() == el.getSuivant().getValeur()) {
					el = el.getSuivant();
				}
				temp.setSuivant(el.getSuivant());
			}		
		}
	}

}
