package nfa032.td.td2;

public class Compte2{
	private int solde;
	private String nom;
	
	public Compte2() {
		this.solde = 0;
		this.nom = "inconnu";
	}
	
	public  Compte2(String nom) {
		this.solde = 0;
		this.nom = nom;
	}
	
	public void deposer(int montant){
	solde = solde + montant;
	}
	
	public void retirer(int montant){
	solde = solde -montant;
	}
	
	public void virerVers(int montant, Compte destination){
	this.retirer(montant);
	destination.deposer(montant);
	}
	
	public void afficher(){
		System.out.println("titulaire: "+ nom);
	System.out.println("solde: "+ solde);
	}
}
