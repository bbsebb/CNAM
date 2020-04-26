package nfa10;

/**
 * Permet de créer une pile et d'empiler et de dÃ©piler
 * @author bbsebb
 *
 * @param <T> est l'object gÃ©nÃ©rique acceptÃ©
 */
public class PileTableau<T> {
	private int indice = 0;
	private T[] tab;

	public PileTableau() {

	}
/**
 * Crée une pile de n élément maximum
 * @param n est la taille maximum de la pile
 */
	@SuppressWarnings("unchecked")
	public PileTableau(int n) {
		this.tab = (T[]) new Object[n];
	}

	/**
	 * Permet d'empiler
	 * @param element est l'objet à  empiler
	 */
	public void empiler(T element) {
		if (estPlein()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			this.tab[indice] = element;
			this.indice++;
		}
	}
/**
 * Permet de dépiler
 * @return le premier object de la pile
 */
	public T depiler() {
		if (estVide()) {
			throw new ArrayIndexOutOfBoundsException();
		} else {
			this.indice--;
			return this.tab[indice];
		}
	}
/**
 * Teste si une pile est vide
 * @return vrai si elle est vide
 */
	private boolean estVide() {
		if (this.indice - 1 < 0)
			return true;
		else
			return false;
	}
/**
 * Teste si une pile est pleine
 * @return faux si elle est pleine
 */
	private boolean estPlein() {
		if (this.indice + 1 > this.tab.length)
			return true;
		else
			return false;
	}
}
