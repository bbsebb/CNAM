package nfa035.projet2.feuille;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.cellule.Erreur;
import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.CircuitException;
import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;
/**
 * <b>Cette classe repr�sente une feuille d'un tableur.</b> 
 * <p>La classe va utiliser la classe {@link AnalyseFormule AnalyseFormule} pour verifier et transformer les {@link Cellule Cellule} qui composent cette feuille.</p>
 * <p> Elle permet de  : </p>
 * <ul>
 * <li>Enregistrer la feuille</li>
 * <li>Ouvrir un feuille</li>
 * <li>Modifier une cellule</li>
 * <li>Afficher le resultat d'une cellule</li>
 * <li>Afficher la formule d'une cellule</li>
 * <li>Cr�er un bloc de cellules</li>
 * </ul>
 * <p> Les cellules sont class�es par des coordonn�e x et y en commen�ant � 0.</p>
 * <p> Pour voir les formules autoris�es, voir : {@link AnalyseFormule AnalyseFormule}</p>
 * @see AnalyseFormule
 * @see Cellule
 * @see Bloc
 * @author Seb
 *
 */
public class Feuille {
	/**
	 * La listes des cellules qui sont caract�ris�es (et compar�es) par leurs coordonn�es 
	 */
	protected TreeSet<Cellule> cellules;
	/**
	 * La ligne maximal; de 0 � xMax
	 */
	protected int xMax;
	/**
	 * La colonne maximal; de 0 � yMax
	 */
	protected int yMax;
	
	/**
	 * Constructeur par defaut
	 */
	protected Feuille() {}

	/**
	 * Ce constructeur cr�e une feuille avec un nombre de ligne et de colonne indiqu�s en param�tre
	 * @param nbrLigne est le nombre de ligne de la feuille cr�e. Le nombre de ligne doit �tre sup�rieur � 1.
	 * @param nbrColonne est le nombre de colonne de la feuille cr�e. Le nombre de colonne doit �tre sup�rieur � 1.
	 * @throws HorsFeuilleException si un nombre de ligne ou de colonne est n�gatif ou �gal � z�ro.
	 */
	public Feuille(int nbrLigne, int nbrColonne) throws HorsFeuilleException  {
		this.setCellules(this.creeFeuille(0, 0, nbrLigne - 1, nbrColonne - 1));
		this.setxMax(nbrLigne - 1);
		this.setyMax(nbrColonne - 1);
	}
	
	
	private TreeSet<Cellule> creeFeuille(int xCellule1, int yCellule1, int xCellule2, int yCellule2)
			throws HorsFeuilleException {
		if (xCellule1 < 0 || xCellule2 < 0 || yCellule1 < 0 || yCellule2 < 0) // Renvoie une exception si des coordonn�es sont n�gatives
			throw new HorsFeuilleException();
		this.setCellules(new TreeSet<Cellule>());
		for (int i = xCellule1; i <= xCellule2; i++) { 
			for (int j = yCellule1; j <= yCellule2; j++) {
				this.getCellules().add(new Cellule(i, j));
			}
		}
		return cellules;
	}
	
	/**
	 * @return la liste de cellule de la feuille cellules
	 */
	public Set<Cellule> getCellules() {
		return cellules;
	}

	/**
	 * @param cellules les cellules  � modifier
	 */
	protected void setCellules(TreeSet<Cellule> cellules) {
		this.cellules = cellules;
	}

	/**
	 * @return xMax la ligne maximal
	 */
	protected int getxMax() {
		return xMax;
	}

	/**
	 * @param xMax est la ligne maximal � modifier
	 */
	private void setxMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMax la colonne maximal
	 */
	protected int getyMax() {
		return yMax;
	}

	/**
	 * @param yMax est la colonne maximal � modifier
	 */
	private void setyMax(int yMax) {
		this.yMax = yMax;
	}

	/**
	 * Modifie une cellule avec une formule
	 * @param x est la premi�re coordonn�e de la cellule
	 * @param y est la deuxi�me coordonn�e de la cellule
	 * @param formule est la formule � modifier dans la cellule
	 * @throws HorsFeuilleException si les coordonn�es ne correspondent � aucune cellule
	 */
	public void setCellule(int x, int y, String formule) throws HorsFeuilleException {
		Cellule c = this.getCellule(x, y);
		try {
			AnalyseFormule af = new AnalyseFormule(this, formule); // AnalyseFormule permet de v�rifier et transformer la formule en contenu pour une cellule
			c.setFormule(formule);
			c.setContenu(af.getContenu()); 
			c.setCellulesLie(af.getCellulesLie()); // On ajoute la liste des cellules dont d�pendent la cellule modifi�e
		} catch (HorsFeuilleException | FormuleErroneeException | CircuitException | CelluleVideException e) {
			// Dans le cas ou la formule est erron�e, on cr�e un contenu sp�cifique
			c.setFormule(formule);
			c.setContenu((Contenu) new Erreur(e.getMessage()));
			c.clearCellulesLie();
		}
	}

