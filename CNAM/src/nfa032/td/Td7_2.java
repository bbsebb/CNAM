package nfa032.td;

import nfa032.td.td7.Canard;
import nfa032.td.td7.Poulet;
import nfa032.td.td7.Volailles;

public class Td7_2 {

	public static void main(String[] args) {
		
		// Exercice 6.2.1
		/*
		 * Question 1.1
		 * Voir annexe TD7
		 * Question 1.2
		 * << constructeur de Premiere
		 * ===================
		 * constructeur de Premiere
		 * constructeur de Seconde
		 * ===================
		 * constructeur de Premiere
		 * constructeur de Troisi�me
		 * ==================
		 * constructeur de Premiere
		 * constructeur de Troisi�me
		 * constructeur de Quatri�me
		 * Question 1.3
		 */
		new Premiere();
		Terminal.ecrireStringln("=============================");
		new Seconde(true);
		Terminal.ecrireStringln("=============================");
		new Troisieme(15);
		Terminal.ecrireStringln("=============================");
		new Quatrieme(12.3);
		Terminal.ecrireStringln("=============================");
		/*
		 * Question 1.4
		 * Non
		 * 
		 * Question 2.1
		 * <<
		 * constructeur de Premi�re
		 * constructeur de Cinquieme
		 * ==================
		 * constructeur de Premi�re
		 * constructeur de Cinquieme
		 * constructeur de Sixi�me >>
		 * Question 2.2
		 */
		new Cinquieme();
		Terminal.ecrireStringln("=============================");
		new Sixieme();
		Terminal.ecrireStringln("=============================");
		/*
		 * Question 3
		 *  Huiti�me dois entrer un parametre int dans son constructeur et le passer � la classe m�re.
		 *  Question 4.1
		 *  << constructeur de Premi�re
		 *  second constructeur de Neuvieme
		 *  premier constructeur de Dixieme
		 *  ==================
		 *  constructeur de Premi�re
		 *  premier constructeur de Neuvieme
		 *  second constructeur de Dixieme >>
		 *  Question 4.2
		 */
		new Dixieme(10.5);
		Terminal.ecrireStringln("=============================");
		new Dixieme(45, true);
		Terminal.ecrireStringln("=============================");
		/*
		 * Exercice 6.2.2
		 */
		Poulet p1 = new Poulet(920);
		Poulet p3 = new Poulet(1020);
		Poulet p4 = new Poulet(1020);
		Poulet p2 = new Poulet(1020);
		Canard c1 = new Canard(2500);
		Canard c2 = new Canard(1500);
		Canard c3 = new Canard(2500);
		Canard c4 = new Canard(2500);
		Poulet.setPoidsAbbatage(1000);
		Canard.setPoidsAbbatage(2000);
		Poulet.setPrix(100);
		Canard.setPrix(150);
		Volailles v = new Volailles();
		v.ajout(p1);
		v.ajout(p2);
		v.ajout(p3);
		v.ajout(p4);
		v.ajout(c4);
		v.ajout(c3);
		v.ajout(c2);
		v.ajout(c1);
		System.out.println(v.prixAbattage("canard"));
		System.out.println(v.prixAbattage("poulet"));
	}

	
}
class Premiere {
	Premiere() {
		Terminal.ecrireStringln("constructeur de Premiere");
	}
}

class Seconde extends Premiere {
	Seconde(boolean b) {
		super();
		Terminal.ecrireStringln("constructeur de Seconde");
	}
}

class Troisieme extends Premiere {
	Troisieme(int i) {
		super();
		Terminal.ecrireStringln("constructeur de Troisieme");
	}
}

class Quatrieme extends Troisieme {
	Quatrieme(double d) {
		super(14);
		Terminal.ecrireStringln("constructeur de Quatrieme");
	}
}

class Cinquieme extends Premiere {
	Cinquieme() {
		Terminal.ecrireStringln("constructeur de Cinquieme");
	}
}

class Sixieme extends Cinquieme {
	Sixieme() {
		Terminal.ecrireStringln("constructeur de Sixieme");
	}
}

class Septieme extends Premiere {
	Septieme(int i) {
		Terminal.ecrireStringln("constructeur de Septieme");
	}
}

class Huitieme extends Septieme {
	Huitieme(int i) {
		super(i);
		Terminal.ecrireStringln("constructeur de Huitieme");
	}
}

class Neuvieme extends Premiere {
	Neuvieme(int i) {
		Terminal.ecrireStringln("premier constructeur de Neuvieme");
	}

	Neuvieme(boolean b) {
		Terminal.ecrireStringln("second constructeur de Neuvieme");
	}
}

class Dixieme extends Neuvieme {
	Dixieme(double d) {
		super(true);
		Terminal.ecrireStringln("premier constructeur de Dixieme");
	}

	Dixieme(int x, boolean y) {
		super(x);
		Terminal.ecrireStringln("second constructeur de Dixieme");
	}
}