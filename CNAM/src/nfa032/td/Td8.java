package nfa032.td;

import nfa006.AlgoTab;

public class Td8 {
	public static void main(String[] args) {

		// Exerice 7.1.1
		// 1
		System.out.println(premierCarre(3));
		// 2
		int[] tab = { 1, 5, -5, 3, 2, -3, 7, -20, 2 };
		System.out.println(sommePos(tab, tab.length - 1));
		// 3
		System.out.println(estPalindrome("raddar", "raddar".length() - 1, 0));
		// 4
		inverseTab(tab, tab.length - 1, 0);
		AlgoTab.afficher(tab);
		// 5
		System.out.println(stringToInt("251", "251".length() - 1));
		// Exercice 7.1.2
		System.out.println(fib(5));
		System.out.println(fibi(5));
	}

	static int premierCarre(int n) {

		if (n == 0) {
			return 0;
		} else {

			return n * n + premierCarre(n - 1);
		}
	}

	static int sommePos(int[] t, int n) {

		if (n == 0) {
			return t[0];
		} else {

			if (t[n] >= 0)
				return t[n] + sommePos(t, n - 1);
			else
				return sommePos(t, n - 1);
		}
	}

	static boolean estPalindrome(String s, int n, int m) {

		if (m < n) {
			if (s.charAt(m + 1) == s.charAt(n - 1))
				return true && estPalindrome(s, n - 1, m + 1);
			else
				return estPalindrome(s, n - 1, m + 1);
		} else {

			return s.charAt(m) == s.charAt(n);
		}
	}

	static void inverseTab(int[] t, int n, int m) {
		if (n > m) {
			int temp = t[n];
			t[n] = t[m];
			t[m] = temp;
			inverseTab(t, n - 1, m + 1);
		}
	}

	static int stringToInt(String s, int n) {
		if (n == 0) {
			return ((int) s.charAt(n) - 48) * facteur10(s.length() - 1 - n);
		} else {

			return ((int) s.charAt(n) - 48) * facteur10(s.length() - 1 - n) + stringToInt(s, n - 1);
		}
	}

	static int facteur10(int n) {
		if (n == 0)
			return 1;
		else {
			return 10 * facteur10(n - 1);
		}
	}

	static int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	static int fibi(int n) {
		int rslt = 0;
		int rsltAvant = 1;
		int rsltAvantAvant = 0;
		for (int i = 2; i <= n; i++) {
			rslt = rsltAvant + rsltAvantAvant;
			rsltAvantAvant = rsltAvant;
			rsltAvant = rslt;		
		}
		return rslt;
	}

}