package nfa032.td.td3;

import nfa032.td.td2.Compte;

public class Compte3{
	private int solde,num;
	private static int nbrCompte = 0;
	private String nom;
	
	public Compte3() {
		this.solde = 0;
		this.nom = "inconnu";
		nbrCompte ++;
		this.num =nbrCompte;
	}
	
	public  Compte3(String nom) {
		this.solde = 0;
		this.nom = nom;
		nbrCompte ++;
		this.num =nbrCompte;
	}
	
	public void deposer(int montant){
	solde = solde + montant;
	}
	
	public void retirer(int montant){
		if((solde-montant)<0) {
			System.out.println("Retrait impossible, solde insuffisant :" + solde);
		}
		else {
			solde = solde -montant;
		}

	}
	
	public void virerVers(int montant, Compte destination){
	this.retirer(montant);
	destination.deposer(montant);
	}
	
	public void afficher(){
		System.out.println("titulaire: "+ nom);
		System.out.println("numero de compte: "+ num);
	System.out.println("solde: "+ solde);
	}
}
