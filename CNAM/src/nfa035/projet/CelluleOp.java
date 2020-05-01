package nfa035.projet;

/**
 * Cette classe est un cellule poss�dant une op�ration arithm�tique simple {@link Operateur (liste op�rateur)} entre deux {@link Operande operandes} 
 * @author bbseb
 *
 */
public class CelluleOp extends Cellule implements Contenu{

	private Contenu operande1;
	private Contenu operande2;
	private Operateur operateur;
	
	public CelluleOp() {
		super();
		this.setOperande1(null);
		this.setOperande2(null);
		this.setOperateur(null);
	}
	
	public CelluleOp(int x, int y) {
		super(x,y);
	}
	public CelluleOp(int x, int y,Operande o1, Operande o2, Operateur op) {
		super(x,y);
		this.setOperande1(o1);
		this.setOperande2(o2);
		this.setOperateur(op);
	}
	/**
	 * @return le operande1
	 */
	private Contenu getOperande1() {
		return this.operande1;
	}

	/**
	 * @param operande1 le operande1 � �diter
	 */
	private void setOperande1(Contenu operande1) {
		this.operande1 = operande1;
	}

	/**
	 * @return le operande2
	 */
	private Contenu getOperande2() {
		return this.operande2;
	}

	/**
	 * @param operande2 le operande2 � �diter
	 */
	private void setOperande2(Contenu operande2) {
		this.operande2 = operande2;
	}

	/**
	 * @return le operateur
	 */
	private Operateur getOperateur() {
		return this.operateur;
	}

	/**
	 * @param operateur le operateur � �diter
	 */
	private void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	


	@Override
	public float getResultat() {

		return 0;
	}
	
	public void setFormule(Operande operande1, Operateur operateur, Operande operande2) {
		this.setOperande1(operande1);
		this.setOperande2(operande2);
		this.setOperateur(operateur);
	}

	


}
