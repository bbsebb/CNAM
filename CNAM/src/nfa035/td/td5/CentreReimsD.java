package nfa035.td.td5;

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
public class CentreReimsD implements MenuAffectationEnseignant, MenuEtudiants, MenuInscription,
		MenuinscriptionEnseignant, MenuinscriptionUE {
	private static int nbetudiantmax = 1200;
	private static int nbenseignantmax = 1200;
	private static int nbUEmax = 3100;

	private static Etudiant[] lesEtudiants;
	private static Enseignant[] lesEnseignants;
	private static UE[] lesUE;
	private int nbetudiant = 0, nbenseignant = 0, nbue = 0;

	/**
	 * Contructeur instanciant le CNAM avec un tableau d'enseignant, d'étudiant et d'UE.
	 */
	CentreReimsD() {
		lesEnseignants = new Enseignant[nbenseignantmax];
		lesEtudiants = new Etudiant[nbetudiantmax];
		lesUE = new UE[nbUEmax];
		nbetudiant = 0;
		nbenseignant = 0;
		nbue = 0;
	}

	@Override
	public void ajouterUEPresentiel(String codeUE, String intituleUE, String enseignant) {

		lesUE[nbue] = new UEPresentiel(codeUE, intituleUE, enseignant, "NC");
		nbue++;
		System.out.println("UE ajouté correctement");

	}

	@Override
	public void ajouterUEDistance4(String codeUE, String intituleUE, String enseignant) {

		lesUE[nbue] = new UEDistance4(codeUE, intituleUE, enseignant);
		Enseignant e = this.recherchePersonneParNom(enseignant);
		if (e != null)
			e.setNbSeance(e.getNbSeance() + lesUE[nbue].getnombreTutorat());
		nbue++;
		System.out.println("UE ajouté correctement");
	}

	@Override
	public void ajouterUEDistance5(String codeUE, String intituleUE, String enseignant) {

		lesUE[nbue] = new UEDistance5(codeUE, intituleUE, enseignant);
		Enseignant e = this.recherchePersonneParNom(enseignant);
		if (e != null)
			e.setNbSeance(e.getNbSeance() + lesUE[nbue].getnombreTutorat());
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

		int i;
		for (i = 0; i < this.nbue; i++) {
			if (lesUE[i].getEnseignant().equals(nom)) {
				lesUE[i].afficher();
				break;
			}

		}
		if (i > nbenseignant) {
			System.out.println("Enseignant inconnu");
		}
	}

	@Override
	public void ajouterEnseignant(String nom, String prenom, String adresse, String tel, String email) {

		lesEnseignants[nbenseignant] = new Enseignant(nom, prenom, adresse, tel, email);
		nbenseignant++;
		System.out.println("Enseignant ajouté correctement");
	}

	@Override
	public void ajouterEnseignant(String nom, String email) {

		lesEnseignants[nbenseignant] = new Enseignant(nom, email);
		nbenseignant++;
		System.out.println("Enseignant ajouté correctement");
	}

	@Override
	public void modifierEnseignant(String nom, String prenom, String adresse, String tel, String email) {

		Enseignant enseignant = this.recherchePersonneParNom(nom);
		if(enseignant != null) {
			enseignant.modifier(nom, prenom, adresse, tel, email);
			System.out.println("Enseignant modifié correctement");			
		}else
			System.out.println("Erreur, enseignant non trouvé");


	}

	@Override
	public void afficherUEEtudiant() {

		for (int i = 0; i < this.nbetudiant; i++) {
			lesEtudiants[i].afficher();
			lesEtudiants[i].afficherUE();
		}
	}

	@Override
	public boolean ajouterUEEtudiant(int et, String codeUE) {
		
		for (int i = 0; i < this.nbetudiant; i++) {
			if (lesEtudiants[i].getEt() == et && !lesEtudiants[i].estDAnsUE(codeUE)) {
				for (int j = 0; j < this.nbue; j++) {
					if (lesUE[j].getCodeUE().equals(codeUE)) {
						lesEtudiants[i].ajouterUE(lesUE[j]);
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void listeEtudiants() {

		for (int i = 0; i < this.nbetudiant; i++) {
			lesEtudiants[i].afficher();
		}
	}

	@Override
	public void consulterEtudiant(int et) {

		int i = 0;
		for (i = 0; i < this.nbetudiant; i++) {
			if (lesEtudiants[i].getEt() == et) {
				lesEtudiants[i].afficher();
				break;
			}
			i++;
		}
		if (i > this.nbetudiant)
			System.out.println("Etudiant inconnu");
	}

	@Override
	public void ajouterEtudiant(int et, String nom, String prenom, String adresse, String tel, String email) {

		lesEtudiants[nbetudiant] = new Etudiant(nom, prenom, adresse, tel, email, et);
		nbetudiant++;
		System.out.println("Etudiant ajouté correctement");
	}

	@Override
	public void ajouterEtudiant(int et, String nom) {

		lesEtudiants[nbetudiant] = new Etudiant(nom, et);
		nbetudiant++;
		System.out.println("Etudiant ajouté correctement");
	}

	@Override
	public void modifierEtudiant(int et, String nom, String prenom, String adresse, String tel, String email) {
		boolean estModifier = false;
		for (int i = 0; i < this.nbetudiant; i++) {
			if (lesEtudiants[i].getEt() == et) {
				lesEtudiants[i].setNom(nom);
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

		for (int i = 0; i < this.nbue; i++) {
			lesUE[i].afficher();
		}
	}

	@Override
	public void listeEnseignant() {

		for (int i = 0; i < this.nbenseignant; i++) {
			lesEnseignants[i].afficher();
		}
	}

	@Override
	public void affecterEnseignant(String codeUE, String nom) {
		boolean bienAffecter = false;
		Enseignant enseignant = this.recherchePersonneParNom(nom);
		for (int i = 0; i < this.nbue; i++) {
			if (lesUE[i].getCodeUE().equals(codeUE) && enseignant  != null) {
				lesUE[i].setEnseignant(enseignant.getNom());
				enseignant.setNbSeance(enseignant.getNbSeance() + lesUE[i].getnombreTutorat());
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
	 * @param nom : nom de l'enseignant à trouver
	 * @return l'instance de l'enseignant trouver ou null
	 */
	private Enseignant recherchePersonneParNom(String nom) {
		Enseignant rtr = null;
		for (int i = 0; i < this.nbenseignant; i++) {
			if (lesEnseignants[i].getNom().equals(nom))
				return lesEnseignants[i];
		}
		return rtr;
	}
}

