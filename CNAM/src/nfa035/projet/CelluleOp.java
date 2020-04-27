package nfa035.projet;

/**
 * Cette classe est un cellule possédant une opération arithmétique simple {@link Operateur (liste opérateur)} entre deux {@link Operande operandes} 
 * @author bbseb
 *
 */
public class CelluleOp extends Cellule {

	private Operande operande1;
	private Operande operande2;
	private Operateur operateur;
	

	/**
	 * @return le operande1
	 */
	private Operande getOperande1() {
		return this.operande1;
	}

	/**
	 * @param operande1 le operande1 à éditer
	 */
	private void setOperande1(Operande operande1) {
		this.operande1 = operande1;
	}

	/**
	 * @return le operande2
	 */
	private Operande getOperande2() {
		return this.operande2;
	}

	/**
	 * @param operande2 le operande2 à éditer
	 */
	private void setOperande2(Operande operande2) {
		this.operande2 = operande2;
	}

	/**
	 * @return le operateur
	 */
	private Operateur getOperateur() {
		return this.operateur;
	}

	/**
	 * @param operateur le operateur à éditer
	 */
	private void setOperateur(Operateur operateur) {
		this.operateur = operateur;
	}
	
	@Override
	public String getFormule() {
		return "SQtring";
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
