package nfa035.td;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import nfa035.td.td6.Fiche;
import nfa035.td.td6.Gestion;

public class Td6 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// 1.1 et 1.2
		//ArrayList<Integer> l1 = listArray();
	//	LinkedList<Integer> l2 = listLinked();
		//TreeSet<Integer> l3 = setTree();
		System.out.println("ArrayList");
		//afficherBoucle(l1);
	//	afficherIterator(l1);
		System.out.println("******************");
		System.out.println("LinkedList");
	//	afficherBoucle(l2);
	//	afficherIterator(l2);
		System.out.println("******************");
		System.out.println("Collection");
	//	afficherIterator(l3);
		// 1.3
		// A.D.E.F.
		Gestion g = new Gestion();
		g.ajouteFiche(new Fiche("Dupont pierre","Rue de Paris 51100 REIMS", "a@b.r",  "3612"));
		g.ajouteFiche(new Fiche("Dupont Jeab","Rue de Vesles 51100 REIMS", "a@b.r",  "3612"));
		g.ajouteFiche(new Fiche("Dupuis Jacques","Rue de Libergier 51100 REIMS", "a@b.r",  "3612"));
		g.ajouteFiche(new Fiche("Dupuis Jane","Rue de Libergier 51100 REIMS", "a@b.r",  "3612"));
		Gestion.menu1(g);
		/* 
		 * B.
		 * Non
		 * C.
		 * La nouvelle commande remplace l'ancienne.
		 */
	}

	static ArrayList<Integer> listArray() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		System.out.println("Entrer un chiffre");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {

			l.add((int) (Math.random() * 500));
		}
		Collections.sort(l);
		return l;
	}

	static LinkedList<Integer> listLinked() {
		int s, d, f, m;
		LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("Entrer un chiffre");
		Integer n = sc.nextInt();
		Integer rdm = (int) (Math.random() * 500);
		for (int i = 0; i < n; i++) {
			rdm = (int) (Math.random() * 500);
			s = l.size();
			d = 0;
			f = s - 1;
			while (d <= f && !l.isEmpty()) {
				m = (f + d) / 2;
				if (l.get(m).compareTo(rdm) < 0)
					d = m + 1;
				else
					f = m - 1;

			}
			l.add(d, rdm);

		}
		return l;
	}

	static TreeSet<Integer> setTree() {

		TreeSet<Integer> l = new TreeSet<Integer>();
		System.out.println("Entrer un chiffre");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {

			l.add((int) (Math.random() * 500));
		}

		return l;
	}

	static void afficherBoucle(List<Integer> l) {
		System.out.println("Boucle normal");
		for (int i = 0; i < l.size(); i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println();
		System.out.println("----------");
	}

	static void afficherIterator(List<Integer> l) {
		System.out.println("Boucle Iterator");
		for (Iterator<Integer> i = l.iterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
		System.out.println("----------");
	}

	static void afficherIterator(Set<Integer> l) {
		System.out.println("Boucle Iterator");
		for (Iterator<Integer> i = l.iterator(); i.hasNext();) {
			System.out.print(i.next() + " ");
		}
		System.out.println();
		System.out.println("----------");
	}
}
