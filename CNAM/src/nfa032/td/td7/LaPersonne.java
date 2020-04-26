package nfa032.td.td7;

public class LaPersonne {
	LaDate naissance;
	String nom;

	public LaPersonne(String name, LaDate naiss) {
		this.nom = name;
		this.naissance = naiss;
	}

	public void ecrire() {
		System.out.println(nom + " (");
		naissance.ecrire();
		System.out.println(")");
	}
}
