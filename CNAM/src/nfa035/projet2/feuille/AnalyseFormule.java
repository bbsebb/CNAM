package nfa035.projet2.feuille;

import java.util.LinkedList;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.cellule.Erreur;
import nfa035.projet2.cellule.Moyenne;
import nfa035.projet2.cellule.Operateur;
import nfa035.projet2.cellule.Operation;
import nfa035.projet2.cellule.Somme;
import nfa035.projet2.cellule.Valeur;
import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;

/**
 * <b> Cette classe permet d'�valuer et verifier un formule en rapport avec {@link Feuille une feuille} .</b>
 * <p> Elle permet de verifier si une formule est correcte et de retourner un contenu de cellule pertinent. Il existe 5 types de cellules correspondant � 5 syntaxe plus un contenu sp�cifique au erreur.
 * Les cellules sont repr�sent�e par leurs coordonn�es absolues ou relatives s�par�es par un point. Cette classe est li� � une feuille pour permettre l'�valuation de la formule</p>
 * <ul>
 * <li> Moyenne : moyenne(0.0;1.5) , la s�paration entre deux cellules se fait avec le ;. Insensible � la casse</li>
 * <li> Somme : somme(0.0;1.5) , la s�paration entre deux cellules se fait avec le ';'. Insensible � la casse</li>
 * <li> Operation : 5,6 + 3 , Les operations possibles sont list�es dans {@link Operateur cette enum�ration}</li>
 * <li> Valeur : -5,3, les nombres d�cimaux ou la d�cimale se fait apr�s une virgule ','</li>
 * </ul>
 * <p> Si il y a une erreur de syntaxe ou d'�valuation, un contenu sp�cifique sera renvoy�.
 *  Il ne doit pas y avoir d'espace � l'interieur d'une formule auquel cas, il y aura une erreur de syntaxe renvoy�e.</p>
 * @see Moyenne
 * @see Somme
 * @see Operation
 * @see Valeur
 * @see Erreur
 * @author bbseb
 *
 */
public class AnalyseFormule {
	/**
	 * La formule � �valuer
	 */
	private String formule;
	/**
	 * La feuille en rapport avec la formule. 
	 */
	private Feuille feuille;
	/**
	 * Le contenu de la cellule qui sera renvoy�
	 */
	private Contenu contenu;
	/**
	 * La liste des cellules dont d�pendent la cellule modifi�e
	 */
	private LinkedList<Cellule> listCellules;
	/**
	 * La cellule ou la formule sera modifi�e
	 */
	private Cellule c;