	/**
	 * Renvoie la cellule correspondant au coordonn�e en param�tre
	 * @param x est la premi�re coordonn�e de la cellule
	 * @param y est la deuxi�me coordonn�e de la cellule
	 * @return la cellule 
	 * @throws HorsFeuilleException si les coordonn�es ne correspondent � aucune cellule
	 */
	public Cellule getCellule(int x, int y) throws HorsFeuilleException {
		Iterator<Cellule> it = this.getCellules().iterator();
		while (it.hasNext()) {
			Cellule c = it.next();
			if (c.getX() == x && c.getY() == y) {
				return c;
			}
		}
		throw new HorsFeuilleException();
	}

	/**
	 * Verifie si la cellule est vide
	 * @param x est la premi�re coordonn�e de la cellule
	 * @param y est la deuxi�me coordonn�e de la cellule
	 * @return vrai si la cellule est vide, faux sinon
	 * @throws HorsFeuilleException si les coordonn�es ne correspondent � aucune cellule
	 */
	boolean estCelluleVide(int x, int y) throws HorsFeuilleException {
		if (this.getCellule(x, y).estVide())
			return true;
		else
			return false;
	}


	/**
	 * Cr�e un bloc qui est une sous-feuille de la classe � partir de deux cellules. Une modification du bloc modifiera la feuille associ�e et vice versa. 
	 * @param c1 est la cellule du coin haut gauche du bloc
	 * @param c2 est la cellule du coin bas droit du bloc
	 * @return un bloc
	 * @throws HorsFeuilleException si les coordonn�es ne correspondent � aucune cellule
	 */
	public Bloc creeBloc(Cellule c1, Cellule c2) throws HorsFeuilleException {
		if (this.getCellules().contains(c1) && this.getCellules().contains(c2))
			return creeBloc(c1.getX(), c1.getY(), c2.getX(), c2.getY());
		else
			throw new HorsFeuilleException();
	}

	/**
	 * Cr�e un bloc qui est une sous-feuille de la classe � partir de coordonn�e de cellule. Une modification du bloc modifiera la feuille associ�e et vice versa.
	 * @param xCellule1 est la premi�re coordonn�e de la cellule du coin haut gauche du bloc
	 * @param yCellule1 est la deuxi�me coordonn�e de la cellule du coin haut gauche du bloc
	 * @param xCellule2 est la premi�re coordonn�e de la cellule du coin bas droit du bloc
	 * @param yCellule2 est la deuxi�me coordonn�e de la cellule du coin bas droit du bloc
	 * @return un bloc
	 * @throws HorsFeuilleException si les coordonn�es ne correspondent � aucune cellule
	 */
	private Bloc creeBloc(int xCellule1, int yCellule1, int xCellule2, int yCellule2) throws HorsFeuilleException {
		TreeSet<Cellule> cellules = new TreeSet<Cellule>();
		for (int i = xCellule1; i <= xCellule2; i++) {
			for (int j = yCellule1; j <= yCellule2; j++) {
				cellules.add(this.getCellule(i, j));
			}
		}
		return new Bloc(cellules);
	}

	/**
	 * Enregistre la feuille dans le fichier entr� en param�tre
	 * @param file est une instance de fichier o� sera enregistr�e la feuille
	 * @throws IOException si une erreur dans les fichiers.
	 */
	public void enregistrer(File file) throws IOException {

		Path path = Paths.get(file.getPath());

		BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
		for (Cellule c : this.getCellules()) {
			writer.write(c.getFormule());
			if (c.getY() == yMax)
				writer.write("\n");
			else
				writer.write(" & ");
		}
		writer.close();
	}

	/**
	 * Ouvre une feuille enregistr�e dans le fichier entr� en param�tre
	 * @param file est une instance de fichier d'o� est ouvert la feuille
	 * @throws HorsFeuilleException Si il y a une erreur dans la feuille
	 * @throws IOException si une erreur dans les fichiers.
	 */
	public void ouvrir(File file) throws HorsFeuilleException, IOException {
		Path path = Paths.get(file.getPath());
		String str;

		BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		int x = 0;
		int y = 0;
		while ((str = reader.readLine()) != null) {
			y = 0;
			String[] formules = str.split("&");
			for (String formule : formules) {
				this.setCellule(x, y, formule);
				y++;
			}
			x++;
		}
		reader.close();
	}

	/**
	 * Pour test.
	 */
	public void affichageCellule() {
		Set<Cellule> listCellule = this.getCellules();

		for (Cellule c : listCellule) {
			float resultat = 0;
			String str = c.getX() + " " + c.getY() + " -> Formule : " + c.getFormule() + " Resultat : ";
			if (c.estVide()) {
				str += "";
			} else {
				try {
					resultat = c.getResultat();
					str += resultat;
				} catch (ErreurAffichage e) {
					// TODO Auto-generated catch block
					str += e.getMessage();
				}
			}
			System.out.println(str);
		}
	}
}
