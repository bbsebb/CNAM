package nfa035.projet2.feuille;

import java.util.Iterator;
import java.util.Observable;
import java.util.Set;
import java.util.TreeSet;

import nfa035.projet2.cellule.Contenu;
import nfa035.projet2.cellule.Erreur;
import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.CircuitException;
import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;

public class Feuille {
	protected TreeSet<Cellule> cellules;
	protected int xMax, yMax;
	
	protected Feuille() {

	}

	public Feuille(int nbrLigne, int nbrColonne) throws HorsFeuilleException {
		this.setCellules(this.creeFeuille(0, 0, nbrLigne - 1, nbrColonne - 1));
		this.setxMax(nbrLigne - 1);
		this.setyMax(nbrColonne - 1);
	}



	/**
	 * @return the cellules
	 */
	public Set<Cellule> getCellules() {
		return cellules;
	}

	/**
	 * @param cellules the cellules to set
	 */
	protected void setCellules(TreeSet<Cellule> cellules) {
		this.cellules = cellules;
	}

	/**
	 * @return the xMax
	 */
	protected int getxMax() {
		return xMax;
	}

	/**
	 * @param xMax the xMax to set
	 */
	private void setxMax(int xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMax
	 */
	protected int getyMax() {
		return yMax;
	}

	/**
	 * @param yMax the yMax to set
	 */
	private void setyMax(int yMax) {
		this.yMax = yMax;
	}

	public void setCellule(int x, int y, String formule) throws HorsFeuilleException {
		Cellule c = this.getCellule(x, y);
		try {

			AnalyseFormule af = new AnalyseFormule(this, formule);
			c.setFormule(formule);
			c.setContenu(af.getContenu());
			c.setCellulesLie(af.getCellulesLie());
		} catch (HorsFeuilleException | FormuleErroneeException | CircuitException | CelluleVideException e) {
			// TODO Auto-generated catch block
			c.setFormule(formule);
			c.setContenu((Contenu) new Erreur(e.getMessage()));
			c.clearCellulesLie();
		}
	}

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

	public boolean estCelluleVide(int x, int y) throws HorsFeuilleException {
		if (this.getCellule(x, y).estVide())
			return true;
		else
			return false;
	}

	private TreeSet<Cellule> creeFeuille(int xCellule1, int yCellule1, int xCellule2, int yCellule2)
			throws HorsFeuilleException {
		if (xCellule1 < 0 || xCellule2 < 0 || yCellule1 < 0 || yCellule2 < 0)
			throw new HorsFeuilleException();
		this.setCellules(new TreeSet<Cellule>());
		for (int i = xCellule1; i <= xCellule2; i++) {
			for (int j = yCellule1; j <= yCellule2; j++) {
				this.getCellules().add(new Cellule(i, j));
			}
		}
		return cellules;
	}
	
	public Bloc creeBloc(Cellule c1, Cellule c2) throws HorsFeuilleException {
		if(this.getCellules().contains(c1) && this.getCellules().contains(c2))
			return creeBloc(c1.getX(),c1.getY(),c2.getX(),c2.getY());
		else
			throw new HorsFeuilleException();
	}
	
	public Bloc creeBloc(int xCellule1, int yCellule1, int xCellule2, int yCellule2) throws HorsFeuilleException {
		TreeSet<Cellule> cellules = new TreeSet<Cellule>();
		for (int i = xCellule1; i <= xCellule2; i++) {
			for (int j = yCellule1; j <= yCellule2; j++) {
				cellules.add(this.getCellule(i, j));
			}
		}
		return new Bloc(cellules);
	}

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
					str += e.getMessage() ;
				}
			}
			System.out.println(str);
		}
	}
}
