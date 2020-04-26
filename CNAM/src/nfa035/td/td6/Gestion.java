package nfa035.td.td6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;



import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Gestion {
	private Map<NumBon, Fiche> commandes;
	private ArrayList<Fiche> tab;
	private static Scanner sc,sc2,sc3;


	public Gestion() {
		commandes = new TreeMap<NumBon, Fiche>();
		tab = new ArrayList<Fiche>();
	}
	public void ajouteFiche(Fiche fiche) {
		tab.add(fiche);
	}

	public void afficheFiches() {
		
		int i =0;
		for (Fiche fiche : tab) {
			System.out.print((i+1) + " - ");
			fiche.affiche();
			System.out.println();
			i++;
		}
	}
	public Fiche ajouteCommande(String numBon,LocalDate date, Fiche fiche) {
		NumBon ajout = new NumBon(numBon,date);
		System.out.println(ajout.hashCode());
		return commandes.put(new NumBon(numBon,date), fiche);
	}

	public void afficheCommandes() {
		
		for(Iterator<Entry<NumBon, Fiche>> i = commandes.entrySet().iterator();i.hasNext();) {
			Map.Entry<NumBon, Fiche> entree = i.next();
			System.out.print("Commande numéro: " +entree.getKey().toString() +" ---> ");
			entree.getValue().affiche();
			System.out.println();
		}
		System.out.println();
	}
	
	public void supprimeCommande(String numBon) {
		this.getCommandes().remove(new NumBon(numBon));
	}
	
	
	/**
	 * @return le commandes
	 */
	public Map<NumBon, Fiche> getCommandes() {
		return commandes;
	}
	/**
	 * @return le tab
	 */
	public ArrayList<Fiche> getTab() {
		return tab;
	}

	/**
	 * @param tab le tab à éditer
	 */
	public void setTab(ArrayList<Fiche> tab) {
		this.tab = tab;
	}

	public static void menu1(Gestion g) {
		boolean afficheMenu = true;
		int choix = 0;
		sc = new Scanner(System.in);
		while (afficheMenu) {
			System.out.println("0 - quitter");
			System.out.println("1 - Gestion clients");
			System.out.println("2 - Gestion commandes");
			choix = sc.nextInt();
			switch (choix) {
			case 0:
				afficheMenu = false;
				break;
			case 1:
				menu11(g);
				break;
			case 2:
				menu12(g);
				break;
			default:
				System.out.println("Erreur de choix");
			}
		}
	}
	public static void menu11(Gestion g) {
		boolean afficheMenu = true;
		int choix = 0;
		sc2 = new Scanner(System.in);
		while (afficheMenu) {
			System.out.println("0 - retour");
			System.out.println("1 - Ajouter client");
			System.out.println("2 - Modifier client");
			System.out.println("3 - Afficher les commande du client");
			choix = sc2.nextInt();
			switch (choix) {
			case 0:
				afficheMenu = false;
				break;
			case 1:
				System.out.println("Non implémenté");
				break;
			case 2:
				System.out.println("Non implémenté");
				break;
			case 3 :
				g.afficheFiches();
				System.out.println("De quel client voulez vous voir les commande");
				int iFiche = sc3.nextInt()-1;
				Set<Entry<NumBon,Fiche>> set =  g.getCommandes().entrySet();
				Iterator<Map.Entry<NumBon, Fiche>> i = set.iterator();
				while(i.hasNext()) {
					Map.Entry<NumBon, Fiche> entry = i.next();
					if(g.getTab().get(iFiche).getNom().equals(entry.getValue().getNom())) {
						System.out.print("Commande numéro: " +entry.getKey() +" ---> ");
						entry.getValue().affiche();
					}
				}
				break;
			default:
				System.out.println("Erreur de choix");
			}
		}
	}	
	
	public static void menu12(Gestion g) {
		sc3 = new Scanner(System.in);
		boolean afficheMenu = true;
		int choix = 0;
		while (afficheMenu) {
			System.out.println("0 - retour");
			System.out.println("1 - Afficher Commande");
			System.out.println("2 - Ajouter commande");
			System.out.println("3 - Supprimer Commande");
			choix = sc.nextInt();
			switch (choix) {
			case 0:
				afficheMenu = false;
				break;
			case 1:
				g.afficheCommandes();
				break;
			case 2:
				g.afficheFiches();
				System.out.println("Quel client correspond la commande; entrer le numéro associé");
				int iFiche = sc3.nextInt()-1;
				System.out.println("Entrer le numéro de la commande :");
				sc3.nextLine();
				String str = sc3.nextLine();
				System.out.println("Entrer la date de commande :");
				String date = sc3.nextLine();
				if(g.getCommandes().containsKey(new NumBon(str)))
					System.out.println("Le numéro de commande " + str +" est déjà utilisé");
				else {
					 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
					g.ajouteCommande(str,LocalDate.parse(date, formatter), g.getTab().get(iFiche));
					System.out.println("Commande enregistrée");
				}
				
				break;
			case 3:
				g.afficheCommandes();
				System.out.println("Quele commande voulez vous supprimer ?");
				String str1 = sc3.nextLine();
				g.supprimeCommande(str1);
				break;
			default:
				System.out.println("Erreur de choix");
			}
		}
	}
	


}
