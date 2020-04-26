package nfa035.td.td5;


import nfa032.td.Terminal;
import nfa035.td.td4.exo1.MenuAffectationEnseignant;
import nfa035.td.td4.exo1.MenuEtudiants;
import nfa035.td.td4.exo1.MenuInscription;
import nfa035.td.td4.exo1.MenuinscriptionEnseignant;
import nfa035.td.td4.exo1.MenuinscriptionUE;

public class ProgrammeB {

	private static void menu11(MenuEtudiants centre) {
		boolean continuer = true;
		int et;
		String nom, prenom, email, adresse, tel;

		while (continuer == true) {
			// afficher la liste des étudiants
			centre.listeEtudiants();

			Terminal.ecrireStringln("---------------------------------");
			Terminal.ecrireStringln("(0) Retour");
			Terminal.ecrireStringln("(1) consulter un auditeur");
			Terminal.ecrireStringln("(2) ajouter un auditeur");
			Terminal.ecrireStringln("(3) modifier un auditeur");
			int rep = Terminal.lireInt();
			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1: // afficher la fiche de l'étudiant saisi
				Terminal.ecrireStringln("veuillez saisir un numero détudiant");
				et = Terminal.lireInt();
				centre.consulterEtudiant(et);
				Terminal.ecrireStringln("---------------------------------");
				break;
			case 2: // ajouter un étudiant
				Terminal.ecrireStringln("veuillez saisir un numero détudiant");
				et = Terminal.lireInt();
				Terminal.ecrireStringln("veuillez saisir un nom détudiant");
				nom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un prénom détudiant");
				prenom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un email détudiant");
				email = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir une adresse détudiant");
				adresse = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un téléphone détudiant");
				tel = Terminal.lireString();
				centre.ajouterEtudiant(et, nom, prenom, adresse, tel, email);
				Terminal.ecrireStringln("---------------------------------");
				break;
			case 3: // modifier un étudiant
				Terminal.ecrireStringln("veuillez saisir un numero détudiant");
				et = Terminal.lireInt();
				Terminal.ecrireStringln("veuillez saisir un nom détudiant");
				nom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un prénom détudiant");
				prenom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un email détudiant");
				email = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir une adresse détudiant");
				adresse = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un téléphone détudiant");
				tel = Terminal.lireString();
				centre.modifierEtudiant(et, nom, prenom, adresse, tel, email);
				Terminal.ecrireStringln("---------------------------------");
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}
	}

	private static void menu12(MenuInscription centre) {
		

		// afficher la liste des UE
		centre.listeUE();

		// afficher la liste des étudiants et de leur UE
		centre.afficherUEEtudiant();

		// ajouter une UE proposée par le centre à un auditeur
		Terminal.ecrireStringln("veuillez saisir un numero détudiant");
		int et = Terminal.lireInt();
		Terminal.ecrireStringln("veuillez saisir un codeUE");
		String codeUE = Terminal.lireString();

		centre.ajouterUEEtudiant(et, codeUE);
	}

	/**
	 * affichage du menu de gestion des inscriptions des auditeurs à une UE.
	 */
	private static void menu1(CentreReimsB c) {
		boolean continuer = true;
		while (continuer == true) {
			Terminal.ecrireStringln("(0) Retour");
			Terminal.ecrireStringln("(1.1) gestion des auditeurs");
			Terminal.ecrireStringln("(1.2) gestion des inscriptions");
			int rep = Terminal.lireInt();
			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1:
				menu11(c);
				break;
			case 2:
				menu12(c);
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}

	}

	private static void menu21(MenuinscriptionUE centre) {
		boolean continuer = true;
		String codeUE = null, intituleUE = null;

		while (continuer == true) {
			centre.listeUE();
			Terminal.ecrireStringln("(0) Sortie");
			Terminal.ecrireStringln("(1) inscrire une UE en présentiel");
			Terminal.ecrireStringln("(2) inscrire une UE à distance 4ECTS");
			Terminal.ecrireStringln("(3) inscrire une UE à distance 6ECTS");
			int rep = Terminal.lireInt();
			if (rep >= 1 && rep <= 3) {
				Terminal.ecrireStringln("veuillez saisir un code pour l'UE");
				codeUE = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un intitule pour l'UE");
				intituleUE = Terminal.lireString();
			}

			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1: // ajouter une ue en présentiel en précisant son code et son intitulé
				centre.ajouterUEPresentiel(codeUE, intituleUE, "NC");
				break;
			case 2: // ajouter une ue 4ECTS en précisant son code et son intitulé
				centre.ajouterUEDistance4(codeUE, intituleUE, "NC");
				break;
			case 3: // ajouter une ue 6ECTS en précisant son code et son intitulé
				centre.ajouterUEDistance5(codeUE, intituleUE, "NC");
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}
	}

