package nfa035.projet2.feuille;

import java.util.LinkedList;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.cellule.Fonction;
import nfa035.projet2.cellule.Moyenne;
import nfa035.projet2.cellule.Operateur;
import nfa035.projet2.cellule.Operation;
import nfa035.projet2.cellule.Somme;
import nfa035.projet2.cellule.Valeur;
import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;

public class AnalyseFormule {
	private String formule;
	private Feuille feuille;
	private Contenu contenu;
	private LinkedList<Cellule> listCellules;

	public AnalyseFormule(Feuille feuille, String formule) throws FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		this.setFeuille(feuille);
		this.setFormule(formule);
		this.setCellulesLie(new LinkedList<Cellule>());
		this.setContenu(this.formuleToContenu());
	}

	public Contenu getContenu() {
		return this.contenu;
	}

	private void setContenu(Contenu contenu) {
		this.contenu = contenu;
	}

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

	public static boolean estValeur(String str) {
		str = str.trim().toLowerCase();
		if (str.isEmpty())
			return false;
		char[] chaine = str.toCharArray();
		int compteurVirgule = 0;
		int compteurNegatif = 0;
		for (int c : chaine) {
			if (c != 44 && c != 45 && (c < 48 || c > 57))
				return false;
			if (c == 44) {
				compteurVirgule++;
				if (compteurVirgule > 1 )
					return false;
			}
			if (c == 45) {
				compteurNegatif++;
				if (compteurNegatif > 1 || (compteurNegatif == 1 && chaine[0] != 44))
					return false;
			}
		}
		
		return true;
	}

	public static boolean estCellule(String str) {
		str = str.trim().toLowerCase();
		boolean rtr = true;
		String[] coordonnee = str.split("\\.");
		if (coordonnee.length != 2 || coordonnee[0].length() == 0 || coordonnee[1].length() == 0)
			rtr = false;
		for (String c : coordonnee) {
			char[] chaine = c.toCharArray();
			for (char car : chaine) {
				if (car < 48 || car > 57)
					rtr = false;
			}
		}
		return rtr;

	}

	public static boolean estOperation(String str) {

		str = str.trim().toLowerCase();
		String[] operandes = new String[0];
		Operateur operateur;
		try {
			operateur = stringToOperateur(str);
		} catch (FormuleErroneeException e) {
			// TODO Auto-generated catch block
			return false;
		}
		if (str.charAt(0) == '-' && (str.charAt(1) > 47 && str.charAt(1) < 58)) {
			operandes = str.substring(1).split(operateur.toRegex(), 2);
			operandes[0] = str.charAt(0) + operandes[0];
		} else if (str.charAt(0) > 47 && str.charAt(0) < 58)
			operandes = str.split(operateur.toRegex(), 2);
		else
			return false;
		if ((estCellule(operandes[0]) || estValeur(operandes[0]))
				&& (estCellule(operandes[1]) || estValeur(operandes[1])))
			return true;
		else
			return false;

	}

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
		int x, y;
		str = str.trim().toLowerCase();
		String[] coordonnee = str.split("\\.");
		x = (int) this.stringToValeur(coordonnee[0]);
		y = (int) this.stringToValeur(coordonnee[1]);
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
		for (int i = (str.charAt(0) == '-') ? 1 : 0; i < chaine.length; i++) {
			for (Operateur op : Operateur.values()) {
				if (chaine[i] == op.toChar()) {
					return op;
				}
			}
		}
		throw new FormuleErroneeException();
	}



}
