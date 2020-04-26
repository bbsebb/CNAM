package nfa035.td.td5;

import java.util.ArrayList;
import java.util.Iterator;

import nfa035.td.td4.exo1.Enseignant;
import nfa035.td.td4.exo1.Etudiant;
import nfa035.td.td4.exo1.MenuAffectationEnseignant;
import nfa035.td.td4.exo1.MenuEtudiants;
import nfa035.td.td4.exo1.MenuInscription;
import nfa035.td.td4.exo1.MenuinscriptionEnseignant;
import nfa035.td.td4.exo1.MenuinscriptionUE;
import nfa035.td.td4.exo1.UE;
import nfa035.td.td4.exo1.UEDistance4;
import nfa035.td.td4.exo1.UEDistance5;
import nfa035.td.td4.exo1.UEPresentiel;

/**
 * Cette classe est le CNAM de Reims
 * 
 * @author bbseb
 *
 */
public class CentreReimsA implements MenuAffectationEnseignant, MenuEtudiants, MenuInscription,
		MenuinscriptionEnseignant, MenuinscriptionUE {


	private static ArrayList<Etudiant> lesEtudiants;
	private static ArrayList<Enseignant>  lesEnseignants;
	private static ArrayList<UE>  lesUE;
	private int nbetudiant = 0, nbenseignant = 0, nbue = 0;

	/**
	 * Contructeur instanciant le CNAM avec un tableau d'enseignant, d'étudiant et
	 * d'UE.
	 */
	public CentreReimsA() {
		lesEnseignants = new ArrayList<Enseignant>();
		lesEtudiants = new ArrayList<Etudiant>();
		lesUE = new ArrayList<UE>();
		nbetudiant = 0;
		nbenseignant = 0;
		nbue = 0;
	}

	@Override
	public void ajouterUEPresentiel(String codeUE, String intituleUE, String enseignant) {

		lesUE.add(new UEPresentiel(codeUE, intituleUE, enseignant, "NC"));
		nbue++;
		System.out.println("UE ajouté correctement");

	}

	@Override
	public void ajouterUEDistance4(String codeUE, String intituleUE, String enseignant) {

		lesUE.add(nbue,new UEDistance4(codeUE, intituleUE, enseignant));
		Enseignant e = this.recherchePersonneParNom(enseignant);
		if (e != null)
			e.setNbSeance(e.getNbSeance() + lesUE.get(nbue).getnombreTutorat());
		nbue++;
		System.out.println("UE ajouté correctement");
	}

	@Override
	public void ajouterUEDistance5(String codeUE, String intituleUE, String enseignant) {

		lesUE.add(nbue, new UEDistance5(codeUE, intituleUE, enseignant));
		Enseignant e = this.recherchePersonneParNom(enseignant);
		if (e != null)
			e.setNbSeance(e.getNbSeance() + lesUE.get(nbue).getnombreTutorat());
		nbue++;
		System.out.println("UE ajouté correctement");
	}

	@Override
	public void consulterEnseignant(String nom) {

		Enseignant enseignant = this.recherchePersonneParNom(nom);
		if (enseignant == null)
			System.out.println("Enseignant inconnu");
		else
			enseignant.afficher();
	}

	@Override
	public void listeUEEnseignant(String nom) {

			Iterator<UE> i;
			for( i =  lesUE.iterator();i.hasNext();) {		
				UE ue = i.next();
				if (ue.getEnseignant().equals(nom)) {
					ue.afficher();
					break;
				}	
				
			}

		
		if (!i.hasNext()) {
			System.out.println("Enseignant inconnu");
		}
	}

	@Override
	public void ajouterEnseignant(String nom, String prenom, String adresse, String tel, String email) {

		lesEnseignants.add(nbenseignant, new Enseignant(nom, prenom, adresse, tel, email));
		nbenseignant++;
		System.out.println("Enseignant ajouté correctement");
	}

	@Override
	public void ajouterEnseignant(String nom, String email) {

		lesEnseignants.add(nbenseignant, new Enseignant(nom, email));
		nbenseignant++;
		System.out.println("Enseignant ajouté correctement");
	}

	@Override
	public void modifierEnseignant(String nom, String prenom, String adresse, String tel, String email) {

		Enseignant enseignant = this.recherchePersonneParNom(nom);
		if (enseignant != null) {
			enseignant.modifier(nom, prenom, adresse, tel, email);
			System.out.println("Enseignant modifié correctement");
		} else
			System.out.println("Erreur, enseignant non trouvé");

	}

	@Override
	public void afficherUEEtudiant() {
		for (Etudiant e : lesEtudiants) {
			
			e.afficher();
			e.afficherUE();
		}		
	}

	@Override
	public boolean ajouterUEEtudiant(int et, String codeUE) {

		for (Iterator<Etudiant> i = lesEtudiants.iterator();i.hasNext();) {
			Etudiant e = i.next();
			if (e.getEt() == et && !e.estDAnsUE(codeUE)) {
				for (Iterator<UE> j = lesUE.iterator();j.hasNext();) {
					UE ue = j.next();
					if (ue.getCodeUE().equals(codeUE)) {
						e.ajouterUE(ue);
						return true;

					}
				}
			}
		}

			return false;
	}

	@Override
	public void listeEtudiants() {

		for (Etudiant e : lesEtudiants) {
			e.afficher();
		}
	}

	@Override
	public void consulterEtudiant(int et) {

		int i = 0;
		for (Etudiant e : lesEtudiants) {
			if (e.getEt() == et) {
				e.afficher();
				break;
			}
			i++;
		}
		if (i > this.nbetudiant)
			System.out.println("Etudiant inconnu");
	}

	@Override
	public void ajouterEtudiant(int et, String nom, String prenom, String adresse, String tel, String email) {

		lesEtudiants.add(nbetudiant, new Etudiant(nom, prenom, adresse, tel, email, et));
		nbetudiant++;
		System.out.println("Etudiant ajouté correctement");
	}

	@Override
	public void ajouterEtudiant(int et, String nom) {

		lesEtudiants.add(nbetudiant, new Etudiant(nom, et));
		nbetudiant++;
		System.out.println("Etudiant ajouté correctement");
	}

	@Override
	public void modifierEtudiant(int et, String nom, String prenom, String adresse, String tel, String email) {
		boolean estModifier = false;
		for (Etudiant e : lesEtudiants) {
			if (e.getEt() == et) {
				e.setNom(nom);
				estModifier = true;
				break;
			}
		}
		if (estModifier)
			System.out.println("Etudiant ajouté correctement");
		else
			System.out.println("Erreur, étudiant non trouvé");
	}

	@Override
	public void listeUE() {

		for (UE ue : lesUE) {
			ue.afficher();
		}
	}

	@Override
	public void listeEnseignant() {

		for (Enseignant e : lesEnseignants) {
			e.afficher();
		}
	}

	@Override
	public void affecterEnseignant(String codeUE, String nom) {
		boolean bienAffecter = false;
		Enseignant enseignant = this.recherchePersonneParNom(nom);
		for (Iterator<UE> i = lesUE.iterator();i.hasNext();) {
			UE ue = i.next();
			if (ue.getCodeUE().equals(codeUE) && enseignant != null) {
				ue.setEnseignant(enseignant.getNom());
				enseignant.setNbSeance(enseignant.getNbSeance() + ue.getnombreTutorat());
				bienAffecter = true;
				break;
			}
		}
		if (bienAffecter)
			System.out.println("Ajout correctement effectué ");
		else
			System.out.println("Erreur, Enseignant non trouvé");
	}

	/**
	 * Recherche un enseignant par nom et renvoie l'instance de cette enseignant
	 * 
	 * @param nom : nom de l'enseignant à trouver
	 * @return l'instance de l'enseignant trouver ou null
	 */
	private Enseignant recherchePersonneParNom(String nom) {
		Enseignant rtr = null;
		for (Enseignant e : lesEnseignants) {
			if (e.getNom().equals(nom))
				return e;
		}
		return rtr;
	}

}

