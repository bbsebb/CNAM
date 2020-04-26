package nfa032.td.td7;

public class Volailles {
	Volaille[] v = new Volaille[10000];
	private int indice = 0;

	public Volailles() {
	}

	public Volailles(Volaille[] v) {
		for (Volaille volaille : v) {
			this.v[indice] = volaille;
			indice++;
		}
	}

	public void ajout(Volaille v) {
		if (indice < 10000) {
			this.v[indice] = v;
			indice++;
		} else
			System.out.println("Elevage plein");
	}

	public int prixAbattage(String espece) {
		return Volailles.prixAbattage(this, espece);
	}

	public static int prixAbattage(Volailles v, String espece) {
		Volaille[] volaillesAAabattre;
		if (espece == "poulet") {
			volaillesAAabattre = tabPoulet(v);
		} else if (espece == "canard") {
			volaillesAAabattre = tabCanard(v);
		} else {
			volaillesAAabattre = null;
		}
		int total = 0;
		for (Volaille volaille : volaillesAAabattre) {
			total = total + volaille.abattre();
		}
		return total;
	}

	public static Poulet[] tabPoulet(Volailles v) {
		Poulet[] poulets = new Poulet[Volailles.nbrPoulet(v)];
		int i = 0;
		for (Volaille volaille : v.v) {
			if (volaille != null) {
				if (estPoulet(volaille)) {
					poulets[i] = (Poulet) volaille;
					i++;
				}
			}

		}
		return poulets;
	}

	public static Canard[] tabCanard(Volailles v) {
		Canard[] canards = new Canard[Volailles.nbrCanard(v)];
		int i = 0;
		for (Volaille volaille : v.v) {
			if (volaille != null) {
				if (estCanard(volaille)) {
					canards[i] = (Canard) volaille;
					i++;
				}
			}
		}
		return canards;
	}

	public static int nbrPoulet(Volailles v) {
		int j = 0;
		for (int i = 0; i < v.v.length; i++) {
			
				if (v.v[i] != null) {
					if (Volailles.estPoulet(v.v[i]))
						j++;
				}
			
		}
		return j;
	}

	public static int nbrCanard(Volailles v) {
		int j = 0;
		for (int i = 0; i < v.v.length; i++) {
			
				if (v.v[i] != null) {
					if (Volailles.estCanard(v.v[i]))
						j++;
				}
			
		}
		return j;
	}

	private static boolean estPoulet(Volaille v1) {
		if (v1.espece.equals("poulet"))
			return true;
		else
			return false;
	}

	private static boolean estCanard(Volaille v1) {
		if (v1.espece.equals("canard"))
			return true;
		else
			return false;
	}
}
