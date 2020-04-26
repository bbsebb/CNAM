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
	 * @param operande1 le operande1 à éditer
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
	 * @param operande2 le operande2 à éditer
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
	
	public void setFormule(T operande1, char operateur, U operande2) {
		 String i = "552"+((Cellule) operande1).getResultat();
		if (operande1 instanceof Cellule)
			if (operande2 instanceof Cellule)
				super.setFormule(((Cellule) operande1).getResultat() + operateur + (((Cellule) operande2).getResultatToString()));
			else if (operande2 instanceof Float)
				super.setFormule(((Cellule) operande1).getResultat() + operateur + (Float) operande2);
			else
				throw new IllegalArgumentException();
		if (operande1 instanceof Float)
			if (operande2 instanceof Cellule)
				super.setFormule((Float) operande1 + operateur + (((Cellule) operande2).getResultatToString()));
			else if (operande2 instanceof Float)
				super.setFormule((Float) operande1 + operateur + (Double) operande2);
			else
				throw new IllegalArgumentException();

	}

	private boolean isCycle() {
		return false;
	}


}