	/**
	 * Ce constructeur lie la feuille, v�rifie la syntaxe et �value la formule, ajoute les cellules qui d�pendent de la cellule modifi�e et cr�e un contenu. 
	 * @param feuille est la feuille li�
	 * @param formule est la formule � �valuer
	 * @param c est la cellule modifi�e
	 * @throws FormuleErroneeException si la syntaxe est erron�e ou il y a une mauvaise �valuation
	 * @throws HorsFeuilleException si la formule fait r�f�rence � une cellule hors feuille
	 * @throws CelluleVideException si la formule fait r�f�rence � une cellule vide
	 */
	public AnalyseFormule(Feuille feuille,Cellule c, String formule) throws FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		this.setFeuille(feuille);
		this.setC(c);
		this.setFormule(formule);
		this.setCellulesLie(new LinkedList<Cellule>());
		this.setContenu(this.formuleToContenu());
		
	}

	/**
	 * @return the c
	 */
	public Cellule getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(Cellule c) {
		this.c = c;
	}

	/**
	 * 
	 * @return le contenu d'une cellule
	 * @see Contenu
	 */
	public Contenu getContenu() {
		return this.contenu;
	}

	private void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

	/**
	 * 
	 * @return La liste des cellules dont d�pendent la cellule modifi�e
	 */
	LinkedList<Cellule> getCellulesLie() {
		return this.listCellules;
	}

	private void setCellulesLie(LinkedList<Cellule> ll) {
		this.listCellules = ll;
	}

	
	private Contenu formuleToContenu() throws FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		String f = this.getFormule();
		if (this.getFormule() == null || this.getFormule().isEmpty())
			return (Contenu) null;
		else if (estValeur(f))
			return this.formuleToValeur(f);
		else if (estCellule(f))
			return this.formuleToCellule(f);
		else if (estOperation(f))
			return this.formuleToOperation(f);
		else if (estFonction(f))
				return this.formuleToFonction(f);
		else
			throw new FormuleErroneeException();
	}

	private String getFormule() {
		return formule;
	}

	private void setFormule(String formule) {
		this.formule = formule.trim().toLowerCase();
	}

	private Feuille getFeuille() {
		return feuille;
	}

	private void setFeuille(Feuille feuille) {
		this.feuille = feuille;
	}

	/**
	 * Verifie si la chaine est une valeur. Les valeur sont les nombres d�cimaux ou la d�cimale se fait apr�s une virgule ','
	 * @param str la chaine a �valu�
	 * @return vrai si la chaine est une valeur, faux sinon
	 */
	public static boolean estValeur(String str) {
		boolean rtr = true;
		str = str.trim().toLowerCase();
		if (str.isEmpty())
			rtr = false;
		char[] chaine = str.toCharArray();
		int compteurVirgule = 0;
		int compteurNegatif = 0;
		for (int c : chaine) {
			if (c != 44 && c != 45 && (c < 48 || c > 57)) // doit contenur des chiffres ou une virgule ou un signe n�gatif
				rtr =  false;
			if (c == 44) {
				compteurVirgule++;
				if (compteurVirgule > 1 )
					rtr =  false;
			}
			if (c == 45) {
				compteurNegatif++;
				if (compteurNegatif > 1 || (compteurNegatif == 1 && chaine[0] != 45))
					rtr =  false;
			}
		}
		
		return rtr;
	}

	
	/**
	 * Verifie si la chaine est une cellule. Les cellules sont repr�sent�e uniquement par leurs coordonn�es s�par�es par un point '0.0'.
	 * Elles peuvent �tre relative.
	 * @param str la chaine a �valu�
	 * @return vrai si la chaine est une cellule, faux sinon
	 */
	public static boolean estCellule(String str) {
		str = str.trim().toLowerCase();
		boolean relative = (str.charAt(0) == '$')? true: false;
		boolean rtr = true;
		if(relative)
			str = str.substring(1);
		String[] coordonnee = str.split("\\.");
		if (coordonnee.length != 2 || coordonnee[0].length() == 0 || coordonnee[1].length() == 0) // un seul point pour les coordon�es
			rtr = false;
		for (String c : coordonnee) {
			char[] chaine = c.toCharArray();
			for (int i = 0; i<chaine.length;i++) {
				if(chaine[0] == 45)
					continue;
				if (chaine[i] < 48 || chaine[i] > 57 ) // si les coordonn�es sont bien des chiffres
					rtr = false;
			}
		}
		return rtr;

	}

	/**
	 * V�rifie si la chaine est une op�ration. Les operations possibles sont list�es dans {@link Operateur cette enum�ration}
	 * @param str la chaine a �valu�
	 * @return vrai si la chaine est une op�ration, faux sinon
	 */
	public static boolean estOperation(String str) {

		boolean rtr = true;
		str = str.trim().toLowerCase();
		String[] operandes = new String[0];
		Operateur operateur; 
		try {
			operateur = stringToOperateur(str); // On r�cup�re l'operateur (g�re les valeurs n�gatives)
		} catch (FormuleErroneeException e) {
			rtr = rtr && false;
			operateur = null;
		}
		if (str.charAt(0) == '-' && (str.charAt(1) > 47 && str.charAt(1) < 58) && operateur != null) { // Si la premi�re op�rande est n�gative
			operandes = str.substring(1).split(operateur.toRegex(), 2);
			operandes[0] = str.charAt(0) + operandes[0];
		} else if (str.charAt(0) > 47 && str.charAt(0) < 58 && operateur != null)
			operandes = str.split(operateur.toRegex(), 2);
		else
			rtr =  rtr && false;
		if (operandes.length !=0 && operateur != null && (estCellule(operandes[0]) || estValeur(operandes[0]))
				&& (estCellule(operandes[1]) || estValeur(operandes[1])))
			rtr = rtr && true;
		else
			rtr = rtr && false;
		return rtr;

	}

	/**
	 * V�rifie si la chaine est une fonction somme() ou moyenne(). 
	 * @param str la chaine a �valu�
	 * @return vrai si la chaine est une fonction, faux sinon
	 */
	public static boolean estFonction(String str) {
		boolean rtr;
		if (estSomme(str) || estMoyenne(str))
			rtr= true;
		else
			rtr= false;
		return rtr;
	}

	private static boolean estSomme(String str) {
		boolean rtr = true ;
		str = str.trim().toLowerCase();
		if(str.startsWith("somme(") && str.endsWith(")")) {
			str = str.substring(6, str.length()-1);
		} else
			rtr = false;
		
		String operandes[] = str.split(";");
		if(operandes.length != 2) {
			if (!estCellule(operandes[0]) || !estCellule(operandes[1]))
				rtr = false;
		}
		
		return rtr;
		
		

	}

	private static boolean estMoyenne(String str) {
		boolean rtr = true ;
		str = str.trim().toLowerCase();
		if(str.startsWith("moyenne(") && str.endsWith(")")) {
			str = str.substring(8, str.length()-1);
		} else
			rtr = false;
		
		String operandes[] = str.split(";");
		if(operandes.length != 2) {
			if (!estCellule(operandes[0]) || !estCellule(operandes[1]))
				rtr = false;
		}
		
		return rtr;

	}

	private Contenu formuleToValeur(String str) {
		return (Contenu) new Valeur(this.stringToValeur(str), this.getFormule());
	}

	private Contenu formuleToCellule(String str) throws HorsFeuilleException,  CelluleVideException, FormuleErroneeException {
		if(!estCellule(str))
			throw new FormuleErroneeException();
		boolean relative = false;
		int x, y;
		str = str.trim().toLowerCase();
		if(str.charAt(0) == '$') {
			relative = true;
			str = str.substring(1);
		}
		String[] coordonnee = str.split("\\.");
		x = (int) this.stringToValeur(coordonnee[0]);
		y = (int) this.stringToValeur(coordonnee[1]);
		x = (relative)? x + this.getC().getX() : x ;
		y = (relative)? y + this.getC().getY() : y ;
		if (this.getFeuille().estCelluleVide(x, y))
			throw new CelluleVideException();
		else {
			Cellule c = this.getFeuille().getCellule(x, y);
			this.getCellulesLie().add(c);
			return (Contenu) c;
		}

	}

	private Contenu formuleToOperation(String str) throws FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		str = str.trim().toLowerCase();
		Operateur operateur = stringToOperateur(str);
		Contenu operande1, operande2;
		String[] operandes;
		if (str.charAt(0) == '-') {
			operandes = str.substring(1).split(operateur.toRegex(), 2);
			operandes[0] = str.charAt(0) + operandes[0];
		} else
			operandes = str.split(operateur.toRegex(), 2);
		if (estCellule(operandes[0]))
			operande1 = (Contenu) this.formuleToCellule(operandes[0]);
		else if (estValeur(operandes[0]))
			operande1 = this.formuleToValeur(operandes[0]);
		else
			throw new FormuleErroneeException();
		if (estCellule(operandes[1]))
			operande2 = (Contenu) this.formuleToCellule(operandes[1]);
		else if (estValeur(operandes[1]))
			operande2 = this.formuleToValeur(operandes[1]);
		else
			throw new FormuleErroneeException();
		return (Contenu) new Operation(operande1, operande2, operateur, this.getFormule());
	}

	private Contenu formuleToFonction(String str) throws HorsFeuilleException, CelluleVideException, FormuleErroneeException {
		Bloc b;
		Contenu f;
		
		str = str.trim().toLowerCase();
		String strInit = str;
		if(estMoyenne(str)) {
			str = str.substring(8, str.length()-1);
		} else if (estSomme(str)) {
			str = str.substring(6, str.length()-1);
		} else
			throw new FormuleErroneeException();
			
		String operandes[] = str.split(";");
		
		b = this.getFeuille().creeBloc((Cellule) this.formuleToCellule(operandes[0]),(Cellule) this.formuleToCellule(operandes[1]));
		if (b.estSansCelluleVide()) {
			this.setCellulesLie(new LinkedList<Cellule>(b.getCellules()));
			if (estMoyenne(strInit))
				f=  new Moyenne(b, this.getFormule());
			else
				f=  new Somme(b, this.getFormule());
		} else
			throw new CelluleVideException();
		
		return f;
		
		
		
		

	}
	


	private float stringToValeur(String str) {
		str = str.trim().toLowerCase();
		float signe = 1f;
		if ('-' == str.charAt(0)) {
			signe = -1f;
			str = str.substring(1);
		}
		char[] chaine = str.toCharArray();
		double i = 1;
		int j = 0;
		if (str.indexOf(',') >= 0)
			j = chaine.length - str.indexOf(',');
		for (; j < chaine.length - 1; j++) {
			i = i * 10;
		}
		double rtr = 0;
		for (int c : chaine) {
			if (c == 44)
				continue;
			rtr = rtr + (c - 48) * i;
			i = i / 10;
		}
		return (float) rtr * signe;

	}

	private static Operateur stringToOperateur(String str) throws FormuleErroneeException {
		char[] chaine = str.toCharArray();
		for (int i = (str.charAt(0) == '-') ? 1 : 0; i < chaine.length; i++) { // si la premi�re valeur est n�gative, on n'utilise pas ce signe.
			for (Operateur op : Operateur.values()) {
				if (chaine[i] == op.toChar()) {
					return op;
				}
			}
		}
		throw new FormuleErroneeException();
	}



}
