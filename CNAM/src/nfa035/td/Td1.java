package nfa035.td;

import nfa035.td.compte.Compte;
import nfa035.td.compte.Decouvert;
import nfa035.td.compte.MontantNegatif;

public class Td1 {

	public static void main(String[] args) {
		
		Compte c = new Compte(100, "Albert");
		try{
		c.depot(100);
		c.retrait(-60);
		}
		catch (MontantNegatif e) {}
		catch (Decouvert d) {}
		c.affiche();
	}

}
