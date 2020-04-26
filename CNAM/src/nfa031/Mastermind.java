package nfa031;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mastermind {

	static String COULEURS[] = {"rouge","jaune","vert","bleu","orange","blanc","violet","fuchsia"};
	//static String TEST[] = {"rouge","jaune","vert","bleu"};
	static int NB_COULEUR = 4;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> combinaison = new ArrayList<String>(resetCombinaison()); //Combinaison à trouver
		//ArrayList<String> combinaison = new ArrayList<String>(Arrays.asList(TEST));
		ArrayList<String> combinaisonJoueur = new ArrayList<String>(); //Combinaison du joueur
		ArrayList<String> couleurs = new ArrayList<String>(Arrays.asList(COULEURS));
		int nbrCoups = 12,numCouleur,nbBonnePlace=0,nbBonneCouleur=0;
		boolean fin = false;
		
		
		System.out.println("Vous allez commencer une partie de Mastermind. Vous avez 12 chances pour trouver une combinaison"
				+ " de 4 couleurs dans l'ordre. C'est partie !");
		System.out.println("Tapez, quand demandé, le numero pour indiquer votre choix pour la couleurs (attention, le code couleur peut changer) : ");
		
		
		while(nbrCoups>0 && (!fin)) { //Boucle pour chaque coup - Fin si gagné avant les 12 coups
			System.out.println("***************************************************************************************************************************");
			System.out.println("il vous reste " + nbrCoups +" coups");
			
			
			int j = 0;
			while(j< NB_COULEUR) { // Boucle pour le choix des couleurs 
				System.out.println("Entrez le code couleur pour le choix "+(j+1)+" de votre combinaison: ");
				int i = 0;
				for(String couleur : couleurs) { // Affichage Couleur
					System.out.println("Couleur " + i + " : " + couleur); 
					i++;
				}
				
				numCouleur=sc.nextInt();
				if(numCouleur<couleurs.size() && numCouleur>=0) { 
					combinaisonJoueur.add(couleurs.get(numCouleur)); // Enregistrement Couleur
					couleurs.remove(numCouleur); // On supprime la couleur choisie à la prochaine boucle
					j++;
					
				} else
					System.out.println("Mauvais choix de couleur, Réessayez !");
			}
			
			nbBonnePlace = nbBonnePlace(combinaisonJoueur,combinaison);
			nbBonneCouleur = nbBonneCouleur(combinaisonJoueur,combinaison);
			
			if(nbBonnePlace == 4 && nbrCoups>0) {
				fin = true;
				System.out.println("\n\n *****************Vous avez gagné !***************** \n\n");
			}
			else if(nbrCoups==1){
				fin = true; // Ou nbrCoups--;
				System.out.println("\n\n *****************Vous avez perdu !***************** \n\n La bonne combinaison était :");
				affichageList(combinaison);
			}
			else {	
				System.out.println("Vous avez choisis cette combinaison !");
				affichageList(combinaisonJoueur);
				System.out.println("\nVous avez " + nbBonneCouleur +" bonne(s) couleur(s) et "
						+ nbBonnePlace +" couleur(s) bien placée(s)");		
				nbrCoups--;
			}
			
			if(fin) { // Si gagné ou perdu, on propose de refaire une partie
				System.out.println("\n\nVoulez-vous recommencer une partie ? O - N");
				sc.nextLine();
				if(sc.nextLine().charAt(0) == 'O') {
					fin = false;
					nbrCoups = 12;
					combinaison = resetCombinaison();
					System.out.println("*************************************************Nouvelle partie***********************************************************");
				}
				else
					System.out.println("Au revoir !");
			}
			
			combinaisonJoueur.clear();
			couleurs = new ArrayList<String>(Arrays.asList(COULEURS));
			
		}
		sc.close();
	}
	
	
	
	
	
	// Renvoie le nombre d'item identique entre les deux listes
	static int nbBonneCouleur(ArrayList<String> comb,ArrayList<String> comb2) {
		int i = 0;
		for(String couleur : comb) {
			if(comb2.contains(couleur))
				i++;
		}
		return i;
	}
	
	// Renvoie le nombre d'item identique et à la même place entre les deux listes
	static int nbBonnePlace(ArrayList<String> comb,ArrayList<String> comb2) {
		int j=0;
		for(int i = 0; i<comb.size();i++) {
			if(comb2.get(i).equals(comb.get(i)))
				j++;
		}
		return j;
	}	
	
	// Renvoie une combinaison de 4 couleurs au hasard
	static ArrayList<String> resetCombinaison() {
		ArrayList<String> couleurs = new ArrayList<String>(Arrays.asList(COULEURS));
		ArrayList<String> combinaison = new ArrayList<String>();
		for(int i = 0; i<NB_COULEUR;i++) {
			int random = (int)(Math.random()*couleurs.size());
			combinaison.add(couleurs.get(random));
			couleurs.remove(random);
		}
		return combinaison;
	}
	
	// Affiche une liste
	static void affichageList(ArrayList<String> list) {
		int i = 1;
		System.out.print("| ");
		for(String item : list) {
			System.out.print(i +" - "+ item + " | ");
			i++;
		}
	}

}



