package nfa032.td.td4;



import java.util.Scanner;

public class Menu {
	String[] menu;
	int choix;

	public Menu () {
		this.menu = new String[0];
	}
	
	public Menu (String[] menu) {
		this.menu = menu;
	}
	
	public static int saisirChoix(int n) throws erreurChoix,erreurN, erreurInt{
		int r;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisir un nombre entre 1 et "+ n);
		if(sc.hasNextInt()) {
			r = sc.nextInt();
		} else {
			throw new erreurInt();
		}
		if(r>n) {
			throw new erreurChoix();
		}
		if(n<=1) {
			throw new erreurN();
		}
		
		return r;
	}
	
	void affichageMenu () {
		int i = 1;
		for(String str : this.menu) {
			System.out.println(" Choix " + i +" : " +str);
			i++;
		}
	}
	
	public void choix () {
		affichageMenu();
		try {
			this.choix = saisirChoix(this.menu.length); 
		} catch (erreurChoix | erreurN | erreurInt e) {
			System.out.println("Une erreur est survenu: "+e.getMessage());
			System.out.println("Une erreur est survenu: "+e.toString());
		}
		
	}
}
class erreurChoix extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;};
class erreurN extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;};
	
class erreurInt extends Exception {
	public String toString() {
		return "Il faut entrer un chiffre";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;} ;