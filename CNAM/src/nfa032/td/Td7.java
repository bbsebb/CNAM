package nfa032.td;

import nfa032.td.td7.Cadre;
import nfa032.td.td7.Commercial;
import nfa032.td.td7.Employe;
import nfa032.td.td7.Employes;
import nfa032.td.td7.LaDate;
import nfa032.td.td7.LaPersonne;
import nfa032.td.td7.LaPersonneLieu;

public class Td7 {

	public static void main(String[] args) {

		
		// Exercice 6.1.1
		/*
		 * YYY est CompteBancaire : XXX peut �tre les 4 classes YYY est
		 * CompteAvecDecouvert XXX peut etre CompteAvecDecouvert ou CompteBancaire YYY
		 * est CompteRemunerer XXX peut etre CompteBancaire ou CompteRemunerer YYY est
		 * CompteRemunererAvecDecouvert XXX peut etre CompteBancaire ou CompteRemunerer
		 * ou CompteRemunererAvecDecouvert TTT est CompteRemunerer ZZZ peut etre
		 * CompteBancaire ou CompteRemunerer TTT est CompteRemunererAvecDecouvert ZZZ
		 * peut etre CompteBancaire ou CompteRemunerer ou CompteRemunererAvecDecouvert
		 */
		// Exercice 6.1.2
		LaPersonne p = new LaPersonneLieu("Seb", new LaDate(30, 05, 1986), "Strasbourg");
		p.ecrire();
		// Exercice 6.1.3
		Employe[] employes = new Employe[5];

		Employe e1 = new Employe("Seb", 50);
		Employe e2 = new Employe("Julie", 50);
		Employe e3 = new Employe("Jean", 50);
		Employe[] equipe = { e1, e2, e3 };
		Employe e4 = new Cadre("Laurie", 90, equipe);
		((Cadre) e4).afficherEquipe();
		Commercial e5 = new Commercial("Jean", 50);
		e5.setVenteMois(1500);
		employes[0] = e1;
		employes[1] = e2;
		employes[2] = e3;
		employes[3] = e4;
		employes[4] = e5;
		
		
		Employes e = new Employes(employes);
		System.out.println(e1.salaire() + e2.salaire() + e3.salaire() + e4.salaire() + e5.salaire());
		System.out.println(e.salaireTotal());
		e.affiche();
		for (Employe employe : employes) {
			employe.afficher();
		}
	}

}
