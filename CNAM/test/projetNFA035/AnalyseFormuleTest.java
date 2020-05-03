package projetNFA035;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import nfa035.projet2.AnalyseFormule;
import nfa035.projet2.CelluleVideException;
import nfa035.projet2.Feuille;
import nfa035.projet2.FormuleErroneeException;
import nfa035.projet2.HorsFeuilleException;

class AnalyseFormuleTest {
	static Feuille f;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		f = new Feuille(2, 2);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,0:1.0","0,2:0.2","100:100","-5,35:-5.35","1,5+1,3:2.8","8*10:80"}, delimiter = ':')
	void testFormuleToContenuTrue(String valeur,String valeurAttendu) throws  FormuleErroneeException, HorsFeuilleException,  CelluleVideException {
		AnalyseFormule af= new AnalyseFormule(f,valeur);
		assertTrue(Float.valueOf(valeurAttendu)==af.formuleToContenu().getResultat());
	}
	
	
	@Test
	void testFormuleToContenuNull() throws  FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		AnalyseFormule af= new AnalyseFormule(f,"");
		assertTrue(null==af.formuleToContenu());
	}
	
	
	@ParameterizedTest
	@CsvSource(value = {"1,0:1.2","0,2:0","100:1000","-5,35:5.35","1,5+1,3:2.801","8*10,1:80"}, delimiter = ':')
	void testFormuleToContenuFalse(String valeur,String valeurAttendu) throws  FormuleErroneeException, HorsFeuilleException, CelluleVideException {
		AnalyseFormule af= new AnalyseFormule(f,valeur);
		assertFalse(Float.valueOf(valeurAttendu)==af.formuleToContenu().getResultat());
	}
	@ParameterizedTest
	@ValueSource(strings = { "1,,5", "15++6", "--5","1.1" })
	void testFormuleToContenuThrowFormuleErronee(String valeur) throws  FormuleErroneeException, HorsFeuilleException {
		AnalyseFormule af= new AnalyseFormule(f,valeur);
		assertThrows(FormuleErroneeException.class, () ->af.formuleToContenu() );
	}
	@ParameterizedTest
	@ValueSource(strings = { "20.20" })
	void testFormuleToContenuThrowHorsFeuille(String valeur) throws  FormuleErroneeException, HorsFeuilleException {
		AnalyseFormule af= new AnalyseFormule(f,valeur);
		assertThrows(HorsFeuilleException .class, () ->af.formuleToContenu() );
	}

}
