package nfa032.td;

import nfa032.td.td6.*;

public class Td6 {

	public static void main(String[] args) {
		
		//Exercice 5.1.1
		Crier[] tab = {new Chat(),new Chien()};
		for(int i =0; i < tab.length;i++) {
			tab[i].crier();
		}
		//Exercice 5.1.2
		Convertible d0 = new Date(10,10,2018);
		Convertible d1 = new Date();
		Convertible c = new Compte();
		Convertible c1 = new Compte();
		Convertible[] tab2 = {d0,d1,c,c1};
		System.out.println(Comparer.comparePlusGrand(d0,d1));
		System.out.println(Comparer.comparePlusPetit(c, c1));
		System.out.println(Comparer.compareEgal(c, c1));
		for(Convertible i : tab2) {
			System.out.println(i.toString());
		}
		Comparer.tri(tab2);
		for(Convertible i : tab2) {
			System.out.println(i.toString());
		}
		//Exercice 5.1.3
		Deplacement[] tab3 = new Deplacement[4];
		tab3[0] = new Deplacement((AvecTranslation)new Triangle(new Point(0,0),new Point(1,1),new Point(2,2)));
		tab3[1] = new Deplacement((AvecTranslation)new Cercle(new Point(0,0),10.));
		tab3[2] = new Deplacement((AvecTranslation)new Cercle(new Point(2,2),5));
		tab3[3] = new Deplacement((AvecTranslation)new Rectangle(new Point(2,2),10.,5));
		for(int i  = 0; i<3;i++) {
			System.out.println("+++++++++++++++++++");
			for(Deplacement d : tab3) {
				d.top(5, 5);
				d.afficher();
				System.out.println("**************");
			}
		}
		
		
	}

}
