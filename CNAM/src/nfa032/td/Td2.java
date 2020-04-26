package nfa032.td;

import nfa032.td.td2.Compte;
import nfa032.td.td2.Compte2;

public class Td2 {

	public static void main(String[] args) {
	 // Exercice 2.1.1
		//Q2
		Compte c1 = new Compte();
		Compte c2 = new Compte();
		c1.deposer(500);
		c2.deposer(1000);
		c2.retirer(10);
		c1.virerVers(75, c2);
		c1.afficher();
		c2.afficher();
		//Q3
		Compte[] tabC = new Compte[10];
		for(int i = 0; i<tabC.length;i++) {
			tabC[i] = new Compte();
		}
		for(int i = 0; i<tabC.length;i++) {
			tabC[i].deposer(200+100*i);
			for(int j = i+1; j<tabC.length;j++) {
				tabC[i].virerVers(20, tabC[j]);
			}
		}
		
		for(int i = 0; i<tabC.length;i++) {
			tabC[i].afficher();
		}
	//Exercice 2.1.2
		//Q1-2
		Compte2 c3 = new Compte2("Seb");
		c3.afficher();
		//Q3 : non il ne devrait jamais changer.
		//Exercice 2.1.3
		/*
		 * Statique :  compare, nouveau
		 * 
		*/
		//Exercice 2.1.4
		/*
		 * c1 et c3 sont égaux
		 * c1 et c2 ont la même valeur
		 * c1 et c2 ne sont pas égaux
		 * c1 et c1 incremente n'ont pas la même valeur
		 * c1 et c1 incremente sont égaux
		 */
		//Exercice 2.1.5
		/*
		 * class coktails
		 * 	sous class différent coktail
		 * 		elles contiennent les différents recettes et appelle les différentes methode shakers et bars
		 * class shakers
		 * 	methode statiq : melanger
		 * 	methode statiq : laver
		 * 
		 * class bars
		 * 	variable de class des différent liquide et leur quantité
		 * 	methode statique pour utiliser un liquide
		 */
	}
	
	
	

}