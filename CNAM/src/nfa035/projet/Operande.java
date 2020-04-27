package nfa035.projet;

/**
 * Cette classe represente les valeurs simples contenues dans les {@link Cellule celulles}
 * @author bbseb
 *
 */
public class Operande implements Contenu{

	private float valeur;
	
	/**
	 * Constructeur de base, il met la valeur à 0
	 */
	public Operande() {
		this.valeur =0;
	}
	
	/**
	 * Constructeur avec une valeur
	 * @param valeur est la valeur de cette opérande.
	 */
	public Operande(float valeur) {
		this.valeur = valeur;
	}
	
	
	/**
	 * Permet de modifier la valeur
	 * @param valeur est la valeur de cette opérande.
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	
	
	@Override
	public String getFormule() {
		
		return String.valueOf(this.valeur);
	}

	@Override
	public float getResultat() {
		
		return this.valeur;
	}

}
