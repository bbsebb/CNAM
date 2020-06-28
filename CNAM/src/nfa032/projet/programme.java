package nfa032.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import nfa032.projet.image.Images;
import nfa032.projet.image.MenuChargementImg;
import nfa032.projet.image.MenuChoixImg;
import nfa032.projet.image.MenuModificationImg;

public class programme {
	static Scanner sc = new Scanner(System.in);
	static String path = "src/nfa032/projet/img";
	static int maxImg = 10;

	public static void main(String[] args) {

		Images imgs = new Images(maxImg);
		menu(imgs);

	}

	static public void menu(Images imgs) {
		boolean menu = true;
		while (menu) {

			if (!imgs.estVide()) {
				System.out.println("*****************************");
				System.out.println("1 - Charger une nouvelle image dans le programme");
				System.out.println("2 - Modifier Image");
				System.out.println("3 - Enregistrer Image");
				System.out.println("4 - Voir le detaille des images chargées");
			} else {
				System.out.println("1 - Charger une image dans le programme");
			}
			System.out.println("5 - Quitter");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			if (imgs.estVide() && (r == 2 || r == 3)) {
				r = -1; // Aller à "default"
			}
			switch (r) {
			case 1:
				menu1(imgs);
				break;
			case 2:
				menuChoixImg(imgs, false);
				menu2(imgs);
				break;
			case 3:
				menuChoixImg(imgs, false);
				menu3(imgs);
				break;
			case 4:
				imgs.affichageDetailsListeImgs();
				break;
			case 5:
				menu = false;
				break;
			default:
				if (imgs.estVide())
					System.err.println("Entrer un chiffre 1 ou 5");
				else
					System.err.println("Entrer un chiffre entre 1 et 5");

			}
		}
	}

	static public void menu1(MenuChargementImg imgs) {
		boolean menu1 = true;
		while (menu1) {
			System.out.println("*****************************");
			if (imgs.estVide())
				System.out.println("1 - Charger une image");
			else
				System.out.println("1 - Charger une nouvelle image");
			System.out.println("2 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			if (r == 1) {
				System.out.println("*****************************");
				File[] listing;
				try {
					File f = new File(path);
					listing = f.listFiles();

					for (int i = 0; i < listing.length; i++) {
						if (!listing[i].isDirectory()) {
							System.out.println("\t\t " + (i + 1) + " " + listing[i]);
						}
					}

					System.out.println("Entrer le numéro de l'image");
					int r2 = sc.nextInt();
					if (r2 < 1 || r2 > listing.length)
						throw new IllegalArgumentException(String.valueOf(listing.length));
					String source = listing[r2 - 1].getPath();
					Path chemin = Paths.get(source);
					BufferedReader lecteur = null;
					lecteur = Files.newBufferedReader(chemin, StandardCharsets.US_ASCII);
					imgs.ajoutImg(lecteur, source, listing[r2 - 1].getName());
					lecteur.close();
					System.out.println("Image chargée");
				} catch (InputMismatchException e) {
					System.err.println("Veuillez entrer un chiffre");
					r = 1;
					sc.nextLine();
					menu1 = true;
				} catch (IllegalArgumentException e) {
					System.err.println("Veuillez entrer un chiffre entre 1 et " + e.getMessage());
					menu1 = true;
				} catch (IOException e) {
					System.err.println("Erreur dans le chargement de l'image, Verifier si le chemin est correcte");

					menu1 = true;
				} catch (Exception e) {
					System.err.println(
							"Erreur inconnu ou mauvais format de fichier ppm : \n 1 ligne : nom \n 2e ligne : description \n 3e ligne : taille \n 4e ligne : Max RGB \n 5e ligne et ensuite : pixel");

					menu1 = true;
				}

			} else if (r == 2)
				menu1 = false;
			else {
				System.err.println("Entrer un chiffre 1 ou 2");
			}

		}
	}

