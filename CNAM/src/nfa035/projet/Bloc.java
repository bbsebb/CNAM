package nfa035.projet;

import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Cette classe est bloc de {@link Cellule celulles}
 * 
 * @author bbseb
 *
 */
public class Bloc extends Feuille {
	private int xCellule1, yCellule1, xCellule2, yCellule2;
	private Feuille f;

	public Bloc() {

	}

	public Bloc(int xDebut, int yDebut, int xFin, int yFin, Feuille f) throws  ErreurDepacementFeuilleException, ErreurCelluleException {
		super(xDebut, yDebut, xFin, yFin);
		if(xDebut>xFin || yDebut>yFin) {
			int temp = xDebut;
			xDebut=xFin;
			xFin=temp;
			temp = yDebut;
			yDebut=yFin;
			yFin=temp;
		}
		this.setxCellule1(xDebut);
		this.setxCellule2(xFin);
		this.setyCellule1(yDebut);
		this.setyCellule2(yFin);
		this.setF(f);
		this.setCellules();

	}

	private void setCellules() throws ErreurCelluleException {
		if (f != null) {
			Set<Entry<Cellule, Contenu>> entry = this.f.getCellules().entrySet();
			Iterator<Entry<Cellule, Contenu>> it = entry.iterator();
			while (it.hasNext()) {
				Entry<Cellule, Contenu> e = it.next();
				if ((e.getKey().getX() >= xCellule1 && e.getKey().getX() <= xCellule2)
						&& (e.getKey().getY() >= yCellule1 && e.getKey().getY() <= yCellule2)) {
					if (e.getValue() == null)
						throw new ErreurCelluleException();
					this.cellules.put(e.getKey(), e.getValue());
				}
			}
		}
	}

	/**
	 * @return the xCellule1
	 */
	public int getxCellule1() {
		return xCellule1;
	}

	/**
	 * @param xCellule1 the xCellule1 to set
	 */
	public void setxCellule1(int xCellule1) {
		this.xCellule1 = xCellule1;
	}

	/**
	 * @return the yCellule
	 */
	public int getyCellule1() {
		return yCellule1;
	}

	/**
	 * @param yCellule the yCellule to set
	 */
	public void setyCellule1(int yCellule) {
		this.yCellule1 = yCellule;
	}

	/**
	 * @return the xCellule2
	 */
	public int getxCellule2() {
		return xCellule2;
	}

	/**
	 * @param xCellule2 the xCellule2 to set
	 */
	public void setxCellule2(int xCellule2) {
		this.xCellule2 = xCellule2;
	}

	/**
	 * @return the yCellule2
	 */
	public int getyCellule2() {
		return yCellule2;
	}

	/**
	 * @param yCellule2 the yCellule2 to set
	 */
	public void setyCellule2(int yCellule2) {
		this.yCellule2 = yCellule2;
	}

	/**
	 * @return the f
	 */
	public Feuille getF() {
		return f;
	}

	/**
	 * @param f the f to set
	 * @throws ErreurDepacementFeuilleException 
	 */
	public void setF(Feuille f) throws ErreurDepacementFeuilleException {
		if (f.estCellule(this.getxCellule2(), this.getyCellule2()) && f.estCellule(this.getxCellule1(), this.getyCellule1()) ) {
			this.f = f;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((f == null) ? 0 : f.hashCode());
		result = prime * result + xCellule1;
		result = prime * result + xCellule2;
		result = prime * result + yCellule1;
		result = prime * result + yCellule2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Bloc))
			return false;
		Bloc other = (Bloc) obj;
		if (f == null) {
			if (other.f != null)
				return false;
		} else if (!f.equals(other.f))
			return false;
		if (xCellule1 != other.xCellule1)
			return false;
		if (xCellule2 != other.xCellule2)
			return false;
		if (yCellule1 != other.yCellule1)
			return false;
		if (yCellule2 != other.yCellule2)
			return false;
		return true;
	}

}
