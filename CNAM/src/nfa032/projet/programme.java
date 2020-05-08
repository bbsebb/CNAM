package nfa032.projet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class programme {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Image img = new Image();
		menu(img);

	}

	/**
	 * Non utilisé
	 * @param path
	 * @throws IOException
	 */
	static public void afficherListFichier(String path) throws IOException {
		Path chemin = Paths.get(path);
		DirectoryStream<Path> listing = Files.newDirectoryStream(chemin);

		for (Path nom : listing) {
			System.out.println("\t\t" + ((Files.isDirectory(nom)) ? nom + "/" : nom));

		}
	}

	static public void menu(Image img) {
		boolean menu = true;
		while (menu) {
			if (!img.estVide()) {
				System.out.println("*****************************");
				System.out.println("1 - Charger une nouvelle image dans le programme");
				System.out.println("2 - Modifier Image");
				System.out.println("3 - Enregistrer Image");
			} else {
				System.out.println("1 - Charger une image dans le programme");
			}
			System.out.println("4 - Quitter");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r=-1;
				sc.nextLine();
				
			}
			if (img.estVide() && (r == 2 || r == 3)) {
				r = -1; // Aller à "default"
			}
			switch (r) {
			case 1:
				menu1(img);
				break;
			case 2:
				menu2(img);
				break;
			case 3:
				menu3(img);
				break;
			case 4:
				menu = false;
				break;
			default:
				if (img.estVide())
					System.err.println("Entrer un chiffre 1 ou 4");
				else
					System.err.println("Entrer un chiffre entre 1 et 4");

			}
		}
	}

	static public void menu1(Image img) {
		boolean menu1 = true;
		while (menu1) {
			System.out.println("*****************************");
			if (img.estVide())
				System.out.println("1 - Charger une image");
			else
				System.out.println("1 - Charger une nouvelle image");
			System.out.println("2 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r=-1;
				sc.nextLine();
				
			}
			if (r == 1) {
				System.out.println("*****************************");
				System.out.println("Entrer le chemin de l'image");
				sc.nextLine();
				String str = sc.nextLine();
				Path chemin = Paths.get(str);
				BufferedReader lecteur = null;
				try {
					lecteur = Files.newBufferedReader(chemin, StandardCharsets.US_ASCII);
					img.chargerImg(lecteur, str);
					lecteur.close();
					System.out.println("Image chargée");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Erreur dans le chargement de l'image, Verifier si le chemin est correcte");

					menu1 = true;
				}
			} else if (r == 2)
				menu1 = false;
			else {
				System.err.println("Entrer un chiffre 1 ou 2");
			}

		}
	}

	static public void menu2(Image img) {
		boolean menu2 = true;
		while (menu2) {
			System.out.println("*****************************");
			System.out.println("1 - Foncer l'image");
			System.out.println("2 - Eclairecir l'image");
			System.out.println("3 - Mettre l'image en NB");
			System.out.println("4 - Recadrer l'image");
			System.out.println("5 - Mettre en négatif");
			System.out.println("6 - Retour");
			int r;
			try {
				r = sc.nextInt();
			} catch (InputMismatchException e) {
				r=-1;
				sc.nextLine();
				
			}
			switch (r) {
			case 1:
				menu21(img);
				break;
			case 2:
				menu22(img);
				break;
			case 3:
				img.mettreEnNB();
				System.out.println("L'image a été changer en Noir & Blanc");
				break;
			case 4:
				int l1, l2, c1, c2;
				l1 = l2 = c1 = c2 = -1;
				System.out.println("*****************************");
				System.out.println("L'image fait :" + img.getLargeur() + " pixels de largeur et " + img.getHauteur()
						+ " pixels de hauteur");
				System.out.println("*****************************");
				try {
				System.out.println("Choississez la première ligne des pixels");
				l1 = sc.nextInt();
				System.out.println("Choississez la première colonne des pixels");
				c1 = sc.nextInt();
				System.out.println("Choississez la dernière ligne des pixels");
				l2 = sc.nextInt();
				System.out.println("Choississez la dernière colonne des pixels");
				c2 = sc.nextInt(); } catch (InputMismatchException e) {
					System.err.println("Vous avez entré des points incorrectes");
				}
				if (l1 < l2 && l2 <= img.getLargeur() && c1 < c2 && c2 <= img.getHauteur() && l1>=0 && c1>=0) {
					img.recadrer(l1, l2, c1, c2);
					System.out.println("l'image a été recadré");
				} else {
					System.err.println("Vous avez entré des points incorrectes");
				}

				break;
			case 5:
				img.mettreNegatif();
				System.out.println("L'image a été changer en Noir & Blanc");
				break;
			case 6:
				menu2 = false;
				break;
			default:
				System.err.println("Entrer un chiffre entre 1 et 6");
			}
		}
	}

	static public void menu3(Image img) {
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
				r=-1;
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
					img.enregistrerImg(redacteur);
					redacteur.close();
					System.out.println("Image enregistrée");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("L'image n'a pas pu être enregistrée, verifier le chemin");
				}
				break;
			case 2:

				Path chemin1 = Paths.get(img.getSource());
				BufferedWriter redacteur1;
				try {
					redacteur1 = Files.newBufferedWriter(chemin1, StandardCharsets.US_ASCII);
					img.enregistrerImg(redacteur1);
					redacteur1.close();
					System.out.println("Image enregistrée");
				} catch (IOException e) {
					// TODO Auto-generated catch block
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

	static public void menu21(Image img) {
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
				r=-1;
				sc.nextLine();
				
			}
			switch (r) {
			case 1:
				img.foncerImg("rouge");
				System.out.println("L'image a été foncé vers le rouge");
				break;
			case 2:
				img.foncerImg("vert");
				System.out.println("L'image a été foncé vers le vert");
				break;
			case 3:
				img.foncerImg("bleu");
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

	static public void menu22(Image img) {
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
			int r = sc.nextInt();
			switch (r) {
			case 1:
				img.eclairecirImg("rouge");
				System.out.println("L'image a été eclairci vers le rouge");
				break;
			case 2:
				img.eclairecirImg("vert");
				System.out.println("L'image a été eclairci vers le vert");
				break;
			case 3:
				img.eclairecirImg("bleu");
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

}
