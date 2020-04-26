package nfa035.td;

import java.util.ArrayList;
import java.util.Iterator;

public class Td5 {

	public static void main(String[] args) {
		// 1.1
		ArrayList<String> L = new ArrayList<String>();
		for (int i = 1; i < 7; i++) {
			L.add("position " + i);
		}
		System.out.println("********************");
		afficheListeSt(L);
		L.set(4, "element remplacé");
		System.out.println("********************");
		afficheListeSt(L);
		L.add(3, "element ajouté");
		System.out.println("********************");
		afficheListeSt(L);
		L.remove(2);
		System.out.println("********************");
		afficheListeSt(L);
		//L.remove(20);
		System.out.println("********************");
		afficheListeSt(L);
		// L.add(30,"position 30");
		System.out.println("********************");
		afficheListeSt(L);
		// 1.2
		ArrayList<Chiffre> L1 = new ArrayList<Chiffre>();
		for (int i = 1; i < 7; i++) {
			L1.add(new Chiffre(i));
		}
		afficheListeChiffre(L1);
		Chiffre autrefois = new Chiffre(3);
		if (L1.contains(autrefois)) System.out.println("Nouveau Chiffre 3 dedans.");
		else System.out.println("Nouveau Chiffre 3 pas dedans.");
		int nindex = L1.indexOf(autrefois);
		System.out.println("Indice trouve pour Nouveau Chiffre 3:"+ nindex );
		// avec celui-ci
		Chiffre trois = L1.get(4);
		if (L1.contains(trois)) System.out.println("Chiffre de meme adresse dedans.");
		else System.out.println("Pas dedans.");
		int index3 = L1.indexOf(trois);
		System.out.println("Indice trouve pour Chiffre meme adresse : "+index3 );
		/*
		 * Il faudrait redéfinir le méthode equals.
		 */
		//1.3
		ArrayList<Object> L2 = new ArrayList<Object>();
		L2.add(new Chiffre(5));
		L2.add("test1");
		L2.add(new Chiffre(6));
		L2.add("test2");
		afficheListe(L2);
		
		// 2 (en miliseconde)
		/*
		 * A1 : 11 A2 : 3 A3 : 10 B1 : 18 B2 : 9 B3 : 11 C1 : 15 C2 : 10 C3 : 3 D1 : 11
		 * D2 : 3 D3 : 11
		 */

	}

	static void afficheListeSt(ArrayList<String> L) {
		System.out.println("Boucle classique");
		for (int i = 0; i < L.size(); i++) {
			System.out.print(L.get(i) + " - ");
		}
		System.out.println();
		System.out.println("Boucle iterator");
		for (Iterator<String> i = L.iterator(); i.hasNext();) {
			String str = i.next();
			System.out.print(str + " - ");
		}
		System.out.println();
		System.out.println("Boucle for each");
		for (String str : L) {
			System.out.print(str + " - ");
		}
		System.out.println();
	}

	static void afficheListeChiffre(ArrayList<Chiffre> L) {
		System.out.println("Boucle classique");
		for (int i = 0; i < L.size(); i++) {
			System.out.print(L.get(i).get() + " - ");
		}
		System.out.println();
		System.out.println("Boucle iterator");
		for (Iterator<Chiffre> i = L.iterator(); i.hasNext();) {
			Chiffre str = i.next();
			System.out.print(str.get() + " - ");
		}
		System.out.println();
		System.out.println("Boucle for each");
		for (Chiffre str : L) {
			System.out.print(str.get() + " - ");
		}
		System.out.println();
	}
	static void afficheListe(ArrayList<?> L) {

		System.out.println();
		System.out.println("Boucle for each");
		for (Object o : L) {
			if(o instanceof Chiffre)
				System.out.print(((Chiffre)o).get() + " - ");
			if(o instanceof String)
				System.out.print(((String)o) + " - ");
		}
		System.out.println();
	}
	


}
class Chiffre {
	private int num;

	public Chiffre(int i) {
		num = i;
	}

	public Chiffre() {
	}

	public int get() {
		return num;
	}

	public void afficher() {
		System.out.println(num);
	}
}