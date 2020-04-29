package nfa032.td;

import nfa032.td.td10.Liste;
import nfa032.td.td10.ElementListe;

public class Td10 {
	public static void main(String[] args) {

		/*
		 * Exercice 1.2.1 Question 1
		 */
		Liste lal = new Liste();
		lal.ajouterAuDebut(4);
		lal.ajouterAuDebut(3);
		lal.ajouterAuDebut(2);
		lal.ajouterAuDebut(1);
		/*
		 * Voir annexe10 Question 2
		 */
		Liste l = new Liste();
		l.ajouterALaFin(1);
		l.ajouterALaFin(2);
		l.ajouterALaFin(3);
		l.ajouterALaFin(4);
		// Question 3-4-5
		System.out.println(l.getPremier().getValeur());
		System.out.println(l.getPremier().getSuivant().getValeur());
		System.out.println(l.getPremier().getSuivant().getSuivant().getValeur());
		// Question 6
		Liste l1 = new Liste();
		l1.ajouterAuDebut(l.getPremier().getValeur());
		l1.ajouterAuDebut(l.getPremier().getSuivant().getValeur());
		// question 7
		ElementListe element = lal.getPremier();
		while (element.getSuivant() != null) {
			if (element.getValeur() == 3) {
				element.setValeur(6);
				break;
			}
			element = element.getSuivant();
		}
		lal.ecrireListeI();
		/*
		 * Exercice 2 
		 * Question 1
		 * Voir annexe2
		 * La variable auxilliaire est un ElementListe qui n'a pas de suivant.
		 *1ElementListe ins = new ElementListe(5, null);
		 *2ElementListe el = l.getPremier();
		 *3el = el.getSuivant();
		 *4ElementListe temp =  el;
		 *5el = el.getSuivant();
		 *6ins.setSuivant(el);
		 *7temp.setSuivant(ins);
		 *8l.ecrireListeI();
		 * Question2
		 */
		l.ecrireListeR();
		l.inserer(new ElementListe(5,null), 1);
		l.ecrireListeR();
	}
	
}
