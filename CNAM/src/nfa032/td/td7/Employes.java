package nfa032.td.td7;

public class Employes {
	Employe[] e = new Employe[10000];

	public Employes() {
		
	}
	
	public Employes(Employe[] e) {
		this.setE(e);
	}	
	public Employe[] getE() {
		return e;
	}

	public void setE(Employe[] e) {
		this.e = e;
	}
	
	public void affiche() {
		for (Employe employe : this.e) {
			employe.afficher();;
		}
	}

	public double salaireTotal() {
		double total = 0;
		for (Employe employe : this.e) {
			total = total + employe.salaire();
		}
		return total;
	}
}
