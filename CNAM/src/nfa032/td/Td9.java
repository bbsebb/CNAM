package nfa032.td;

import nfa032.td.td9.Liste;

public class Td9 {

	public static void main(String[] args) {
		//Exercice 1.1.2
		Liste liste = new Liste(); // liste a construire
		do {
			int val = Terminal.lireInt();
			if (val == 0)
				break;
			if (!liste.contient(val))
				liste.ajouterAuDebut(val);
		} while (true);
		//Question1
		System.out.println("Liste itérative");
		liste.ecrireListeI();
		//Question2-3
		System.out.println("Liste récursive");
		liste.ecrireListeR();
		//Exercice 1.1.3
		System.out.println();
		liste.insererEntre(101);
		liste.ecrireListeR();

	}

}
