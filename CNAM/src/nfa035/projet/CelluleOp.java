package nfa035.projet;

public class CelluleOp<T, U> extends Cellule {

	private T operande1;
	private U operande2;
	private Operateur operateur;
	

	/**
	 * @return le operande1
	 */
	private T getOperande1() {
		return this.operande1;
	}

	/**
	 * @param operande1 le operande1 � �diter
	 */
	private void setOperande1(T operande1) {
		if(operande1 instanceof Cellule || operande1 instanceof Double)
		this.operande1 = operande1;
	}

	/**
	 * @return le operande2
	 */
	private U getOperande2() {
		return this.operande2;
	}

	/**
	 * @param operande2 le operande2 � �diter
	 */
	private void setOperande2(U operande2) {
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
	public String getFormule() {
		return "SQtring";
	}

	@Override
	public float getResultat() {

		return 0;
	}
	
	public void setFormule(T operande1, char operateur, U operande2) {


	}

	private boolean isCycle() {
		return false;
	}


}
