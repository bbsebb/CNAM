package nfa032.td.td2;

public class Compte{
	int solde = 0;
	int x, y;
	String nom;
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
	System.out.println("solde: "+ solde);
	}
	

	
}
