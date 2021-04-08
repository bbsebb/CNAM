package utc503.td2;

import java.util.Scanner;

public class Exo1 {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.next().trim();
			String[] strTab = str.split("/");
			if(strTab.length!=3 ) {
				System.out.println("erreur"); }
			else {
				int date = Integer.valueOf(strTab[0]);
				int mois = Integer.valueOf(strTab[1]);
				int annee = Integer.valueOf(strTab[2]);
				if(estDate(date,mois,annee)) {
					System.out.println(str +" est une date valide");
				} else {
					System.out.println(str +" n'est pas une date valide");
				}
			}
		}
		
	}
	
	static boolean estAnneeBis(int annee) {
		if(annee%4==0 && annee%100!=0) {
			return true;
		}
		if(annee%400==0) {
			return true;
		}
		return false;
	}
	
	
	
	static boolean estDate(int jour,int mois, int annee) {
		boolean rtr = false;
		if(mois == 1 || mois == 3 ||mois == 5 || mois == 7 || mois == 8 || mois == 10 || mois == 12) {
			if(jour>0 && jour < 32) {
				rtr = true;
			}
		} else if(mois == 4 || mois == 6 ||mois == 9 || mois == 11 ) {
			if(jour>0 && jour < 31) {
				rtr = true;
			}
		} else {
			if(estAnneeBis(annee)) {
				if(jour>0 && jour< 30) {
					rtr = true;
				}
			} else {
				if(jour>0 && jour< 29) {
					rtr = true;
				}
			}
		}
		return rtr;
	}

}
