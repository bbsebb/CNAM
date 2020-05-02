package nfa035.projet2;

public class Valeur implements Contenu{

	private float valeur;
	
	public Valeur(float valeur) {
		this.setValeur(valeur);
	}
	
	/**
	 * @return the valeur
	 */
	private float getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	private void setValeur(float valeur) {
		this.valeur = valeur;
	}

	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		return this.getValeur();
	}

}