	static public void menu2(MenuModificationImg imgs) {
		boolean menu2 = true;
		while (menu2) {
			System.out.println("*****************************");
			System.out.println("1 - Foncer l'image");
			System.out.println("2 - Eclairecir l'image");
			System.out.println("3 - Mettre l'image en NB");
			System.out.println("4 - Recadrer l'image");
			System.out.println("5 - Mettre en négatif");
			System.out.println("6 - Redimensionner l'image");
			System.out.println("7 - Inscruster un rectangle dans l'image");
			System.out.println("8 - Inscruster une image dans l'image \n Choisir le fond :");
			System.out.println("9 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			switch (r) {
			case 1:

				menu21(imgs);
				break;
			case 2:

				menu22(imgs);
				break;
			case 3:

				imgs.mettreEnNBFocus();
				System.out.println("L'image a été changer en Noir & Blanc");
				break;
			case 4:
				int l1, l2, c1, c2;
				l1 = l2 = c1 = c2 = -1;
				System.out.println("*****************************");
				System.out.println("L'image fait :" + imgs.getLargeurFocus() + " pixels de largeur et "
						+ imgs.getHauteurFocus() + " pixels de hauteur");
				System.out.println("*****************************");
				try {
					System.out.println("Choississez la première ligne des pixels");
					l1 = sc.nextInt();
					System.out.println("Choississez la première colonne des pixels");
					c1 = sc.nextInt();
					System.out.println("Choississez la dernière ligne des pixels");
					l2 = sc.nextInt();
					System.out.println("Choississez la dernière colonne des pixels");
					c2 = sc.nextInt();
				} catch (InputMismatchException e) {
					System.err.println("Vous avez entré des points incorrectes");
				}
				if (l1 < l2 && l2 <= imgs.getLargeurFocus() && c1 < c2 && c2 <= imgs.getHauteurFocus() && l1 >= 0
						&& c1 >= 0) {
					imgs.recadrerFocus(l1, l2, c1, c2);
					System.out.println("l'image a été recadré");
				} else {
					System.err.println("Vous avez entré des points incorrectes");
				}

				break;
			case 5:
				imgs.mettreNegatifFocus();
				System.out.println("L'image a été changer en Noir & Blanc");
				break;
			case 6:
				menu26(imgs);
				break;
			case 7:
				menu27(imgs);
				break;
			case 8:
				menu28(imgs);
				break;
			case 9:
				menu2 = false;
				break;
			default:
				System.err.println("Entrer un chiffre entre 1 et 9");
			}
		}
	}

	static public void menu3(Images imgs) {
		boolean menu3 = true;
		while (menu3) {
			System.out.println("*****************************");
			System.out.println("1 - Enregistrer sous");
			System.out.println("2 - Enregistrer (supprimera l'image d'origine)");
			System.out.println("3 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			switch (r) {
			case 1:

				System.out.println("Entrer le chemin du dossier où enregistrer l'image");
				sc.nextLine();
				String str = sc.nextLine();
				Path chemin = Paths.get(str);
				BufferedWriter redacteur;
				try {
					redacteur = Files.newBufferedWriter(chemin, StandardCharsets.US_ASCII);
					imgs.enregistrerImgFocus(redacteur);
					redacteur.close();
					System.out.println("Image enregistrée");
				} catch (IOException e) {
					System.err.println("L'image n'a pas pu être enregistrée, verifier le chemin");
				}
				break;
			case 2:

				Path chemin1 = Paths.get(imgs.getSourceFocus());
				BufferedWriter redacteur1;
				try {
					redacteur1 = Files.newBufferedWriter(chemin1, StandardCharsets.US_ASCII);
					imgs.enregistrerImgFocus(redacteur1);
					redacteur1.close();
					System.out.println("Image enregistrée");
				} catch (IOException e) {
					System.err.println("L'image n'a pas pu être ecrasée, elle est peut être protégée");
				}
				break;
			case 3:
				menu3 = false;
				break;
			default:
				System.err.println("Entrer un chiffre entre 1 et 2");
			}
		}
	}

