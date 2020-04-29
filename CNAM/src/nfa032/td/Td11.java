package nfa032.td;

import nfa032.td.td11.ElementListe;
import nfa032.td.td11.ListeTriee;

public class Td11 {
	public static void main(String [] args) {
		//Exercice 1.3.1
		ListeTriee l  = new ListeTriee();
		l.ajouterTriee(5);
		l.ajouterTriee(2);
		l.ajouterTriee(8);
		l.ajouterTriee(11);
		l.ajouterTriee(2);
		l.ajouterTriee(3);
		l.ajouterTriee(9);
		l.ajouterTriee(1);
		l.ajouterTriee(11);
		l.ajouterTriee(11);
		l.ajouterTriee(12);
		//Question 1
		System.out.println(l.somme());
		
		//Question 2
		ElementListe temp = l.getPremier();
		l.premier=new ElementListe(5);
		l.getPremier().setSuivant(temp.getSuivant());
		System.out.println(l.estTriee());
		//1.3.2
		ListeTriee l1 = new ListeTriee();
		l1.ajouterTriee(5);
		l1.ajouterTriee(2);
		l1.ajouterTriee(8);
		l1.ajouterTriee(3);

		ListeTriee l2 = new ListeTriee();
		l2.ajouterTriee(5);
		l2.ajouterTriee(2);
		l2.ajouterTriee(8);
		l2.ajouterTriee(3);
		l2.ajouterTriee(8);
		System.out.println(l1.estEgal(l2));
		//1.3.3
		//question 1 
		l.afﬁcher();
		System.out.println(l.suppressionToutesOccurrences(11));
		l.afﬁcher();
		//question 2
		l.afﬁcher();
		l.supprimerDoublon();
		l.afﬁcher();
		
	}
}