	private static void menu22(MenuinscriptionEnseignant centre) {

		boolean continuer = true;
		String nom, prenom, email, adresse, tel;

		while (continuer == true) {
			// afficher la liste des UE
			centre.listeUE();

			// afficher la liste des enseignants
			centre.listeEnseignant();
			Terminal.ecrireStringln("---------------------------------");
			Terminal.ecrireStringln("(0) Retour");
			Terminal.ecrireStringln("(1) consulter un enseignant");
			Terminal.ecrireStringln("(2) ajouter un enseignant");
			Terminal.ecrireStringln("(3) modifier un enseignant");
			int rep = Terminal.lireInt();

			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1: // afficher la fiche de l'enseignant saisi :nom, prénom, mail et adresse, ainsi
					// que la liste des UE qu'il encadre
				Terminal.ecrireStringln("veuillez saisir un nom d'enseignant");
				nom = Terminal.lireString();
				centre.consulterEnseignant(nom);
				centre.listeUEEnseignant(nom);
				break;
			case 2: // ajouter un enseignant en saisissant :nom, prénom, mail et adresse
				Terminal.ecrireStringln("veuillez saisir un nom d'enseignant");
				nom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un mail pour l'enseignant");
				email = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un prénom pour l'enseignant");
				prenom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir une adresse pour l'enseignant");
				adresse = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un tel pour l'enseignant");
				tel = Terminal.lireString();
				centre.ajouterEnseignant(nom, prenom, adresse, tel, email);
				break;
			case 3: // modifier un enseignant
				Terminal.ecrireStringln("veuillez saisir un nom d'enseignant");
				nom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un mail pour l'enseignant");
				email = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un prénom pour l'enseignant");
				prenom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir une adresse pour l'enseignant");
				adresse = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un tel pour l'enseignant");
				tel = Terminal.lireString();
				centre.modifierEnseignant(nom, prenom, adresse, tel, email);
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}

	}

	private static void menu23(MenuAffectationEnseignant centre) {
		boolean continuer = true;
		String nom, codeUE;
		while (continuer == true) {
			// afficher la liste des UE
			centre.listeUE();

			// afficher la liste des enseignants
			centre.listeEnseignant();

			Terminal.ecrireStringln("---------------------------------");
			Terminal.ecrireStringln("(0) Retour");
			Terminal.ecrireStringln("(1) affecter une UE à un esneignant");

			int rep = Terminal.lireInt();

			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1: // affecter une UE à un enseignant
				Terminal.ecrireStringln("veuillez saisir un nom d'enseignant");
				nom = Terminal.lireString();
				Terminal.ecrireStringln("veuillez saisir un code UE");
				codeUE = Terminal.lireString();
				centre.affecterEnseignant(codeUE, nom);
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}
	}

	/**
	 * affichage du menu de gestion des affectations des enseignants à une UE.
	 */
	private static void menu2(CentreReimsB c) {
		boolean continuer = true;
		while (continuer == true) {
			Terminal.ecrireStringln("(0) Sortie");
			Terminal.ecrireStringln("(1) gestion des UE");
			Terminal.ecrireStringln("(2) gestion des enseignants");
			Terminal.ecrireStringln("(3) gestion des affectations ");
			int rep = Terminal.lireInt();
			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1:
				menu21(c);
				break;
			case 2:
				menu22(c);
				break;
			case 3:
				menu23(c);
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}
	}

	public static void main(String[] args) {
		boolean continuer = true;
		CentreReimsB c = new CentreReimsB();

		c.ajouterEtudiant(15, "estelle");
		c.ajouterEtudiant(23, "pierre");
		c.ajouterEnseignant("gougelet", "a@b.fr");
		c.ajouterEnseignant("moreau", "a@b.fr");
		c.ajouterUEPresentiel("NFA010", "?", "moreau");
		c.ajouterUEDistance4("NFA035", "programmation", "gougelet");
		c.ajouterUEDistance5("NFA008", "base de données", "gougelet");

		while (continuer == true) {
			Terminal.ecrireStringln("(0) Sortie");
			Terminal.ecrireStringln("(1) inscription des auditeurs");
			Terminal.ecrireStringln("(2) gestion des enseignements");
			int rep = Terminal.lireInt();
			switch (rep) {
			case 0:
				continuer = false;
				break;
			case 1:
				menu1(c);
				break;
			case 2:
				menu2(c);
				break;
			default:
				Terminal.ecrireStringln("Erreur de choix");

			}
		}

	}

}