	static public void menu21(MenuModificationImg imgs) {
		boolean menu21 = true;
		while (menu21) {
			System.out.println("*****************************");
			System.out.println("Menu pour foncer une image.");
			System.out.println("Choississez la couleur que vous souhaitez foncer (+20%)");
			System.out.println("Vous pouvez foncer plusières fois l'image");
			System.out.println("1 - Foncer vers le rouge");
			System.out.println("2 - Foncer vers le vert");
			System.out.println("3 - Foncer vers le bleu");
			System.out.println("4 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			switch (r) {
			case 1:
				imgs.foncerImgFocus("rouge");
				System.out.println("L'image a été foncé vers le rouge");
				break;
			case 2:
				imgs.foncerImgFocus("vert");
				System.out.println("L'image a été foncé vers le vert");
				break;
			case 3:
				imgs.foncerImgFocus("bleu");
				System.out.println("L'image a été foncé vers le bleu");
				break;
			case 4:
				menu21 = false;
				break;
			default:
				System.err.println("Entrer un chiffre entre 1 et 3");
			}
		}

	}

	static public void menu22(MenuModificationImg imgs) {
		boolean menu22 = true;
		while (menu22) {
			System.out.println("*****************************");
			System.out.println("Menu pour eclairecir une image.");
			System.out.println("Choississez la couleur que vous souhaitez eclairecir (+20%)");
			System.out.println("Vous pouvez eclairecir plusières fois l'image");
			System.out.println("1 - eclairecir vers le rouge");
			System.out.println("2 - eclairecir vers le vert");
			System.out.println("3 - eclairecir vers le bleu");
			System.out.println("4 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r = -1;
				sc.nextLine();

			}
			switch (r) {
			case 1:
				imgs.eclairecirImgFocus("rouge");
				System.out.println("L'image a été eclairci vers le rouge");
				break;
			case 2:
				imgs.eclairecirImgFocus("vert");
				System.out.println("L'image a été eclairci vers le vert");
				break;
			case 3:
				imgs.eclairecirImgFocus("bleu");
				System.out.println("L'image a été eclairci vers le bleu");
				break;
			case 4:
				menu22 = false;
				break;
			default:
				System.err.println("Entrer un chiffre entre 1 et 4");
			}
		}
	}

	static public void menu26(MenuModificationImg imgs) {
		boolean menu26 = true;
		while (menu26) {
			System.out.println("*****************************");
			System.out.println("Menu pour modifier la taille de l'image.");
			System.out.println("La taille de l'image est " + imgs.getLargeurFocus() + "x" + imgs.getHauteurFocus());
			System.out.println("Entrer la nouvelle largeur");
			int l;
			try {
				l = sc.nextInt();
			} catch (InputMismatchException e) {
				menu26 = true;
				sc.nextLine();
				System.err.println("Erreur de saisis");
				continue;
			}
			System.out.println("Entrer la nouvelle hauteur : ");
			int h;
			try {
				h = sc.nextInt();
			} catch (InputMismatchException e) {
				menu26 = true;
				sc.nextLine();
				System.err.println("Erreur de saisis");
				continue;

			}

			try {
				imgs.modifierLargeurFocus(l);
				imgs.modifierHauteurFocus(h);
				menu26 = false;
			} catch (IllegalArgumentException e) {
				System.err.println("Erreur de saisis :" + e.getMessage());
				menu26 = true;
			}
		}
	}

