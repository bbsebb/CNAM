package nfa035.projet2.cellule;

public class Valeur implements Contenu{
	private String formule;
	private float valeur;
	
	public Valeur(float valeur,String formule) {
		this.setValeur(valeur);
		this.setFormule(formule);
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

	private void setFormule(String formule) {
		this.formule = formule;
	}

	@Override
	public float getResultat() {
		// TODO Auto-generated method stub
		return this.getValeur();
	}

	@Override
	public String getFormule() {
		// TODO Auto-generated method stub
		return this.formule;
	}

}
