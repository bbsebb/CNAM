package nfa006;

public class RechercheTab {

	public static int rechercheSeq(int e, int[] tab) {
		int i;
		for (i = 0; i < tab.length; i++) {
			if (tab[i] == e)
				return i;
		}
		if (i == tab.length)
			i = -1;
		return i;
	}

	public static int rechercheDic(int e, int[] tab) {
		int m, d, f,milieu;
		d = 0;
		f = tab.length - 1;
		m =( tab.length-1) / 2;
		milieu = tab[m];
		while (d <= f && milieu!=e) {
			if (e > m)
				d = m + 1;
			else
				f = m-1;
			m=(d+f)/2;
			milieu = tab[m];
		}
		System.out.println(d+" --" + m +"-- " +f);
		if(d>f)
			return -1;
		return milieu;
	}
	
	public static int rechercheDic(int e, int[] tab,int debut,int fin) {
		int m, milieu;
		
		milieu = (tab.length - 1)/2;
		m = tab[milieu];
		if (debut <= fin && m!=e) {
			if (e > m)
				milieu =rechercheDic( e,  tab, milieu+1, fin);
			else
				milieu = rechercheDic( e,  tab, debut, milieu-1);
		} 
		return milieu;
	}

	
}