	static public void menu27(MenuModificationImg imgs) {
		boolean menu27 = true;
		while (menu27) {
			int coinSupGaucheX = 0;
			int coinSupGaucheY = 0;
			int largeur = 0;
			int hauteur = 0;
			String couleur = null;
			System.out.println("*****************************");
			System.out.println("Menu pour incruster un rectangle.");
			System.out.println("Choisir la couleur du rectangle");
			System.out.println("1 - Rouge");
			System.out.println("2 - Vert");
			System.out.println("3 - Bleu");
			int numCouleur;
			try {
				numCouleur = sc.nextInt();
				switch (numCouleur) {
				case 1:
					couleur = "rouge";
					break;
				case 2:
					couleur = "vert";
					break;
				case 3:
					couleur = "bleu";
					break;
				default:
					throw new IllegalArgumentException();
				}
			} catch (InputMismatchException | IllegalArgumentException e) {
				numCouleur = -1;
				sc.nextLine();
				System.err.println("Erreur de saisi des couleurs, veuillez réessayer");
				continue;
			}
			System.out.println("Choisir la coordonnée X ou l'inscruster entre 1 et " + imgs.getLargeurFocus());
			try {
				coinSupGaucheX = sc.nextInt();
			} catch (InputMismatchException e) {
				menu27 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			System.out.println("Choisir la coordonnée Y ou l'inscruster entre 1 et " + imgs.getHauteurFocus());
			try {
				coinSupGaucheY = sc.nextInt();
			} catch (InputMismatchException e) {
				menu27 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			System.out.println(
					"Choisir la largeur ou l'inscruster entre 1 et " + (imgs.getLargeurFocus() - coinSupGaucheX + 1));
			try {
				largeur = sc.nextInt();
			} catch (InputMismatchException e) {
				menu27 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			System.out.println(
					"Choisir la largeur ou l'inscruster entre 1 et " + (imgs.getHauteurFocus() - coinSupGaucheY + 1));
			try {
				hauteur = sc.nextInt();
			} catch (InputMismatchException e) {
				menu27 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			try {
				imgs.inscrusterRectangleFocus(coinSupGaucheX, coinSupGaucheY, largeur, hauteur, couleur);
			} catch (IllegalArgumentException e) {
				menu27 = true;
				System.err.println("Erreur de saisis");
				continue;
			}
			menu27 = false;
		}
	}

	static public void menu28(MenuModificationImg imgs) {
		boolean menu28 = true;
		while (menu28) {
			int coinSupGaucheX = 0;
			int coinSupGaucheY = 0;
			System.out.println("*****************************");
			System.out.println("Menu pour incruster une image dans un fond.");
			menuChoixImg((Images) imgs, true);
			System.out.println("Choisir la coordonnée X ou l'inscruster entre 1 et " + imgs.getLargeurFocus() + " \n attention, l'image ne doit pas dépasser du fond");
			try {
				coinSupGaucheX = sc.nextInt();
			} catch (InputMismatchException e) {
				menu28 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			System.out.println("Choisir la coordonnée Y ou l'inscruster entre 1 et " + imgs.getHauteurFocus() + " \n attention, l'image ne doit pas dépasser du fond");
			try {
				coinSupGaucheY = sc.nextInt();
			} catch (InputMismatchException e) {
				menu28 = true;
				sc.nextLine();
				System.err.println("Veuillez entrer uniquement des nombres");
				continue;
			}
			try {
			imgs.incrusterImgFocus(coinSupGaucheX, coinSupGaucheY); } catch (IllegalArgumentException | NullPointerException e) {
				System.err.println(e.getMessage());
				menu28 = true;
				continue;
			}

			menu28 = false;
		}
	}

	static public void menuChoixImg(MenuChoixImg imgs, boolean multi) {
		boolean menuChoixImg = true;
		while (menuChoixImg) {
			System.out.println("*****************************");
			if (multi)
				System.out.println(
						"Choisir l'image à inscruster /n *Elle doit être de taille inferieure ou égale à l'image de fond \n0 - Revenir au menu principal");
			else
				System.out.println("Choississez l'image chargée où faire votre action");
			imgs.affichageListeImgs();
			int r;
			try {
				r = sc.nextInt();
				if (multi)
					if(r == 0) 
						menu((Images) imgs);
					else
					imgs.setSecondImg(r - 1);
				else
					imgs.setIdImgFocus(r - 1);
				menuChoixImg = false;
			} catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
				System.err.println("Choix d'image invalide");
				menuChoixImg = true;
			}
		}
	}

}
