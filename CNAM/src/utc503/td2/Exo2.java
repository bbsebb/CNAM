package utc503.td2;

public class Exo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pgcdRec(97, 22));
	}

	static int pgcd(int a, int b) {
		if (a < b || a == 0 || b == 0) {
			System.out.println("erreur");
		}

		while (b != 0) {
			int reste;
			reste = a % b;
			a = b;
			b = reste;
		}
		return a;

	}
	
	static int pgcdRec(int a,int b) {
		int resultat=a;
		if(b!=0) {
			resultat = pgcdRec(b,a%b);
		}
		return resultat;
	}

}
