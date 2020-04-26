package nfa032.td;

import nfa032.td.td3.Biblio;
import nfa032.td.td3.Compte3;
import nfa032.td.td3.Livre;
import nfa032.td.td3.Produit;
import nfa032.td.td3.Stock;

public class Td3 {

	public static void main(String[] args) {
		
		//Exercice 2.2.1
		Compte3 c3 = new Compte3("seb");
		Compte3 c4 = new Compte3("seb");
		c3.deposer(50);
		c3.retirer(60);
		c3.afficher();
		c4.afficher();
		//Exercice 2.2.2
		//Q1
		Livre l1 = new Livre("Mathématique pour l'informatique","Jacques Velu","DUNOD");
		Livre l2 = new Livre("Java","Estelle GOUGELET","DUNOD");
		l1.afficher();
		//Q2
		Biblio b = new Biblio("CNAM");
		b.ajouter(l1);
		b.ajouter(l2);
		b.afficher();
		//Exercice 2.2.3
		Produit p1 = new Produit("produit1",100);
		Produit p2 = new Produit("produit2",25);
		Produit p3 = new Produit("produit2",45);
		Stock s = new Stock();
		s.ajout(p1);
		s.ajout(p2);
		s.ajout(p3);
		s.afficher(2);
		s.afficher();
		//Exercice 2.2.4
		
	}

}
