package nfa035.projet2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import nfa035.projet2.exceptions.CelluleVideException;
import nfa035.projet2.exceptions.ErreurAffichage;
import nfa035.projet2.exceptions.FormuleErroneeException;
import nfa035.projet2.exceptions.HorsFeuilleException;
import nfa035.projet2.feuille.AnalyseFormule;
import nfa035.projet2.feuille.Feuille;

class AnalyseFormuleTest {
	static Feuille f;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		f = new Feuille(2, 2);
		f.setCellule(0, 0, "1,5");
		f.setCellule(0, 1, "-3");
		f.setCellule(1, 0, "2");
	}

	@ParameterizedTest
	@CsvSource(value = {
			"1,0:1.0"," 0325,25 :325.25"," 569,01234 :569.01234","123456:123456","-1:-1","-1,1:-1.1","0,0:0","35,-2,3:32.7",
			"1,2 * 20,5:24.6", "20,20+3,4:23.6", " 21/36,2:0.58011049723 ","1,2-3,4:-2.2","-1*5,2:-5.2","0*-3,5:-0","-0*5:-0","-2,2*-2,2:4.84","0.0+0.1:-1.5","0.1*0.0:-4.5",
			"Somme(0.0;0.1):-1.5"," Moyenne(0.0;0.1) :-0.75","somme(0.0;1.0):3.5"
			}, delimiter = ':')
	void testgetContenuTrue(String valeur,String valeurAttendu) throws  FormuleErroneeException, HorsFeuilleException,  ErreurAffichage, CelluleVideException{
		AnalyseFormule af= new AnalyseFormule(f,valeur);

			assertEquals(Float.valueOf(valeurAttendu),af.getContenu().getResultat());

	}
	
	
	@Test
	void testgetContenuNull() throws  FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		AnalyseFormule af= new AnalyseFormule(f,"");
		assertEquals(null,af.getContenu());
	
	}
	
	
	@ParameterizedTest
	@CsvSource(value = {"1,0:1.0001","-1,2:1.2","1,2:-1.2","-1:1","10:-10" }, delimiter = ':')
	void testgetContenuFalse(String valeur,String valeurAttendu) throws  FormuleErroneeException, HorsFeuilleException,  ErreurAffichage, CelluleVideException {
		AnalyseFormule af= new AnalyseFormule(f,valeur);

			assertNotEquals(Float.valueOf(valeurAttendu),af.getContenu().getResultat());

	}
	@ParameterizedTest
	@ValueSource(strings = { "1,,5", "15++6", "--5","12345 6789", "12,345,6789", "12,6a789",
			"Soeme(0.0;0.1)", "Somme(1.1;22.)","Somme(0.0;0.1","Soeme(0.0;0.1)", "Moyenne(0.0;01.)","Moyenne(0.0;0.1","Moyenne0.0;0.1)",
			"Moyene(0.0;0.1)","1.2 ** 20,5", "20,20+3.4+", " /2136,2 ","1.2 3.4","5,,5*2,3","5,5++2,3","5..5*2,3","5,5+ADD","35,27+-2.3","35,27+2.3+"})
	void testgetContenuThrowFormuleErronee(String valeur) throws  FormuleErroneeException, HorsFeuilleException {
		
		assertThrows(FormuleErroneeException.class, () ->new AnalyseFormule(f,valeur));
	}
	@ParameterizedTest
	@ValueSource(strings = { "20.20","Somme(0.0;2.2)" })
	void testgetContenuThrowHorsFeuille(String valeur) throws  FormuleErroneeException, HorsFeuilleException {
		
		assertThrows(HorsFeuilleException .class, () ->new AnalyseFormule(f,valeur) );
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "Somme(0.1;1.1)","Moyenne(0.1;1.1)" ,"1.1"})
	void testgetContenuThrowCelluleVide(String valeur) throws  FormuleErroneeException, HorsFeuilleException {
		
		assertThrows(CelluleVideException .class, () ->new AnalyseFormule(f,valeur) );
	}

}
