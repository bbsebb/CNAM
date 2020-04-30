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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(valeur);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Operande))
			return false;
		Operande other = (Operande) obj;
		if (Float.floatToIntBits(valeur) != Float.floatToIntBits(other.valeur))
			return false;
		return true;
	}
	

}
