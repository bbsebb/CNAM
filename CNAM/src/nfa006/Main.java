package nfa006;




public class Main {

	public static void main(String[] args) {
		
		long t1,t2,t3,t4,t5,t6;
		int[] tab = new int[100000000];
		AlgoTab.affectTabTri(tab);
		int r = 1;
		//tab[99] = r;
		long tTri1 = System.currentTimeMillis();
		
		long tTri2 = System.currentTimeMillis();
		t1 = System.currentTimeMillis();
		System.out.println("A : " +RechercheTab.rechercheSeq(r, tab));
		t2 = System.currentTimeMillis();
		t3 = System.currentTimeMillis();
		System.out.println("B : " +RechercheTab.rechercheDic(r, tab));
		t4 = System.currentTimeMillis();
		t5 = System.currentTimeMillis();
		//System.out.println("C : " +RechercheTab.rechercheDic(r, tab,0,tab.length-1));
		t6= System.currentTimeMillis();
		System.out.println("Recherche séquentiel : " +(t2-t1));
		System.out.println("Recherche dicotomique : " +(t4-t3));
		System.out.println("Recherche dicotomique récursive : " +(t6-t5));
		System.out.println("Temps tri : " +(tTri2-tTri1));
		int[] tab2 = {1,5,6,9,12};
		System.out.println(RechercheTab.rechercheDic(7, tab2));
		System.out.println(RechercheTab.rechercheDic(0, tab2));
		System.out.println(RechercheTab.rechercheDic(11, tab2));
		System.out.println(RechercheTab.rechercheDic(13, tab2));
	}
	
 static int inverse(int n) {
	int r = 0;
	if(n>0)
		return r;
	return r +inverse(n/10);
}
}
