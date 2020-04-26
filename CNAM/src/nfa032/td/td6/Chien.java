package nfa032.td.td6;
/**
 * Permet d'instancier un chat. Class d'apprentissage.
 * @author Seb
 * @see Crier
 * @see Chat
 * @see Lapin
 */
public class Chien implements Crier{
	/**
	 * Affiche le cri de l'animal sur la console
	 */
	@Override
	public void crier() {
		System.out.println("Ouaaf");	
	}

}
