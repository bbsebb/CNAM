package nfa032.td;

import java.util.Scanner;

import nfa032.td.td4.Menu;



public class Td4 {
	
	public static void main(String[] args) {
		
		//Exerice 4.1.1
		
		Scanner sc = new Scanner(System.in);
		int x, y;
		boolean a=false;
		do {
			System.out.println("Entrez l’indice de l’entier à diviser: ");
			x = sc.nextInt();
			System.out.println("Entrez le diviseur: ");
			y = sc.nextInt();

			try {
				System.out.println("Le résultat de la division est: ");
				System.out.println(division(x,y));
			} catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Une erreur est survenu: "+e.getMessage());
				System.out.println("Une erreur est survenu: "+e.toString());
				a=true;
			}
		}
		while(a);
		
		//Exercice 4.1.2
		/* 3 : D3D2M2D1M1F1F2F3
		 * 2 : D3D2Erreur
		 * 1 : D3D2M2D1M1D3F3
		 * 0 : D3D2M2D1Erreur
		 */
		
		//Exercice 4.1.3
		String[] menu1 = {"Saumon fumé","Canard laqué","Iles flottantes"};
		String[] menu2 = {"Rillette","Poulet roti","Savarin"};
		String[] menu3 = {"Salade cesar","Bouchée à la reine","Muffin"};
		
		Menu m1 = new Menu(menu1);
		m1.choix();
		Menu m2 = new Menu(menu2);
		m2.choix();
		Menu m3 = new Menu(menu3);
		m3.choix();
		sc.close();
	}
	
	static int[] tableau = {17, 12, 15, 38, 29, 157, 89, -22, 0, 5};
	static int division(int indice, int diviseur) {
		return tableau[indice]/diviseur;
	}
	
}



